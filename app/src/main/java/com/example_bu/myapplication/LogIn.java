package com.example_bu.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.regex.Pattern;

public class LogIn extends AppCompatActivity {
    Button signin,login;
    EditText name,email,password;

    ImageView b;
    TextView f;
    //Button l,s;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_log_in);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        b=findViewById(R.id.back);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        email=findViewById(R.id.log_in_email);
        password=findViewById(R.id.log_in_password);
        signin=findViewById(R.id.log_in_signbtn);
        login=findViewById(R.id.log_in_btn);
        f=findViewById(R.id.forgot);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int2=new Intent(LogIn.this,SignIn.class);
                startActivity(int2);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(vaildate(email,1)&&vaildate(password,0)){
                    finish();
                    Intent ih=new Intent(LogIn.this, HomeActivity2.class);
                    startActivity(ih);
                }
                //code for login


            }
        });

        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(email.getText().toString().isEmpty()){
                    email.setError("Valid Email Require");
                }
                else{
                    Intent i=new Intent(LogIn.this,SNotify.class);
                    i.putExtra("value","Email Send");
                    startActivity(i);
                }

            }
        });


    }
    private static boolean vaildate(EditText ed,int n){
        String str=ed.getText().toString();
        if(str.isEmpty()){
            ed.setError("Cannot be Empty");
            return  false;
        }
        if(n==1 && Patterns.EMAIL_ADDRESS.matcher(str).matches()){

            return true;
        } else if (n==0) {
            if(str.length()<8){
                ed.setError("password must contain at least 8 ch");
                return  false;
            }
            return true;
        } else {
            ed.setError("InValide Email");
            return false;
        }


    }

}