package com.example_bu.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignIn extends AppCompatActivity {
    Button signin2;
    ImageView b;
    EditText name,email,password,cpassword;

    FirebaseAuth mAuth;

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
        mAuth=FirebaseAuth.getInstance();

        signin2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(vaildate(name,1)&&vaildate(email,2)&&vaildate(password,3)&&vaildate(cpassword,3)){

                    mAuth.createUserWithEmailAndPassword(email.getText().toString().trim(), password.getText().toString())
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        Intent notify=new Intent(SignIn.this,SNotify.class);
                                        notify.putExtra("value","Rigistered");
                                        startActivity(notify);
                                        finish();
                                    } else {
                                        // If sign in fails, display a message to the user.
                                        Log.w( "createUserWithEmail:failure", task.getException());
                                        Toast.makeText(SignIn.this, "Authentication failed."+task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                                    }
                                }
                            });

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