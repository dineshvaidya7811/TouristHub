package com.example.tourist;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.squareup.picasso.Picasso;

public class VillageDetailActivity extends AppCompatActivity {

    private TextView villagename,pincode,population,male,female,tahsil,district,sarpanch,hoj,post,famous,popular,AUF;
    private Villagegetset Villagerecieved;
    private ImageView img;
    private CollapsingToolbarLayout mCollapsingToolbarLayout;

    private void initializeWidgets(){
        villagename= findViewById(R.id.villagename);
        pincode= findViewById(R.id.pincode1);
        population= findViewById(R.id.population);
        img=findViewById(R.id.scientistImg);
        male= findViewById(R.id.male);
        female= findViewById(R.id.female);
        tahsil= findViewById(R.id.tahsil);
        district= findViewById(R.id.district);
        sarpanch=findViewById(R.id.sarpanch);
        hoj=findViewById(R.id.hoj);
        post=findViewById(R.id.post);
        famous=findViewById(R.id.famous);
        popular=findViewById(R.id.popular);
        AUF=findViewById(R.id.AUF);
       // FloatingActionButton editFAB = findViewById(R.id.editFAB);
        mCollapsingToolbarLayout=findViewById(R.id.mCollapsingToolbarLayout);
        mCollapsingToolbarLayout.setExpandedTitleColor(getResources().
                getColor(R.color.white));
    }
    private void receiveAndShowData(){
         Villagerecieved= VillageUtils.receiveScientist(getIntent(), VillageDetailActivity.this);

         if(Villagerecieved != null){

             Picasso.get()
                     .load(Villagerecieved.getImageURL())
                     .placeholder(R.drawable.ic_launcher_background)
                     .fit()
                     .centerCrop()
                     .into(img);
             villagename.setText(Villagerecieved.getVillage_name());
             pincode.setText(Villagerecieved.getArea_pincode());
             population.setText(Villagerecieved.getPopulation());
             male.setText(Villagerecieved.getMale_population());
             female.setText(Villagerecieved.getFemale_Population());
             tahsil.setText(Villagerecieved.getTahsil());
             district.setText(Villagerecieved.getDistrict());
             sarpanch.setText(Villagerecieved.getSarpanch());
             hoj.setText(Villagerecieved.getHOJ());
             post.setText(Villagerecieved.getPost());
             famous.setText(Villagerecieved.getFamous_Attraction());
             AUF.setText(Villagerecieved.getArea_under_farming());
             popular.setText(Villagerecieved.getPopular_for());

             mCollapsingToolbarLayout.setTitle(Villagerecieved.getVillage_name());
         }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        initializeWidgets();
        receiveAndShowData();
    }
}
//end

