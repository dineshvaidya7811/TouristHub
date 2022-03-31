package com.example.tourist;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class userlogin extends AppCompatActivity {
    private Button btnn;
    EditText username;
    EditText password;
    Button login;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userlogin);

        btnn = (Button) findViewById(R.id.ctn2);
        username = (EditText) findViewById(R.id.user);
        password = (EditText) findViewById(R.id.pass);
        login = (Button) findViewById(R.id.btn1);
        auth = FirebaseAuth.getInstance();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt_email = username.getText().toString();
                String txt_pass = password.getText().toString();
                loginuser(txt_email,txt_pass);
            }
        });

        btnn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();

            }
        });
    }

    private void loginuser(String email, String pass) {
        // String str=email;
        auth.signInWithEmailAndPassword(email,pass).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(userlogin.this, "Login Successful", Toast.LENGTH_SHORT).show();
                //startActivity(new Intent(userlogin.this,userDashboard.class)); /*after successfully login forward to new activity*/
                Intent i = new Intent(userlogin.this, userDashboard.class);


                // i.putExtra("t1", str );
                startActivity(i);
                finish();


            }

        });

    }

    public void openActivity()  /*forwards to Registration Page*/
    {
        Intent intent = new Intent(this, userregistration.class);
        startActivity(intent);
        finish();
    }

}