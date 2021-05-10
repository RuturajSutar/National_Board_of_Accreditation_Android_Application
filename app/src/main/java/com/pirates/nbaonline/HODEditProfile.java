package com.pirates.nbaonline;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class HODEditProfile extends AppCompatActivity {

    Button changePassword;
    String emaildotat;
    EditText old,newpass,againnewpass;
    DatabaseReference mRef;
    DatabaseReference mRef1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hodedit_profile);

        Intent intent=getIntent();
        emaildotat=intent.getStringExtra("Email");

        old=(EditText)findViewById(R.id.editText1);
        newpass=(EditText)findViewById(R.id.editText2);
        againnewpass=(EditText)findViewById(R.id.editText3);

        changePassword=(Button)findViewById(R.id.button);
        changePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String myoldpass=old.getText().toString();
                final String mynewpass=newpass.getText().toString();
                final String myagainnewpass=againnewpass.getText().toString();

                if (myoldpass.isEmpty()){

                    old.setError("Please Enter Old Password");
                    old.requestFocus();
                }
                else if (mynewpass.isEmpty()){

                    newpass.setError("Please Enter new password");
                    newpass.requestFocus();
                }
                else if (myagainnewpass.isEmpty()){

                    againnewpass.setError("Please Again Enter New Password");
                    againnewpass.requestFocus();
                }
                else if (mynewpass.length()<6){

                    newpass.setError("Please Enter Password having length greater than 6");
                    newpass.requestFocus();
                }
                else if (myagainnewpass.length()<6){

                    againnewpass.setError("Please Enter Password having length greater than 6");
                    againnewpass.requestFocus();
                }

                else if (myoldpass.isEmpty() && mynewpass.isEmpty() && myagainnewpass.isEmpty()){
                    Toast.makeText(HODEditProfile.this, "All Fields are empty", Toast.LENGTH_SHORT).show();
                }
                else if (!(myoldpass.isEmpty() && mynewpass.isEmpty() && myagainnewpass.isEmpty())){
                    mRef= FirebaseDatabase.getInstance().getReference().child("HodDup").child(emaildotat);

                    mRef.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            String mypassword=dataSnapshot.child("Password").getValue().toString();
                            String mycollege=dataSnapshot.child("College").getValue().toString();
                            String mybranch=dataSnapshot.child("Branch").getValue().toString();
                            String mymail=dataSnapshot.child("Email").getValue().toString();

                            final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                            if (user!=null){
                                AuthCredential credential = EmailAuthProvider.getCredential(mymail, mypassword);

                                user.reauthenticate(credential).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {

                                        user.updatePassword(mynewpass)
                                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                    @Override
                                                    public void onComplete(@NonNull Task<Void> task) {
                                                        if (task.isSuccessful()) {
                                                            Toast.makeText(HODEditProfile.this, "password Changed", Toast.LENGTH_SHORT).show();
                                                        }
                                                    }
                                                });
                                    }
                                });
                            }
                            else {
                                Toast.makeText(HODEditProfile.this, "Cannot change Password", Toast.LENGTH_SHORT).show();
                            }


//
                            if(myoldpass.equals(mypassword) && mynewpass.equals(myagainnewpass)){

                                Map<String,Object> updateValue=new HashMap<>();
                                updateValue.put("/Password",mynewpass);
                                mRef.updateChildren(updateValue);


                                mRef1= FirebaseDatabase.getInstance().getReference().child("Hod").child(mycollege).child(mybranch).child(emaildotat);
                                mRef1.addListenerForSingleValueEvent(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                        String mypassworda=dataSnapshot.child("Password").getValue().toString();
//
                                        if(myoldpass.equals(mypassworda) && mynewpass.equals(myagainnewpass)){

                                            Map<String,Object> updateValue1=new HashMap<>();
                                            updateValue1.put("/Password",mynewpass);
                                            mRef1.updateChildren(updateValue1);
                                            Toast.makeText(HODEditProfile.this, "Password Changed Successfuly", Toast.LENGTH_SHORT).show();
                                            Intent intent=new Intent(HODEditProfile.this,HODDashboard.class);
                                            startActivity(intent);
                                            finish();
                                        }
                                        else {
                                            Toast.makeText(HODEditProfile.this, "Please Reenter New Password or enter new password having size more than 6", Toast.LENGTH_SHORT).show();
                                        }

                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError databaseError) {

                                        Toast.makeText(HODEditProfile.this, "Error Occured", Toast.LENGTH_SHORT).show();
                                    }
                                });

                            }
                            else {
                                Toast.makeText(HODEditProfile.this, "Please Reenter New Password or enter new password having size more than 6", Toast.LENGTH_SHORT).show();
                            }







                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                            Toast.makeText(HODEditProfile.this, "Error Occured", Toast.LENGTH_SHORT).show();
                        }
                    });

                }
                else {
                    Toast.makeText(HODEditProfile.this, "Error in Changing Password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
