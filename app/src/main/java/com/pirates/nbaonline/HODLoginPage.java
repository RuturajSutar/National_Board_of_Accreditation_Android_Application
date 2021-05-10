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

public class HODLoginPage extends AppCompatActivity {

    TextView forgotPassword;
    Button login;
    EditText username;
    EditText password;
    FirebaseAuth mFirebaseAuth;
    DatabaseReference mRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hodlogin_page);


        username=(EditText)findViewById(R.id.editText1);
        password=(EditText)findViewById(R.id.editText2);

        mFirebaseAuth=FirebaseAuth.getInstance();

        forgotPassword=(TextView)findViewById(R.id.textView20);

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HODLoginPage.this,HODMobileNumberFP.class);
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
                    Toast.makeText(HODLoginPage.this, "Both Fields are Empty", Toast.LENGTH_SHORT).show();
                }
                else if (!(ausername.isEmpty() && apassword.isEmpty())){

                    //d
                    mFirebaseAuth.signInWithEmailAndPassword(ausername,apassword).addOnCompleteListener(HODLoginPage.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull final Task<AuthResult> task) {

                            mRef= FirebaseDatabase.getInstance().getReference().child("HodDup").child(removeAt);
                            mRef.addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    String name=dataSnapshot.child("Email").getValue().toString();
                                    String pass=dataSnapshot.child("Password").getValue().toString();
                                    if (task.isSuccessful() && ausername.equals(name) && apassword.equals(pass)) {
                                        Toast.makeText(HODLoginPage.this, "Successfully Logged IN", Toast.LENGTH_SHORT).show();
                                        Intent intent=new Intent(HODLoginPage.this,HODDashboard.class);
                                        intent.putExtra("Email",removeAt);
                                        startActivity(intent);
                                        username.setText("");
                                        password.setText("");

                                    } else {
                                        // If sign in fails, display a message to the user.

                                        Toast.makeText(HODLoginPage.this, "Invalid Username or Password or team Number", Toast.LENGTH_SHORT).show();
                                        username.setText("");
                                        password.setText("");
                                    }

                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                    Toast.makeText(HODLoginPage.this, "Please Enter Valid Team Number", Toast.LENGTH_SHORT).show();
                                }
                            });



                        }
                    });

                }
                else {
                    Toast.makeText(HODLoginPage.this, "Error in Login user", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
