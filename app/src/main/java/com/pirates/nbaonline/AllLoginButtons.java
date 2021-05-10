package com.pirates.nbaonline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AllLoginButtons extends AppCompatActivity {


    Button studentButton,teacherButton,hodButton,deanButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_login_buttons);

        studentButton=(Button)findViewById(R.id.button1);
        teacherButton=(Button)findViewById(R.id.button2);
        hodButton=(Button)findViewById(R.id.button3);
        deanButton=(Button)findViewById(R.id.button4);

        studentButton.setTranslationY(2000);
        teacherButton.setTranslationY(2000);
        hodButton.setTranslationY(2000);
        deanButton.setTranslationY(2000);


        studentButton.animate().translationYBy(-2000).setDuration(2000);
        teacherButton.animate().translationYBy(-2000).setDuration(2000);
        hodButton.animate().translationYBy(-2000).setDuration(2000);
        deanButton.animate().translationYBy(-2000).setDuration(2000);


        studentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AllLoginButtons.this,StudentLoginPage.class);
                startActivity(intent);
            }
        });
        teacherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AllLoginButtons.this,TeacherLoginPage.class);
                startActivity(intent);
            }
        });
        hodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AllLoginButtons.this,HODLoginPage.class);
                startActivity(intent);
            }
        });
        deanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AllLoginButtons.this,DeanLoginPage.class);
                startActivity(intent);
            }
        });
    }
}
