package com.pirates.nbaonline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class TeacherEndSemExam extends AppCompatActivity {

    Button add;
    Spinner spinner1,spinner2,spinner3,spinner4,spinner5,spinner6,spinner7,spinner8,spinner9,spinner10,spinner11,spinner12,spinner13,spinner14,spinner15,spinner16,spinner17,spinner18,spinner19,spinner20;
    public String s1spinner,s2spinner,s3spinner,s4spinner,s5spinner,s6spinner,s7spinner,s8spinner,s9spinner,s10spinner,s11spinner,s12spinner,s13spinner,s14spinner,s15spinner,s16spinner,s17spinner,s18spinner,s19spinner,s20spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_end_sem_exam);

        spinner1=(Spinner)findViewById(R.id.spinner1);
        spinner2=(Spinner)findViewById(R.id.spinner2);
        spinner3=(Spinner)findViewById(R.id.spinner3);
        spinner4=(Spinner)findViewById(R.id.spinner4);
        spinner5=(Spinner)findViewById(R.id.spinner5);
        spinner6=(Spinner)findViewById(R.id.spinner6);
        spinner7=(Spinner)findViewById(R.id.spinner7);
        spinner8=(Spinner)findViewById(R.id.spinner8);
        spinner9=(Spinner)findViewById(R.id.spinner9);
        spinner10=(Spinner)findViewById(R.id.spinner10);
        spinner11=(Spinner)findViewById(R.id.spinner11);
        spinner12=(Spinner)findViewById(R.id.spinner12);
        spinner13=(Spinner)findViewById(R.id.spinner13);
        spinner14=(Spinner)findViewById(R.id.spinner14);
        spinner15=(Spinner)findViewById(R.id.spinner15);
        spinner16=(Spinner)findViewById(R.id.spinner16);
        spinner17=(Spinner)findViewById(R.id.spinner17);
        spinner18=(Spinner)findViewById(R.id.spinner18);
        spinner19=(Spinner)findViewById(R.id.spinner19);
        spinner20=(Spinner)findViewById(R.id.spinner20);


        List<String> list=new ArrayList<String>();
        list.add("Select_Course_Outcome(CO)");
        list.add("CO 1.Construct EER diagram for real life application. ");
        list.add("CO 2.Differentiate different types of databases.");
        list.add("CO 3.Design database schemas using object oriented and object relational database. ");
        list.add("CO 4.Use internet database technology such as XML for web application.");
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        spinner1.setAdapter(arrayAdapter);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinner1.setSelection(position);
                Log.i("info","Position"+spinner1.getItemAtPosition(position).toString());
                s1spinner=spinner1.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        spinner3.setAdapter(arrayAdapter);
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinner3.setSelection(position);
                Log.i("info","Position"+spinner3.getItemAtPosition(position).toString());
                s3spinner=spinner3.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        spinner5.setAdapter(arrayAdapter);
        spinner5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinner5.setSelection(position);
                Log.i("info","Position"+spinner5.getItemAtPosition(position).toString());
                s5spinner=spinner5.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        spinner7.setAdapter(arrayAdapter);
        spinner7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinner7.setSelection(position);
                Log.i("info","Position"+spinner7.getItemAtPosition(position).toString());
                s7spinner=spinner7.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        spinner9.setAdapter(arrayAdapter);
        spinner9.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinner9.setSelection(position);
                Log.i("info","Position"+spinner9.getItemAtPosition(position).toString());
                s9spinner=spinner9.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        spinner11.setAdapter(arrayAdapter);
        spinner11.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinner11.setSelection(position);
                Log.i("info","Position"+spinner11.getItemAtPosition(position).toString());
                s11spinner=spinner11.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner13.setAdapter(arrayAdapter);
        spinner13.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinner13.setSelection(position);
                Log.i("info","Position"+spinner13.getItemAtPosition(position).toString());
                s13spinner=spinner13.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner15.setAdapter(arrayAdapter);
        spinner15.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinner15.setSelection(position);
                Log.i("info","Position"+spinner15.getItemAtPosition(position).toString());
                s15spinner=spinner15.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner17.setAdapter(arrayAdapter);
        spinner17.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinner17.setSelection(position);
                Log.i("info","Position"+spinner17.getItemAtPosition(position).toString());
                s17spinner=spinner17.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner19.setAdapter(arrayAdapter);
        spinner19.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinner19.setSelection(position);
                Log.i("info","Position"+spinner19.getItemAtPosition(position).toString());
                s19spinner=spinner19.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        List<String> list1=new ArrayList<String>();
        list1.add("Select_Program_Outcome");
        list1.add("PO 1.Engineering knowledge");
        list1.add("PO 2.Problem analysis");
        list1.add("PO 3.Design/development of solutions");
        list1.add("PO 4.Conduct investigations of complex problems");
        list1.add("PO 5.Modern tool usage");
        list1.add("PO 6.The engineer and society");
        list1.add("PO 7.Environment and sustainability");
        list1.add("PO 8.Ethics");
        list1.add("PO 9.Individual and team work");
        list1.add("PO 10.Communication");
        list1.add("PO 11.Project management and finance");
        list1.add("PO 12. Life-long learning");
        ArrayAdapter<String> arrayAdapter1=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list1);
        arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        spinner2.setAdapter(arrayAdapter1);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinner2.setSelection(position);
                Log.i("info","Position"+spinner2.getItemAtPosition(position).toString());
                s2spinner=spinner2.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        spinner4.setAdapter(arrayAdapter1);
        spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinner4.setSelection(position);
                Log.i("info","Position"+spinner4.getItemAtPosition(position).toString());
                s4spinner=spinner4.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        spinner6.setAdapter(arrayAdapter1);
        spinner6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinner6.setSelection(position);
                Log.i("info","Position"+spinner6.getItemAtPosition(position).toString());
                s6spinner=spinner6.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        spinner8.setAdapter(arrayAdapter1);
        spinner8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinner8.setSelection(position);
                Log.i("info","Position"+spinner8.getItemAtPosition(position).toString());
                s8spinner=spinner8.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        spinner10.setAdapter(arrayAdapter1);
        spinner10.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinner10.setSelection(position);
                Log.i("info","Position"+spinner10.getItemAtPosition(position).toString());
                s10spinner=spinner10.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        spinner12.setAdapter(arrayAdapter1);
        spinner12.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinner12.setSelection(position);
                Log.i("info","Position"+spinner12.getItemAtPosition(position).toString());
                s12spinner=spinner12.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner14.setAdapter(arrayAdapter1);
        spinner14.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinner14.setSelection(position);
                Log.i("info","Position"+spinner14.getItemAtPosition(position).toString());
                s14spinner=spinner14.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        spinner16.setAdapter(arrayAdapter1);
        spinner16.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinner16.setSelection(position);
                Log.i("info","Position"+spinner16.getItemAtPosition(position).toString());
                s16spinner=spinner16.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        spinner18.setAdapter(arrayAdapter1);
        spinner18.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinner18.setSelection(position);
                Log.i("info","Position"+spinner18.getItemAtPosition(position).toString());
                s18spinner=spinner18.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner20.setAdapter(arrayAdapter1);
        spinner20.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinner20.setSelection(position);
                Log.i("info","Position"+spinner20.getItemAtPosition(position).toString());
                s20spinner=spinner20.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        add=(Button)findViewById(R.id.button);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TeacherEndSemExam.this,TeacherExamNames.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
