package com.example.tourist;



import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Add_Request extends AppCompatActivity {
    Button btnbrowse, btnupload;
    TextView txtdata ;
    ImageView imgview;
    TextView E1,E2,E3,E4,E5,E6,E7,E8,E9,E10,E11,E12,E13 ;
    // Initializing the ImageView
    ImageView rImage;

    TextView Name1,popular,Population,Tahsil,Male_Population,Female_population,District,Pincode,Farming_Area,Famous_for;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_request);


        //
        E1= findViewById(R.id.e1);
        E2= findViewById(R.id.e2);
        E3= findViewById(R.id.e3);
        E4= findViewById(R.id.e4);
        E5= findViewById(R.id.e5);
        E6= findViewById(R.id.e6);
        E7=  findViewById(R.id.e7);
        E8=  findViewById(R.id.e8);
        E9=  findViewById(R.id.e9);
        E10=  findViewById(R.id.e10);
        E11=  findViewById(R.id.e11);
        E12=  findViewById(R.id.e12);
        E13=  findViewById(R.id.E13);


//        txtdata =  findViewById(R.id.txtdata);
//        imgview = (ImageView)findViewById(R.id.image_view);
//        // getting ImageView by its id
      rImage = findViewById(R.id.image_view);
//        Name1=findViewById(R.id.name);
//        popular=findViewById(R.id.popular);
//        Population=findViewById(R.id.population);
//        Male_Population=findViewById(R.id.male_population);
//        Female_population=findViewById(R.id.Female_population);
//        Tahsil=findViewById(R.id.Tahsil);
//        District=findViewById(R.id.District);

        // we will get the default FirebaseDatabase instance
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();

        // we will get a DatabaseReference for the database root node
        DatabaseReference databaseReference = firebaseDatabase.getReference();

        //data
        //DatabaseReference getdata = FirebaseDatabase.getInstance().getReference().child("Add Request");

        DatabaseReference itemsRef = FirebaseDatabase.getInstance().getReference().child("Add Request");
        ValueEventListener eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds :dataSnapshot.getChildren()             ) {
                    String name = ds.getKey();
                    DatabaseReference getdata = FirebaseDatabase.getInstance().getReference().child("Add Request").child(name);
                    getdata.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot datasnapshot) {

                            String dist = datasnapshot.child("District").getValue(String.class);
                            String Pincode = datasnapshot.child("Area_pincode").getValue(String.class);
                            String Area = datasnapshot.child("Area_under_farming").getValue(String.class);
                            String famous = datasnapshot.child("Famous_Attraction").getValue(String.class);
                            String HOJ = datasnapshot.child("HOJ").getValue(String.class);
                            String post = datasnapshot.child("Post").getValue(String.class);
                            String Female = datasnapshot.child("Female_Population").getValue(String.class);
                            String Male = datasnapshot.child("Male_population").getValue(String.class);
                            String Popular = datasnapshot.child("Popular_for").getValue(String.class);
                            String population = datasnapshot.child("Population").getValue(String.class);
                            String Sarpanch = datasnapshot.child("Sarpanch").getValue(String.class);
                            String Tahsil1 = datasnapshot.child("Tahsil").getValue(String.class);
                            String Name = datasnapshot.child("village_name").getValue(String.class);
                            //  String img = datasnapshot.child("imageURL").getValue(String.class);

                            E1.setText(Name);
                            E2.setText(Tahsil1);
                            E3.setText(dist);
                            E4.setText(post);
                            E5.setText(Sarpanch);
                            E6.setText(HOJ);


                           E7.setText(population);

                            E8.setText(Male);
                            E9.setText(Female);
                            E10.setText(famous);
                            E11.setText(Popular);
                            E12.setText(Pincode);
                            E13.setText(Area);


                            // set up the RecyclerView

                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                    //Image
                    DatabaseReference getImage = databaseReference.child("Add Request").child(name).child("imageURL");
                    getImage.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            // getting a DataSnapshot for the location at the specified
                            // relative path and getting in the link variable
                            String link = dataSnapshot.getValue(String.class);

                            // loading that data into rImage
                            // variable which is ImageView
                            Picasso.get().load(link).into(rImage);
                        }

                        // this will called when any problem
                        // occurs in getting data
                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            // we are showing that error message in toast
                            Toast.makeText(Add_Request.this, "Error Loading Image", Toast.LENGTH_SHORT).show();
                        }
                    });

                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d("TAG", databaseError.getMessage()); //Don't ignore potential errors!
            }
        };

        itemsRef.addListenerForSingleValueEvent(eventListener);



        // Adding listener for a single change
        // in the data at this location.
        // this listener will triggered once
        // with the value of the data at the location

    }
}
