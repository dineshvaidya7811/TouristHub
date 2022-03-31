package com.example.tourist;


import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class VillageUtils {

    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static List<Villagegetset> DataCache =new ArrayList<>();

    public static String searchString = "";

    public static void show(Context c,String message){
        Toast.makeText(c, message, Toast.LENGTH_SHORT).show();
    }

    public static void openActivity(Context c,Class clazz){
        Intent intent = new Intent(c, clazz);
        c.startActivity(intent);
    }

    /**
     * This method will allow us send a serialized villagegetset objec  to a specified
     *  activity
     */
    public static void sendScientistToActivity(Context c, Villagegetset villagegetset,
                                               Class clazz){
        Intent i=new Intent(c,clazz);
        i.putExtra("SCIENTIST_KEY", villagegetset);
        c.startActivity(i);
    }

    /**
     * This method will allow us receive a serialized scientist, deserialize it and return it,.
     */
    public  static Villagegetset receiveScientist(Intent intent, Context c){
        try {
            return (Villagegetset) intent.getSerializableExtra("SCIENTIST_KEY");
        }catch (Exception e){
            e.printStackTrace();
            show(c,"RECEIVING-SCIENTIST ERROR: "+e.getMessage());
        }
        return null;
    }

    public static void showProgressBar(ProgressBar pb){
        pb.setVisibility(View.VISIBLE);
    }
    public static void hideProgressBar(ProgressBar pb){
        pb.setVisibility(View.GONE);
    }

    public static DatabaseReference getDatabaseRefence() {
        return FirebaseDatabase.getInstance().getReference();
    }

    public static void search(final AppCompatActivity a, DatabaseReference db,
                              final ProgressBar pb,
                              VillageMyAdapter adapter, String searchTerm) {
        if(searchTerm != null && searchTerm.length()>0){
            char[] letters=searchTerm.toCharArray();
            String firstLetter = String.valueOf(letters[0]).toUpperCase();
            String remainingLetters = searchTerm.substring(1);
            searchTerm=firstLetter+remainingLetters;
        }

        VillageUtils.showProgressBar(pb);

    Query firebaseSearchQuery = db.child("Add Request").orderByChild("village_name").startAt(searchTerm)
                .endAt(searchTerm + "\uf8ff");


        firebaseSearchQuery.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                DataCache.clear();
                if (dataSnapshot.exists() && dataSnapshot.getChildrenCount() > 0) {
                    for (DataSnapshot ds : dataSnapshot.getChildren()) {
                        //Now get Villagegetset Objects and populate our arraylist.
                        Villagegetset villagegetset = ds.getValue(Villagegetset.class);
                        villagegetset.setVillage_name(ds.getKey());
                        DataCache.add(villagegetset);
                    }
                    adapter.notifyDataSetChanged();
                }else {
                    VillageUtils.show(a,"No item found");
                }
                VillageUtils.hideProgressBar(pb);

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d("FIREBASE CRUD", databaseError.getMessage());
                VillageUtils.hideProgressBar(pb);
                VillageUtils.show(a,databaseError.getMessage());
            }
        });
    }

    public static void select(final AppCompatActivity a, DatabaseReference db,
                              final ProgressBar pb,
                              final RecyclerView rv, VillageMyAdapter adapter) {
        VillageUtils.showProgressBar(pb);

        db.child("Add Request").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
//                DataCache.clear();
//                if (dataSnapshot.exists() && dataSnapshot.getChildrenCount() > 0) {
//                    for (DataSnapshot ds : dataSnapshot.getChildren()) {
//                        //Now get Villagegetset Objects and populate our arraylist.
//                        Villagegetset scientist = ds.getValue(Villagegetset.class);
//                        scientist.setArea_pincode(ds.getKey());
//                        DataCache.add(scientist);
//                    }
//
//                    adapter.notifyDataSetChanged();
//                }else {
//                   // VillageUtils.show(a,"No more item found");
//                }
                VillageUtils.hideProgressBar(pb);

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d("FIREBASE CRUD", databaseError.getMessage());
                VillageUtils.hideProgressBar(pb);
                VillageUtils.show(a,databaseError.getMessage());
            }
        });
    }

}
//end
