package com.pirates.nbaonline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TeacherSetAttendance extends AppCompatActivity {

    Button ct1att,ct2att,eseatt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_set_attendance);

        ct1att=(Button)findViewById(R.id.button1);
        ct2att=(Button)findViewById(R.id.button2);
        eseatt=(Button)findViewById(R.id.button3);

        ct1att.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TeacherSetAttendance.this,TeacherDashboard.class);
                startActivity(intent);
                finish();
            }
        });
        ct2att.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TeacherSetAttendance.this,TeacherDashboard.class);
                startActivity(intent);
                finish();
            }
        });
        eseatt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TeacherSetAttendance.this,TeacherDashboard.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
