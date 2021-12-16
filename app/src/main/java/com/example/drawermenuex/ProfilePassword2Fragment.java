package com.example.drawermenuex;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


public class ProfilePassword2Fragment extends Fragment {
    ImageButton btnBackPassword2;
    TextView txtEmail,txtCurrentPass;
    EditText edtNewPass, edtConfirmpass;
    Button btnSavePassword;
    public static DBHelper DB;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile_password2,container,false);
        btnBackPassword2=view.findViewById(R.id.btnBackPassword2);
        txtCurrentPass=view.findViewById(R.id.txtCurrentPass);
        edtNewPass=view.findViewById(R.id.edtNewPass);
        edtConfirmpass=view.findViewById(R.id.edtConfirmpass);
        btnSavePassword= view.findViewById(R.id.btnSavePassword);
        txtEmail=view.findViewById(R.id.txtEmail);

        DB=new DBHelper(getContext());

        Bundle bundle=this.getArguments();
        String email=bundle.getString("email");
        txtEmail.setText(email);
        String password=bundle.getString("password");
        txtCurrentPass.setText(password);

        btnBackPassword2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new ProfilePassword1Fragment());
            }
        });
        btnSavePassword.setOnClickListener(new View.OnClickListener() {
            String passNew=edtNewPass.getText().toString();
            String email=txtEmail.getText().toString();
            String password=txtCurrentPass.getText().toString();
            String cfPass=edtConfirmpass.getText().toString();
            @Override
            public void onClick(View v) {
                if(passNew.equals(cfPass)) {
//                    if (passNew.equals("") || cfPass.equals("")) {
//                    Toast.makeText(getContext(), "Please enter all fields", Toast.LENGTH_SHORT).show();
//                    } else {
                    Boolean updatepass = DB.editPassword(email,passNew);
                    if (updatepass == true) {
                        replaceFragment(new ProfileFragment());
                        Toast.makeText(getContext(), "Password update successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getContext(), "Password not update ", Toast.LENGTH_SHORT).show();
                    }
//                    }
                } else {
                    Toast.makeText(getContext(), "Password not match ", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }
    private void replaceFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction= getParentFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();
    }
}