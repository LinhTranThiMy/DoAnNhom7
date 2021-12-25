package com.example.drawermenuex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class ForgotPasswordActivity extends AppCompatActivity {
    EditText edtEnterEmail;
    ImageView imvBackForgot;
    Button btnSend;
    public static DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        linkViews();
        addEvents();
    }

    private void linkViews() {
        edtEnterEmail=findViewById(R.id.edtEnterEmail);
        btnSend=findViewById(R.id.btnSend);
        imvBackForgot=findViewById(R.id.imvBackForgot);
        DB=new DBHelper(this);
    }

    private void addEvents() {
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edtEnterEmail.getText().toString();
                if(email.equals("")){
                    Toast.makeText(ForgotPasswordActivity.this, "Please enter your email", Toast.LENGTH_SHORT).show();
                }else{
                    Boolean checkemail=DB.checkEmail(email);
                    if(checkemail==true){
                        Toast.makeText(ForgotPasswordActivity.this, "Successful", Toast.LENGTH_SHORT).show();
                        Intent intent= new Intent(getApplicationContext(), com.example.drawermenuex.ResetPasswordActivity.class);
                        intent.putExtra("email",email);
                        startActivity(intent);

                    }else {
                        Toast.makeText(ForgotPasswordActivity.this, "Email does not exists", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        imvBackForgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ForgotPasswordActivity.this,LoginActivity.class);
                startActivity(intent);

            }
        });
    }
}