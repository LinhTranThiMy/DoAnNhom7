package com.example.giaodienloginout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ResetPassword extends AppCompatActivity {
    EditText edtPass,edtConfirmPass;
    Button btnResetPassword;
    TextView txtEmail;
    DBHelper DB;

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
                        Toast.makeText(ResetPassword.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                    } else {
                        Boolean checkpasswordupdate = DB.updatePassword(email,pass);
                        if (checkpasswordupdate == true) {
                            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                            startActivity(intent);
                            Toast.makeText(ResetPassword.this, "Password update successfully", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(ResetPassword.this, "Password not update ", Toast.LENGTH_SHORT).show();
                        }
                    }
                }else{
                    Toast.makeText(ResetPassword.this, "Password not match ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}