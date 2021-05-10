package com.pirates.nbaonline;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.R.layout;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class HODSubjectDistribution extends AppCompatActivity {

    public String teacherName,SubjectName;
    Spinner teacherSpinner,subjectSpinner;
    FirebaseDatabase database;
    DatabaseReference ref;
    Button assign;
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hodsubject_distribution);




        teacherSpinner=(Spinner)findViewById(R.id.spinner1);
        subjectSpinner=(Spinner)findViewById(R.id.spinner2);

        final List<String> list=new ArrayList<String>();
        list.add("Select_Subject");
        list.add("OOSWE");
        list.add("DWM");
        list.add("IS");
        list.add("CA");
        list.add("CT");
        list.add("DSS");
        list.add("DRS");
        list.add("FE");
        list.add("CS2");
        list.add("PE");
        list.add("CE");
        list.add("OT");
        list.add("NA");
        list.add("MCI");
        list.add("AIC");
        list.add("AC");


        final ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        subjectSpinner.setAdapter(arrayAdapter);

        subjectSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                subjectSpinner.setSelection(position);
                Log.i("info","Position"+subjectSpinner.getItemAtPosition(position).toString());
                SubjectName=subjectSpinner.getItemAtPosition(position).toString();
                Toast.makeText(HODSubjectDistribution.this, SubjectName, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        database=FirebaseDatabase.getInstance();
        ref=database.getReference("TeacherDup");
        user=new User();


        final List<String> list1=new ArrayList<String>();
        list1.add("Select_Teacher");
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                for (DataSnapshot ds:dataSnapshot.getChildren()){

                    user=ds.getValue(User.class);
                    list1.add(user.getName().toString());

                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        teacherSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                teacherSpinner.setSelection(position);
                Log.i("info","Position"+teacherSpinner.getItemAtPosition(position).toString());
                teacherName=teacherSpinner.getItemAtPosition(position).toString();
                Toast.makeText(HODSubjectDistribution.this, teacherName, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayAdapter<String> arrayAdapter1=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list1);
        arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        teacherSpinner.setAdapter(arrayAdapter1);


        assign=(Button)findViewById(R.id.button);
        assign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HODSubjectDistribution.this,HODDashboard.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
