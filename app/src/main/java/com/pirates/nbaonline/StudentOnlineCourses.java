package com.pirates.nbaonline;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class StudentOnlineCourses extends AppCompatActivity {

    ImageView imageView;
    String doc;
    Uri filepath;
    EditText imagedescription;
    FirebaseStorage firebaseStorage;
    StorageReference storageReference;
    DatabaseReference databaseReference;
    private StorageTask uploadTask;
    int number = 0;
    String imageName;
    DatabaseReference databaseReference1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_online_courses);

        Intent intent = getIntent();
        doc = intent.getStringExtra("Email");


        imageView = (ImageView) findViewById(R.id.imageView2);
        imagedescription = (EditText) findViewById(R.id.editText8);

        // firebaseStorage = FirebaseStorage.getInstance();
        storageReference = FirebaseStorage.getInstance().getReference("OnlineCourse").child(doc);
        databaseReference = FirebaseDatabase.getInstance().getReference("OnlineCourse").child(doc);


//        findViewById(R.id.retrive).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getApplicationContext(),RetriveImage.class));
//            }
//        });

        findViewById(R.id.button7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseImage();
            }
        });

        findViewById(R.id.button6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(uploadTask != null && uploadTask.isInProgress()) {
                    Toast.makeText(StudentOnlineCourses.this, "Upload in Progress...", Toast.LENGTH_SHORT).show();
                }
                else{
                    uploadImage();
                }
            }
        });

    }

    private void chooseImage() {

        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"Select Image "),1);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1 && resultCode == RESULT_OK && data.getData() != null){
            filepath = data.getData();

            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),filepath);
                imageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
    private String getFileExtension(Uri uri){
        ContentResolver contentResolver = getContentResolver();
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
        return mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(uri));

    }


    private void uploadImage() {
        if (filepath != null) {
            final String image = imagedescription.getText().toString();

            if (!image.equals("")) {
                final ProgressDialog progressDialog = new ProgressDialog(this);
                progressDialog.setTitle("Image Uploading......");
                progressDialog.show();


                StorageReference storageReference1 = storageReference.child(doc).child(image/*+"."+getFileExtension(filepath)*/);
                uploadTask = storageReference1.putFile(filepath).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        progressDialog.dismiss();
                        UploadImage uploadImage = new UploadImage(image, taskSnapshot.getStorage().getDownloadUrl().toString());
                        //String uploadId = databaseReference.push().getKey();
                        databaseReference.child("" + uploadImage.getImagename()).setValue(uploadImage);
                        Toast.makeText(StudentOnlineCourses.this, "Online Course Image uploaded successfully", Toast.LENGTH_SHORT).show();


                        imageName = uploadImage.getImagename();
                        databaseReference1 = FirebaseDatabase.getInstance().getReference("Online_Course_ImageNames").child(doc);
                        Map<String, Object> insertValues = new HashMap<>();
                        insertValues.put("Imagename", imageName);
                        databaseReference1.child("" + imageName).setValue(insertValues);

                    }

                })
                        .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                            @Override
                            public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                                double progress = (100.0 * taskSnapshot.getBytesTransferred() / taskSnapshot.getTotalByteCount());
                                progressDialog.setMessage("Uploaded " + (int) progress + "%");
                            }
                        });
            } else {
                Toast.makeText(this, "Please Enter name of the image", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Please select the image", Toast.LENGTH_SHORT).show();
        }
    }
}
