package com.example.tourist;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class userregistration extends AppCompatActivity {
    private Button havee;
    EditText firstname;
    EditText lastname;
    EditText email;
    EditText password;
    EditText confirm;
    Button register;
    private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userregistration);

        havee = (Button) findViewById(R.id.abtn2);
        firstname = (EditText) findViewById(R.id.fn);
        lastname = (EditText) findViewById(R.id.ln);
        email = (EditText) findViewById(R.id.mn);
        password = (EditText) findViewById(R.id.pass);
        confirm = (EditText) findViewById(R.id.cpass);
        register = (Button) findViewById(R.id.sbtn1);
        auth = FirebaseAuth.getInstance();


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt_fn = firstname.getText().toString();
                String txt_ln = lastname.getText().toString();
                String txt_mn = email.getText().toString();
                String txt_pass = password.getText().toString();
                String txt_cpass = confirm.getText().toString();

                if (TextUtils.isEmpty(txt_mn) || TextUtils.isEmpty(txt_pass) || TextUtils.isEmpty(txt_fn) || TextUtils.isEmpty(txt_ln) || TextUtils.isEmpty(txt_cpass))
                    Toast.makeText(userregistration.this, "Empty Credentials", Toast.LENGTH_SHORT).show();
                else if (txt_pass.length() < 6) {
                    Toast.makeText(userregistration.this, "Length Of Password should be greater than 6", Toast.LENGTH_SHORT).show();
                }
                else if(!txt_pass.equals(txt_cpass)){
                    Toast.makeText(userregistration.this, "Password does not match", Toast.LENGTH_SHORT).show();
                }

                else {

                    registerUser(txt_fn,txt_ln,txt_mn,txt_pass,txt_cpass);
                }

            }


        });


        havee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();

            }
        });
    }

    private void registerUser(String txt_fn, String txt_ln, String txt_mn, String txt_pass, String txt_cpass) {
        auth.createUserWithEmailAndPassword(txt_mn,txt_pass).addOnCompleteListener(userregistration.this,new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful() ){
                    Toast.makeText(userregistration.this, "Registering villageget1 Successful", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(userregistration.this, userlogin.class)); /*After successful registration forwards to login page*/


                }
                else{
                    Toast.makeText(userregistration.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void openActivity2 () /*Forwards to Login Page*/
    {
        Intent intent = new Intent(this, userlogin.class);
        startActivity(intent);
        finish();

    }
}
