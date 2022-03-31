package com.example.tourist;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

public class AdminDashboard extends AppCompatActivity {

    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    ImageView imageView21,img2,img3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admindashboard);

        imageView21 = (ImageView) findViewById(R.id.imageView21);
        img2=(ImageView) findViewById(R.id.imageView31);
        //village
img3=findViewById(R.id.imageView3);
        drawerLayout = findViewById(R.id.my_drawer_layout);

        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity2();
            }

            private void openNewActivity2() {
                Intent i=new Intent(AdminDashboard.this, villagelist.class);
                startActivity(i);
            }
        });



        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity2();
            }

            private void openNewActivity2() {
                Intent i=new Intent(AdminDashboard.this, villagelist.class);
                startActivity(i);
            }
        });

        imageView21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v2) {
                openNewActivity1();
            }

            private void openNewActivity1() {
                Intent intent1 = new Intent(AdminDashboard.this, Add_Request.class);
                startActivity(intent1);
            }

        });





        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);


        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
