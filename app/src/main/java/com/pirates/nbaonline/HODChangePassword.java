package com.pirates.nbaonline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HODChangePassword extends AppCompatActivity {


    Button changePassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hodchange_password);

        changePassword=(Button)findViewById(R.id.button4);

        changePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HODChangePassword.this,HODLoginPage.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
