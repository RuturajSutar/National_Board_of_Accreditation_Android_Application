package com.pirates.nbaonline;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DatabaseReference;

import java.util.concurrent.TimeUnit;

public class StudentRegOTPVerification extends AppCompatActivity {

    Button verify;

    private String verificationID ;
    FirebaseAuth firebaseAuth;
    private EditText otp;
    DatabaseReference DatabaseLogin;
    public String phonenumber,name,Total;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_reg_otpverification);

        Intent intent=getIntent();
        phonenumber=intent.getStringExtra("Mobile");
        name="+91";
        Total=name+phonenumber;

        sendVerificationCode(Total);

        verify=(Button)findViewById(R.id.button);

        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                otp = (EditText) findViewById(R.id.editText3);
                String code = otp.getText().toString().trim();

                if(code.isEmpty() || code.length() < 6){
                    otp.setError("Enter code....!");
                    otp.requestFocus();
                    return;
                }


                verifyCode(code);


//                Intent intent=new Intent(StudentRegOTPVerification.this,StudentLoginPage.class);
//                startActivity(intent);
//                finish();
            }


        });
    }
    private void verifyCode(String code) {
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationID,code);
        signInWithCredential(credential);
    }

    private void signInWithCredential(PhoneAuthCredential credential) {
        firebaseAuth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"OTP is sent on your registered mobile number....",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(StudentRegOTPVerification.this,MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);


                }
                else{
                    Toast.makeText(StudentRegOTPVerification.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void sendVerificationCode(String total) {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(total,60, TimeUnit.SECONDS, TaskExecutors.MAIN_THREAD,mCallBack);
    }
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallBack = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {


        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            verificationID = s;
        }

        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
            String code = phoneAuthCredential.getSmsCode();
            if(code != null){
                //otp.setText(code);
                //verifyCode(code);
                Toast.makeText(StudentRegOTPVerification.this, ""+code, Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onVerificationFailed(FirebaseException e) {
            Toast.makeText(StudentRegOTPVerification.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    };

}
