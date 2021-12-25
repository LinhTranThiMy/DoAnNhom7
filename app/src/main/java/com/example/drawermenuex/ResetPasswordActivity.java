package com.example.drawermenuex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ResetPasswordActivity extends AppCompatActivity {
    EditText edtPass,edtConfirmPass;
    Button btnResetPassword;
    TextView txtEmail;

    ImageView imvResetPasswordToggle, imvConfirmPasswordToggle,imvBackReset;
    public static DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        linkViews();
        addEvents();
    }

    private void linkViews() {
        edtPass=findViewById(R.id.edtPass);
        edtConfirmPass=findViewById(R.id.edtConfirmPass);
        txtEmail= findViewById(R.id.txtEmail);
        btnResetPassword=findViewById(R.id.btnResetPassword);
        imvBackReset=findViewById(R.id.imvBackReset);
        imvConfirmPasswordToggle=findViewById(R.id.imvConfirmPasswordToggle);
        imvResetPasswordToggle=findViewById(R.id.imvResetPasswordToggle);
        imvResetPasswordToggle.setImageResource(R.drawable.ic_hide_pass);
        imvConfirmPasswordToggle.setImageResource(R.drawable.ic_hide_pass);
        DB=new DBHelper(this);

        Intent intent= getIntent();
        txtEmail.setText(intent.getStringExtra("email"));
    }

    private void addEvents() {
        btnResetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pass=edtPass.getText().toString();
                String email=txtEmail.getText().toString();
                String confirmpass=edtConfirmPass.getText().toString();
                if(pass.equals(confirmpass)) {
                    if (pass.equals("") || confirmpass.equals("")) {
                        Toast.makeText(ResetPasswordActivity.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                    } else {
                        Boolean checkpasswordupdate = DB.updatePassword(email,pass);
                        if (checkpasswordupdate == true) {
                            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                            startActivity(intent);
                            Toast.makeText(ResetPasswordActivity.this, "Password update successfully", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(ResetPasswordActivity.this, "Password not update ", Toast.LENGTH_SHORT).show();
                        }
                    }
                }else{
                    Toast.makeText(ResetPasswordActivity.this, "Password not match ", Toast.LENGTH_SHORT).show();
                }
            }
        });
        imvResetPasswordToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtPass.getTransformationMethod().equals(HideReturnsTransformationMethod.getInstance())){
                    //If password is visible then Hide it
                    edtPass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    //Change icon
                    imvResetPasswordToggle.setImageResource(R.drawable.ic_hide_pass);
                }else{
                    edtPass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    imvResetPasswordToggle.setImageResource(R.drawable.ic_show_pass);
                }
            }
        });
        imvConfirmPasswordToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtConfirmPass.getTransformationMethod().equals(HideReturnsTransformationMethod.getInstance())){
                    //If password is visible then Hide it
                    edtConfirmPass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    //Change icon
                    imvConfirmPasswordToggle.setImageResource(R.drawable.ic_hide_pass);
                }else{
                    edtConfirmPass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    imvConfirmPasswordToggle.setImageResource(R.drawable.ic_show_pass);
                }
            }
        });
        imvBackReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ResetPasswordActivity.this,ForgotPasswordActivity.class);
                startActivity(intent);
            }
        });
    }
}