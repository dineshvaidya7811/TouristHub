package com.example.tourist;




import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity  implements
        SearchView.OnQueryTextListener,MenuItem.OnActionExpandListener {

    private RecyclerView rv;
    ImageView user,admin;
    public ProgressBar mProgressBar;
    private LinearLayoutManager layoutManager;
    VillageMyAdapter adapter;

    private void initializeViews(){
        mProgressBar = findViewById(R.id.mProgressBarLoad);
        mProgressBar.setIndeterminate(true);
        mProgressBar.setVisibility(View.VISIBLE);
        rv = findViewById(R.id.mRecyclerView);
        user=findViewById(R.id.userlogin);
        admin=findViewById(R.id.adminlogin);
        layoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(layoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(rv.getContext(),
                layoutManager.getOrientation());
        rv.addItemDecoration(dividerItemDecoration);
        adapter=new VillageMyAdapter(VillageUtils.DataCache);
        rv.setAdapter(adapter);

        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v2) {
                openNewActivity();
            }
            public void openNewActivity(){
                Intent intent = new Intent(MainActivity.this, userlogin.class);
                startActivity(intent);
            }
        });


        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v2) {
                openNewActivity();
            }
            public void openNewActivity(){
                Intent intent = new Intent(MainActivity.this, adminlogin.class);
                startActivity(intent);
            }
        });
    }



    private void bindData(){
        VillageUtils.select(this, VillageUtils.getDatabaseRefence(),mProgressBar,rv,adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu options from the res/menu/menu_editor.xml file.
        // This adds menu items to the app bar.
        getMenuInflater().inflate(R.menu.village_page_menu, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);

        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(this);
        searchView.setIconified(true);
        searchView.setQueryHint("Search");
        return true;
    }

    @Override
    public boolean onMenuItemActionExpand(MenuItem item) {
        return false;
    }

    @Override
    public boolean onMenuItemActionCollapse(MenuItem item) {
        return false;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {

        return false;
    }

    @Override
    public boolean onQueryTextChange(String query) {
        VillageUtils.searchString=query;
        VillageUtils.search(this, VillageUtils.getDatabaseRefence(),mProgressBar, adapter,query);
        return false;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();
        bindData();

    }


}
//end


//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.view.animation.Animation;
//import android.view.animation.AnimationUtils;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//public class MainActivity extends AppCompatActivity {
//
//    ImageView logo,userlogin1,admin;
//    Animation topAnimantion,bottomAnimation,middleAnimation;
//    TextView textview1;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//logo=(ImageView) findViewById(R.id.logo) ;
//textview1=(TextView) findViewById(R.id.textview1);
//
//        userlogin1 = (ImageView) findViewById(R.id.userlogin);
//
//        admin = (ImageView) findViewById(R.id.adminlogin);
//        topAnimantion = AnimationUtils.loadAnimation(this, R.anim.top_animation);
//
//
//        logo.setAnimation(topAnimantion);
//        textview1.setAnimation(topAnimantion);
//        userlogin1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v2) {
//                openNewActivity();
//            }
//            public void openNewActivity(){
//                Intent intent = new Intent(MainActivity.this, userlogin.class);
//                startActivity(intent);
//            }
//        });
//
//
//        admin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v1) {
//                openNewActivity3();
//            }
//
//            private void openNewActivity3() {
//                Intent i = new Intent(MainActivity.this, adminlogin.class);
//                startActivity(i);
//            }
//        });
//    }
//
//
//}