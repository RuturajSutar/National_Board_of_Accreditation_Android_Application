package com.pirates.nbaonline;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DeanLoginPage extends AppCompatActivity {

    TextView forgotPassword;
    Button login;
    EditText username;
    EditText password;
    DatabaseReference mRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dean_login_page);

        forgotPassword=(TextView)findViewById(R.id.textView20);

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DeanLoginPage.this,DeanMobileNumberFP.class);
                startActivity(intent);
                finish();
            }
        });

        username=(EditText)findViewById(R.id.editText);
        password=(EditText)findViewById(R.id.editText2);

        login=(Button)findViewById(R.id.button);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                final String ausername=username.getText().toString();
                final String apassword=password.getText().toString();

                String removeDot=ausername.replace(".","");
                String removeAt=removeDot.replace("@","");

                if(ausername.isEmpty()){
                    username.setError("Please Enter Username");
                    username.requestFocus();

                }
                else if (apassword.isEmpty()){
                    password.setError("Please Enter Password");
                    password.requestFocus();
                }
                else if(ausername.isEmpty() && apassword.isEmpty()){
                    Toast.makeText(DeanLoginPage.this, "Both Fields are Empty", Toast.LENGTH_SHORT).show();
                }
                else if (!(ausername.isEmpty() && apassword.isEmpty())){

                    mRef= FirebaseDatabase.getInstance().getReference().child("DeanLogin").child(removeAt);

                    mRef.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            String name=dataSnapshot.child("Username").getValue().toString();
                            String pass=dataSnapshot.child("Password").getValue().toString();
                            Log.i("info","Name : "+name);
                            Log.i("info","Pass : "+pass);
                            if(ausername.equals(name) && apassword.equals(pass)){
                                Intent intent=new Intent(DeanLoginPage.this,DeanDashboard.class);
                                startActivity(intent);
                                username.setText("");
                                password.setText("");

                            }
                            else {
                                Toast.makeText(DeanLoginPage.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                                username.setText("");
                                password.setText("");
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                            Toast.makeText(DeanLoginPage.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                        }
                    });

                }
                else {
                    Toast.makeText(DeanLoginPage.this, "Login Error", Toast.LENGTH_SHORT).show();
                }

            }
        });




    }
}
