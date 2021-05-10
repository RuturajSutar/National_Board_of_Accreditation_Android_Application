package com.pirates.nbaonline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TeacherExamNames extends AppCompatActivity {

    Button ct1,ct2,ese,ta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_exam_names);

        ct1=(Button)findViewById(R.id.button1);
        ct2=(Button)findViewById(R.id.button2);
        ese=(Button)findViewById(R.id.button3);
        ta=(Button)findViewById(R.id.button4);

        ct1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TeacherExamNames.this,TeacherEnterExamMarks.class);
                startActivity(intent);
                finish();
            }
        });

        ct2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TeacherExamNames.this,TeacherClassTest1.class);
                startActivity(intent);
                finish();
            }
        });
        ese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TeacherExamNames.this,TeacherEndSemExam.class);
                startActivity(intent);
                finish();
            }
        });
        ta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TeacherExamNames.this,TeacherTAMarks.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
