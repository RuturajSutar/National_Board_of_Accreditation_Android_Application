package com.pirates.nbaonline;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentRegistration extends AppCompatActivity {

    TextView loginStudent;
    Button toOTPPage;
    Spinner collegeNameSpinner,branchNameSpinner,yearOfPassingSpinner,genderSpinner;
    public String collegeName,branchName,yearOfPassing,gender;
    EditText name,email,mobile,roll,dob,password;
    DatabaseReference mRef;
    DatabaseReference mRef1;
    FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_registration);

        collegeNameSpinner=(Spinner)findViewById(R.id.spinner1);
        branchNameSpinner=(Spinner)findViewById(R.id.spinner2);
        yearOfPassingSpinner=(Spinner)findViewById(R.id.spinner3);
        genderSpinner=(Spinner)findViewById(R.id.spinner4);

        mFirebaseAuth=FirebaseAuth.getInstance();


        List<String> list=new ArrayList<String>();
        list.add("Select_College");
        list.add("GCEK");
        list.add("WCEK");
        list.add("RIT");
        list.add("COEP");
        list.add("VIT");
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        collegeNameSpinner.setAdapter(arrayAdapter);
        collegeNameSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                collegeNameSpinner.setSelection(position);
                Log.i("info","Position"+collegeNameSpinner.getItemAtPosition(position).toString());
                collegeName=collegeNameSpinner.getItemAtPosition(position).toString();
                Toast.makeText(StudentRegistration.this, collegeName, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        List<String> list1=new ArrayList<String>();
        list1.add("Select_Branch");
        list1.add("IT");
        list1.add("CS");
        list1.add("Mech");
        list1.add("Civil");
        list1.add("Electrical");
        list1.add("ENTC");
        ArrayAdapter<String> arrayAdapter1=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list1);
        arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);



        branchNameSpinner.setAdapter(arrayAdapter1);
        branchNameSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                branchNameSpinner.setSelection(position);
                Log.i("info","Position"+branchNameSpinner.getItemAtPosition(position).toString());
                branchName=branchNameSpinner.getItemAtPosition(position).toString();
                Toast.makeText(StudentRegistration.this, branchName, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        List<String> list2=new ArrayList<String>();
        list2.add("Select_Year_Of_Passing");
        list2.add("2020");
        list2.add("2021");
        list2.add("2022");
        list2.add("2023");
        list2.add("2024");
        list2.add("2025");
        ArrayAdapter<String> arrayAdapter2=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list2);
        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        yearOfPassingSpinner.setAdapter(arrayAdapter2);

        yearOfPassingSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                yearOfPassingSpinner.setSelection(position);
                Log.i("info","Position"+yearOfPassingSpinner.getItemAtPosition(position).toString());
                yearOfPassing=yearOfPassingSpinner.getItemAtPosition(position).toString();
                Toast.makeText(StudentRegistration.this, yearOfPassing, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        List<String> list3=new ArrayList<String>();
        list3.add("Select_Gender");
        list3.add("Male");
        list3.add("Female");
        ArrayAdapter<String> arrayAdapter3=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list3);
        arrayAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genderSpinner.setAdapter(arrayAdapter3);

        genderSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                genderSpinner.setSelection(position);
                Log.i("info","Position"+genderSpinner.getItemAtPosition(position).toString());
                gender=genderSpinner.getItemAtPosition(position).toString();
                Toast.makeText(StudentRegistration.this, gender, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        loginStudent=(TextView)findViewById(R.id.textView4);
        loginStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(StudentRegistration.this,StudentLoginPage.class);
                startActivity(intent);
                finish();
            }
        });

        name=(EditText)findViewById(R.id.editText1);
        email=(EditText)findViewById(R.id.editText2);
        mobile=(EditText)findViewById(R.id.editText3);
        roll=(EditText)findViewById(R.id.editText4);
        dob=(EditText)findViewById(R.id.editText5);
        password=(EditText)findViewById(R.id.editText6);


        toOTPPage=(Button)findViewById(R.id.button);
        toOTPPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String aname=name.getText().toString();
                final String ausername=email.getText().toString();
                final String amobile=mobile.getText().toString();
                final String aroll=roll.getText().toString();
                final String adob=dob.getText().toString();
                final String apassword=password.getText().toString();

                TextView errorText = (TextView)collegeNameSpinner.getSelectedView();
                TextView errorText1 = (TextView)branchNameSpinner.getSelectedView();
                TextView errorText2 = (TextView)yearOfPassingSpinner.getSelectedView();
                TextView errorText3 = (TextView)genderSpinner.getSelectedView();


                String removeDot=ausername.replace(".","");
                final String removeAt=removeDot.replace("@","");


                if(aname.isEmpty()){
                    name.setError("Please Enter Name");
                    name.requestFocus();
                }
                else if (ausername.isEmpty()){
                    email.setError("Please Enter Email");
                    email.requestFocus();
                }
                else if (amobile.isEmpty()){
                    mobile.setError("Please Enter Mobile Number");
                    mobile.requestFocus();
                }
                else if (aroll.isEmpty()){
                    roll.setError("Please Enter Roll Number");
                    roll.requestFocus();
                }
                else if (adob.isEmpty()){
                    dob.setError("Please Enter Date of Birth");
                    dob.requestFocus();
                }
                else if (apassword.isEmpty()){
                    password.setError("Please Enter Password");
                    password.requestFocus();
                }
                else if(aname.isEmpty() && ausername.isEmpty() && amobile.isEmpty() && aroll.isEmpty() && adob.isEmpty() && apassword.isEmpty()){
                    Toast.makeText(StudentRegistration.this, "All Fields are Empty", Toast.LENGTH_SHORT).show();
                }
                else if (apassword.length()<6){

                    password.setError("Password length must be greater than 6");
                    password.requestFocus();
                }
                else if (collegeName.equals("Select_College")){
                    errorText.setError("Please Select College");
                    errorText.requestFocus();
                }
                else if (branchName.equals("Select_Branch")){
                    errorText1.setError("Please Select Branch");
                    errorText1.requestFocus();
                }
                else if (yearOfPassing.equals("Select_Year_Of_Passing")){
                    errorText2.setError("Please Select year of Complition");
                    errorText2.requestFocus();
                }
                else if (gender.equals("Select_Gender")){
                    errorText3.setError("Please Select Gender");
                    errorText3.requestFocus();
                }
                else if (!(aname.isEmpty() && ausername.isEmpty() && amobile.isEmpty() && aroll.isEmpty() && adob.isEmpty() && apassword.isEmpty())){




                    mFirebaseAuth.createUserWithEmailAndPassword(ausername,apassword).addOnCompleteListener(StudentRegistration.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                FirebaseUser user = mFirebaseAuth.getCurrentUser();
                                mRef= FirebaseDatabase.getInstance().getReference().child("Students");
                                Map<String,Object> insertValues=new HashMap<>();
                                insertValues.put("Name",aname);
                                insertValues.put("Email",ausername);
                                insertValues.put("Mobile",amobile);
                                insertValues.put("Roll_Number",aroll);
                                insertValues.put("DOB",adob);
                                insertValues.put("Password",apassword);
                                insertValues.put("College",collegeName);
                                insertValues.put("Branch",branchName);
                                insertValues.put("Year_Of_Complition",yearOfPassing);
                                insertValues.put("Gender",gender);
                                mRef.child(collegeName).child(branchName).child(removeAt).setValue(insertValues);
                                mRef1= FirebaseDatabase.getInstance().getReference().child("StudentsDup");
                                mRef1.child(removeAt).setValue(insertValues);
                                Toast.makeText(StudentRegistration.this, "User Created Successfully", Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(StudentRegistration.this,StudentRegOTPVerification.class);
                                intent.putExtra("Mobile",amobile);
                                startActivity(intent);
                                finish();
                            } else {
                                Toast.makeText(StudentRegistration.this, "Please Enter Valid Username or Password",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });




                }
                else {
                    Toast.makeText(StudentRegistration.this, "Error in creating user", Toast.LENGTH_SHORT).show();

                }




            }
        });
    }
}
