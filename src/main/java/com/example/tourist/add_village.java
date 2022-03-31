package com.example.tourist;
/*
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class AddVillage extends AppCompatActivity {

    EditText E1,E2,E3,E4,E5,E6,E7,E8,E9,E10,E11,E12,E13 ;
    ImageView btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_village);
        E1=(EditText) findViewById(R.id.e1);
        E2=(EditText) findViewById(R.id.e2);
        E3=(EditText) findViewById(R.id.e3);
        E4=(EditText) findViewById(R.id.e4);
        E5=(EditText) findViewById(R.id.e5);
        E6=(EditText) findViewById(R.id.e6);
        E7=(EditText) findViewById(R.id.e7);
        E8=(EditText) findViewById(R.id.e8);
        E9=(EditText) findViewById(R.id.e9);
        E10=(EditText) findViewById(R.id.e10);
        E11=(EditText) findViewById(R.id.e11);
        E12=(EditText) findViewById(R.id.e12);
        E13=(EditText) findViewById(R.id.e13);
        btn=(ImageView) findViewById(R.id.btn1);



    }
}
*/




import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;

import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import java.io.IOException;
public class add_village extends AppCompatActivity {
    Button btnbrowse, btnupload;
    EditText txtdata ;
    ImageView imgview;
    EditText E1,E2,E3,E4,E5,E6,E7,E8,E9,E10,E11,E12,E13 ;
    Uri FilePathUri;
    StorageReference storageReference;
    DatabaseReference databaseReference;
    int Image_Request_Code = 7;
    ProgressDialog progressDialog ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_village);

        storageReference = FirebaseStorage.getInstance().getReference("Add Request");
        databaseReference = FirebaseDatabase.getInstance().getReference("Add Request");
        btnbrowse = (Button)findViewById(R.id.btnbrowse);
        btnupload= (Button)findViewById(R.id.btnupload);

        E1=(EditText) findViewById(R.id.e1);
        E2=(EditText) findViewById(R.id.e2);
        E3=(EditText) findViewById(R.id.e3);
        E4=(EditText) findViewById(R.id.e4);
        E5=(EditText) findViewById(R.id.e5);
        E6=(EditText) findViewById(R.id.e6);
        E7=(EditText) findViewById(R.id.e7);
        E8=(EditText) findViewById(R.id.e8);
        E9=(EditText) findViewById(R.id.e9);
        E10=(EditText) findViewById(R.id.e10);
        E11=(EditText) findViewById(R.id.e11);
        E12=(EditText) findViewById(R.id.e12);


        txtdata = (EditText)findViewById(R.id.txtdata);
        imgview = (ImageView)findViewById(R.id.image_view);
        progressDialog = new ProgressDialog(add_village.this);// context name as per your project name


        btnbrowse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Image"), Image_Request_Code);

            }
        });
        btnupload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                UploadImage();

            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == Image_Request_Code && resultCode == RESULT_OK && data != null && data.getData() != null) {

            FilePathUri = data.getData();

            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), FilePathUri);
                imgview.setImageBitmap(bitmap);
            }
            catch (IOException e) {

                e.printStackTrace();
            }
        }
    }


    public String GetFileExtension(Uri uri) {

        ContentResolver contentResolver = getContentResolver();
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
        return mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(uri)) ;

    }


    public void UploadImage() {

        if (FilePathUri != null) {

            progressDialog.setTitle("data is Uploading...");
            progressDialog.show();
            StorageReference storageReference2 = storageReference.child(System.currentTimeMillis() + "." + GetFileExtension(FilePathUri));
            storageReference2.putFile(FilePathUri)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                            String TempImageName = E1.getText().toString().trim();
                            String TempImageName1 = E2.getText().toString().trim();
                            String TempImageName2 = E3.getText().toString().trim();
                            String TempImageName3 = E4.getText().toString().trim();

                            String TempImageName4 = E5.getText().toString().trim();
                            String TempImageName5 = E6.getText().toString().trim();
                            String TempImageName6 = E7.getText().toString().trim();
                            String TempImageName7 = E8.getText().toString().trim();


                            String TempImageName8 = E9.getText().toString().trim();

                            String TempImageName9 = E10.getText().toString().trim();
                            String TempImageName10 = E11.getText().toString().trim();
                            String TempImageName11 = E12.getText().toString().trim();
                            String TempImageName12 = txtdata.getText().toString().trim();



                            progressDialog.dismiss();
                            Toast.makeText(getApplicationContext(), "Add Request Send Successfully ", Toast.LENGTH_LONG).show();
                            @SuppressWarnings("VisibleForTests")
                            uploadinfo imageUploadInfo = new uploadinfo(TempImageName,TempImageName1,TempImageName2,TempImageName3,TempImageName4,TempImageName5,TempImageName6,TempImageName7,TempImageName8,TempImageName9,TempImageName10,TempImageName11,TempImageName12, taskSnapshot.getUploadSessionUri().toString());
                            String ImageUploadId = databaseReference.push().getKey();
                            databaseReference.child(TempImageName).setValue(imageUploadInfo);
                        }
                    });
        }
        else {

            Toast.makeText(add_village.this, "Please Select Image or Add Image Name", Toast.LENGTH_LONG).show();

        }
    }
}