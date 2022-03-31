package com.example.tourist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class village1MyAdapter extends RecyclerView.Adapter<village1MyAdapter.MyViewHolder> {


   Context context;

   ArrayList<villageget1> list;


   public village1MyAdapter(Context context, ArrayList<villageget1> list) {
       this.context = context;
       this.list = list;
   }

   @NonNull
   @Override
   public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(context).inflate(R.layout.villistcardview,parent,false);
       return  new MyViewHolder(v);

   }

   @Override
   public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

       villageget1 villageget1 = list.get(position);
       holder.village_name.setText(villageget1.getVillage_name());
       //String village= villageget1.getVillage_name();
     holder.Popular_for.setText(villageget1.getPopular_for());

       holder.Famous_Attraction.setText(villageget1.getFamous_Attraction());

       holder.Population.setText(villageget1.getPopulation());

       holder.Male_population.setText(villageget1.getMale_population());

       holder.Female_Population.setText(villageget1.getFemale_Population());

       holder.Tahsil.setText(villageget1.getTahsil());

       holder.District.setText(villageget1.getDistrict());

       holder.Area_pincode.setText(villageget1.getArea_pincode());

       holder.Area_under_farming.setText(villageget1.getArea_under_farming());

       holder.HOJ.setText(villageget1.getHOJ());

       holder.Post.setText(villageget1.getPost());

       holder.Sarpanch.setText(villageget1.getSarpanch());
       //Image

       Picasso.get()
               .load(villageget1.getImageURL())
               .placeholder(R.drawable.ic_launcher_background)
               .fit()
               .centerCrop()
               .into(holder.image);



   }
//






   //
   @Override
   public int getItemCount() {
       return list.size();
   }

   public class MyViewHolder extends RecyclerView.ViewHolder{

       TextView  lastName;
       TextView age;
       TextView village_name;
       TextView Area_under_farming;
       TextView Area_pincode;
       TextView District;
       TextView Famous_Attraction;
       TextView Female_Population;
       TextView Male_population;
       TextView Popular_for;
       TextView Population;
       TextView Sarpanch;
       TextView imageURL;
       TextView HOJ;
       TextView Post;
       TextView Tahsil;;
ImageView image;
       public MyViewHolder(@NonNull View itemView) {
           super(itemView);

           village_name = itemView.findViewById(R.id.tvfirstName);
           Popular_for = itemView.findViewById(R.id.tvPopular);
           Famous_Attraction = itemView.findViewById(R.id.tvfamous);
           Population = itemView.findViewById(R.id.tvpopulation);
           Male_population = itemView.findViewById(R.id.tvmale);
           Female_Population = itemView.findViewById(R.id.tvfemale);
           Tahsil = itemView.findViewById(R.id.tvtahsil);
           District = itemView.findViewById(R.id.tvdist);
           Area_pincode = itemView.findViewById(R.id.tvpincode);
           Area_under_farming = itemView.findViewById(R.id.tvfarming);
           HOJ = itemView.findViewById(R.id.tvhoj);
           Post = itemView.findViewById(R.id.tvpost);
           Sarpanch = itemView.findViewById(R.id.tvsarpanch);
           image = itemView.findViewById(R.id.img);
       }
   }

}




//
//import android.view.ContextMenu;
//
//import android.view.Menu;
//import android.view.MenuItem;
//
//
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//
//public  class village1MyAdapter extends RecyclerView.Adapter<village1MyAdapter.RecyclerViewHolder>{
//
//    Context context;
//
//    ArrayList<villageget1> list;
//
//
//    public village1MyAdapter(Context context, ArrayList<villageget1> list) {
//        this.context = context;
//        this.list = list;
//    }
//
//    @Override
//    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View v = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
//        return new RecyclerViewHolder(v);
//    }
//
//    @Override
//    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
//        villageget1 user = list.get(position);
//        holder.nameTextView.setText(user.getVillage_name());
//        holder.descriptionTextView.setText(user.getDistrict());
//        holder.dateTextView.setText(getDateToday());
//        Picasso.get()
//                .load(user.getImageURL())
//                .placeholder(R.drawable.ic_launcher_background)
//                .fit()
//                .centerCrop()
//                .into(holder.teacherImageView);
//    }
//
//    @Override
//    public int getItemCount() {
//        return list.size();
//    }
//
//    public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,
//            View.OnCreateContextMenuListener, MenuItem.OnMenuItemClickListener {
//
//        public TextView nameTextView,descriptionTextView,dateTextView;
//        public ImageView teacherImageView;
//
//        public RecyclerViewHolder(View itemView) {
//            super(itemView);
//            nameTextView =itemView.findViewById ( R.id.tvsarpanch );
//            descriptionTextView = itemView.findViewById(R.id.tvpost);
//            dateTextView = itemView.findViewById(R.id.tvhoj);
//            teacherImageView = itemView.findViewById(R.id.img);
//
//            itemView.setOnClickListener(this);
//            itemView.setOnCreateContextMenuListener(this);
//        }
//
//
//
//        @Override
//        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
//            menu.setHeaderTitle("Select Action");
//            MenuItem showItem = menu.add( Menu.NONE, 1, 1, "Show");
//            MenuItem deleteItem = menu.add(Menu.NONE, 2, 2, "Delete");
//
//            showItem.setOnMenuItemClickListener(this);
//            deleteItem.setOnMenuItemClickListener(this);
//        }
//
//
//        @Override
//        public boolean onMenuItemClick(MenuItem item) {
//            return false;
//        }
//
//        @Override
//        public void onClick(View v) {
//
//        }
//    }
//
//    public interface OnItemClickListener {
//        void onItemClick(int position);
//        void onShowItemClick(int position);
//        void onDeleteItemClick(int position);
//    }
//
//
//    private String getDateToday(){
//        DateFormat dateFormat=new SimpleDateFormat("yyyy/MM/dd");
//        Date date=new Date();
//        String today= dateFormat.format(date);
//        return today;
//    }
//}
