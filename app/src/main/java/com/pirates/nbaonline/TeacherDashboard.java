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

public class TeacherDashboard extends AppCompatActivity {

    Button examMarks,attendance,editProfile,achivments;
    public String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_dashboard);

        Intent intent=getIntent();
        email=intent.getStringExtra("Email");

        examMarks=(Button)findViewById(R.id.button1);
        attendance=(Button)findViewById(R.id.button2);
        editProfile=(Button)findViewById(R.id.button3);
        achivments=(Button)findViewById(R.id.button4);

        examMarks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TeacherDashboard.this,TeacherExamNames.class);
                startActivity(intent);
            }
        });
        attendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TeacherDashboard.this,TeacherSetAttendance.class);
                startActivity(intent);
                finish();
            }
        });
        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TeacherDashboard.this,TeacherEditProfile.class);
                intent.putExtra("Email",email);
                startActivity(intent);
                finish();
            }
        });
        achivments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TeacherDashboard.this,TeacherAchivments.class);
                intent.putExtra("Email",email);
                startActivity(intent);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.cust_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                Intent intent=new Intent(TeacherDashboard.this,TeacherAccount.class);
                startActivity(intent);
                return true;
            case R.id.item2:

                AlertDialog.Builder builder = new AlertDialog.Builder(TeacherDashboard.this);

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
                Intent intent1=new Intent(TeacherDashboard.this,ListTeacherAchivements.class);
                intent1.putExtra("Email",email);
                startActivity(intent1);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
