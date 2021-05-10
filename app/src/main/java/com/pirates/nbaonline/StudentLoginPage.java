package com.pirates.nbaonline;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class StudentLoginPage extends AppCompatActivity {

    TextView forgotPassword,studentReg;
    Button login;
    EditText username;
    EditText password;
    FirebaseAuth mFirebaseAuth;
    DatabaseReference mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login_page);


        username=(EditText)findViewById(R.id.editText1);
        password=(EditText)findViewById(R.id.editText2);

        mFirebaseAuth=FirebaseAuth.getInstance();

        forgotPassword=(TextView)findViewById(R.id.textView20);
        studentReg=(TextView)findViewById(R.id.textView);

        studentReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(StudentLoginPage.this,StudentRegistration.class);
                startActivity(intent);
                finish();
            }
        });

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(StudentLoginPage.this,StudentMobileNumberFP.class);
                startActivity(intent);
                finish();
            }
        });

        login=(Button)findViewById(R.id.button);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String ausername=username.getText().toString();
                final String apassword=password.getText().toString();

                String removeDot=ausername.replace(".","");
                final String removeAt=removeDot.replace("@","");

                if(ausername.isEmpty()){
                    username.setError("Please Enter Username");
                    username.requestFocus();
                }
                else if (apassword.isEmpty()){
                    password.setError("Please Enter Password");
                    password.requestFocus();
                }
                else if(ausername.isEmpty() && apassword.isEmpty()){
                    Toast.makeText(StudentLoginPage.this, "Both Fields are Empty", Toast.LENGTH_SHORT).show();
                }
                else if (!(ausername.isEmpty() && apassword.isEmpty())){

                    //d
                    mFirebaseAuth.signInWithEmailAndPassword(ausername,apassword).addOnCompleteListener(StudentLoginPage.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull final Task<AuthResult> task) {

                            mRef= FirebaseDatabase.getInstance().getReference().child("StudentsDup").child(removeAt);
                            mRef.addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    String name=dataSnapshot.child("Email").getValue().toString();
                                    String pass=dataSnapshot.child("Password").getValue().toString();
                                    if (task.isSuccessful() && ausername.equals(name) && apassword.equals(pass)) {
                                        Toast.makeText(StudentLoginPage.this, "Successfully Logged IN", Toast.LENGTH_SHORT).show();
                                        Intent intent=new Intent(StudentLoginPage.this,StudentDashboard.class);
                                        intent.putExtra("Email",removeAt);
                                        startActivity(intent);
                                        username.setText("");
                                        password.setText("");

                                    } else {
                                        // If sign in fails, display a message to the user.

                                        Toast.makeText(StudentLoginPage.this, "Invalid Username or Password or team Number", Toast.LENGTH_SHORT).show();
                                        username.setText("");
                                        password.setText("");
                                    }

                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                    Toast.makeText(StudentLoginPage.this, "Please Enter Valid Team Number", Toast.LENGTH_SHORT).show();
                                }
                            });

                        }
                    });

                }
                else {
                    Toast.makeText(StudentLoginPage.this, "Error in Login user", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
