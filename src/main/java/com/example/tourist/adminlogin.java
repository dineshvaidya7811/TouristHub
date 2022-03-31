package com.example.tourist;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class adminlogin extends AppCompatActivity {


    EditText fn,pass;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminlogin);
        fn=(EditText) findViewById(R.id.fn);
        pass=(EditText) findViewById(R.id.pass);
        btn1=(Button) findViewById(R.id.btn1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {   openNewActivity(); }
        });

    }


    private void openNewActivity() {
        if(fn.getText().toString().equals("admin") && pass.getText().toString().equals("12345")) {
            Toast.makeText(getApplicationContext(),"Successful",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, AdminDashboard.class);
            startActivity(intent);
            finish();
        }
        else{
            Toast.makeText(getApplicationContext(),"UnSuccessful",Toast.LENGTH_SHORT).show();
        }
    }

}