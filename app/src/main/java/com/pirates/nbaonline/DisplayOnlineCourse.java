package com.pirates.nbaonline;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class DisplayOnlineCourse extends AppCompatActivity {

    TextView textView;
    ImageView imageView;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_online_course);

        imageView = (ImageView) findViewById(R.id.imageDisplay);
        textView = (TextView) findViewById(R.id.textView);

        intent = getIntent();
        String imageName = intent.getStringExtra("imagename");
        String email = intent.getStringExtra("email");

        textView.setText(imageName);

        Toast.makeText(this, imageName+"aaa"+email, Toast.LENGTH_SHORT).show();
        StorageReference mImageRef = FirebaseStorage.getInstance().getReference("OnlineCourse/"+email+"/"+email+"/"+imageName);
        final long ONE_MEGABYTE = 1024 * 1024;


        mImageRef.getBytes(ONE_MEGABYTE)
                .addOnSuccessListener(new OnSuccessListener<byte[]>() {
                    @Override
                    public void onSuccess(byte[] bytes) {
                        Bitmap bm = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                        DisplayMetrics dm = new DisplayMetrics();
                        getWindowManager().getDefaultDisplay().getMetrics(dm);

                        imageView.setMinimumHeight(dm.heightPixels);
                        imageView.setMinimumWidth(dm.widthPixels);
                        imageView.setImageBitmap(bm);
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle any errors
            }
        });

    }
}
