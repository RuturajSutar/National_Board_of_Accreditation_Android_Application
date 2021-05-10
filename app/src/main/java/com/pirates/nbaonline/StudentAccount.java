package com.pirates.nbaonline;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class StudentAccount extends AppCompatActivity {

    String emaildotat;
    TextView name,email,mobile,college,branch,rollNumber,yearOfPassing,gender,dob;
    DatabaseReference mRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_account);

        Intent intent=getIntent();
        emaildotat=intent.getStringExtra("Email");

        name=(TextView)findViewById(R.id.textView2);
        email=(TextView)findViewById(R.id.textView4);
        mobile=(TextView)findViewById(R.id.textView6);
        college=(TextView)findViewById(R.id.textView8);
        branch=(TextView)findViewById(R.id.textView10);
        rollNumber=(TextView)findViewById(R.id.textView12);
        yearOfPassing=(TextView)findViewById(R.id.textView14);
        gender=(TextView)findViewById(R.id.textView16);
        dob=(TextView)findViewById(R.id.textView18);

        mRef= FirebaseDatabase.getInstance().getReference().child("StudentsDup").child(emaildotat);

        mRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String myname=dataSnapshot.child("Name").getValue().toString();
                String myemail=dataSnapshot.child("Email").getValue().toString();
                String mymobile=dataSnapshot.child("Mobile").getValue().toString();
                String mycollege=dataSnapshot.child("College").getValue().toString();
                String mybranch=dataSnapshot.child("Branch").getValue().toString();
                String myrollnumber=dataSnapshot.child("Roll_Number").getValue().toString();
                String myyearofpassing=dataSnapshot.child("Year_Of_Complition").getValue().toString();
                String mygender=dataSnapshot.child("Gender").getValue().toString();
                String mydob=dataSnapshot.child("DOB").getValue().toString();


                name.setText(myname);
                email.setText(myemail);
                mobile.setText(mymobile);
                college.setText(mycollege);
                branch.setText(mybranch);
                rollNumber.setText(myrollnumber);
                yearOfPassing.setText(myyearofpassing);
                gender.setText(mygender);
                dob.setText(mydob);

                name.setVisibility(View.VISIBLE);
                email.setVisibility(View.VISIBLE);
                mobile.setVisibility(View.VISIBLE);
                college.setVisibility(View.VISIBLE);
                branch.setVisibility(View.VISIBLE);
                rollNumber.setVisibility(View.VISIBLE);
                yearOfPassing.setVisibility(View.VISIBLE);
                gender.setVisibility(View.VISIBLE);
                dob.setVisibility(View.VISIBLE);



            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(StudentAccount.this, "Error Occured", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
