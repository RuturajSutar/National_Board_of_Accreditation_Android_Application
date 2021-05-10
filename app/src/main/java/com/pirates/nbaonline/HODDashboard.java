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

public class HODDashboard extends AppCompatActivity {

    Button editProfile,subjectDistribution;
    public String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoddashboard);

        Intent intent=getIntent();
        email=intent.getStringExtra("Email");


        subjectDistribution=(Button)findViewById(R.id.button1);
        editProfile=(Button)findViewById(R.id.button2);

        subjectDistribution.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HODDashboard.this,HODSubjectDistribution.class);
                startActivity(intent);
                finish();
            }
        });
        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HODDashboard.this,HODEditProfile.class);
                intent.putExtra("Email",email);
                startActivity(intent);
                finish();
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
                Intent intent=new Intent(HODDashboard.this,HODAccount.class);
                startActivity(intent);
                return true;
            case R.id.item2:

                AlertDialog.Builder builder = new AlertDialog.Builder(HODDashboard.this);

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
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
