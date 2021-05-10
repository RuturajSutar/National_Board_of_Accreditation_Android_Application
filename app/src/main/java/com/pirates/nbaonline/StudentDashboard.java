package com.pirates.nbaonline;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class StudentDashboard extends AppCompatActivity {

    public String email;
    Button editProfile,details,feedback,extracurricularActivities,onlineCourses;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_dashboard);

        Intent intent=getIntent();
        email=intent.getStringExtra("Email");

        editProfile=(Button)findViewById(R.id.button1);
        details=(Button)findViewById(R.id.button2);
        feedback=(Button)findViewById(R.id.button3);
        extracurricularActivities=(Button)findViewById(R.id.button4);
        onlineCourses=(Button)findViewById(R.id.button5);


        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(StudentDashboard.this,StudentEditProfile.class);
                intent.putExtra("Email",email);
                startActivity(intent);
                finish();
            }
        });
        details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(StudentDashboard.this,StudentStudentDetails.class);
                intent.putExtra("Email",email);
                startActivity(intent);
            }
        });
        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(StudentDashboard.this,StudentFeedback.class);
                startActivity(intent);
            }
        });
        extracurricularActivities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(StudentDashboard.this,StudentExtracurricularActivities.class);
                intent.putExtra("Email",email);
                startActivity(intent);
            }
        });
        onlineCourses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(StudentDashboard.this,StudentOnlineCourses.class);
                intent.putExtra("Email",email);
                startActivity(intent);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.custom_menu2,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                Intent intent=new Intent(StudentDashboard.this,StudentAccount.class);
                intent.putExtra("Email",email);
                startActivity(intent);
                return true;
            case R.id.item2:

                AlertDialog.Builder builder = new AlertDialog.Builder(StudentDashboard.this);

                builder.setMessage("Are you sure logout..?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();

                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
                return true;

            case R.id.item3:
                Intent intent1=new Intent(StudentDashboard.this,ShowExtraActivity.class);
                intent1.putExtra("Email",email);
                startActivity(intent1);
                return true;
            case R.id.item4:
                Intent intent2=new Intent(StudentDashboard.this,ShowOnlineCourse.class);
                intent2.putExtra("Email",email);
                startActivity(intent2);
                return true;


            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
