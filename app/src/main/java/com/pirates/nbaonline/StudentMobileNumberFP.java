package com.pirates.nbaonline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StudentMobileNumberFP extends AppCompatActivity {


    Button number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_mobile_number_fp);

        number=(Button)findViewById(R.id.button);

        number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(StudentMobileNumberFP.this,StudentOTP.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
