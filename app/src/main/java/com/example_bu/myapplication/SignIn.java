package com.example_bu.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SignIn extends AppCompatActivity {
    Button signin2;
    ImageView b;
    EditText name,email,password,cpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_in);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        signin2=findViewById(R.id.sign_in_btn);

        name=findViewById(R.id.sign_in_name);
        email=findViewById(R.id.sign_in_email);
        password=findViewById(R.id.sign_in_password);
        cpassword=findViewById(R.id.sign_in_cpassword);
        b=findViewById(R.id.back);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        signin2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(vaildate(name,1)&&vaildate(email,2)&&vaildate(password,3)&&vaildate(cpassword,3)){
                    Intent notify=new Intent(SignIn.this,SNotify.class);
                    notify.putExtra("value","Rigistered");
                    startActivity(notify);
                    finish();
                }


            }
        });
    }
    private static boolean vaildate(EditText ed,int n){
        String str=ed.getText().toString();
        switch (n){
            case 1:
                if(str.isEmpty()) {
                    ed.setError("Cannot be empty");
                    return false;
                }
                break;
            case 2:
                if (!Patterns.EMAIL_ADDRESS.matcher(str).matches()) {
                    ed.setError("InValide Email");
                    return false;
                }
                break;
            case 3:
                if(str.isEmpty()){
                    ed.setError("Cannot be empty");
                    return false;
                }
                else if(str.length()<8) {
                    ed.setError("password must contain at least 8 ch");
                    return false;
                }
                break;
            default:
                return true;


        }
        return true;


    }
}