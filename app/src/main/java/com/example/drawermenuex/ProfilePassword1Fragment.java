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
import android.widget.Toast;


public class ProfilePassword1Fragment extends Fragment {
    ImageButton btnBackPassword1;
    Button btnChangePassword;
    EditText edtEmail,edtPassword;
    public static DBHelper DB;
    private View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_profile_password1, container, false);
        edtPassword=view.findViewById(R.id.edtPassword);
        btnBackPassword1=view.findViewById(R.id.btnBackPassword1);
        btnChangePassword=view.findViewById(R.id.btnChangePassword);
        edtEmail=view.findViewById(R.id.edtEmail);
        DB=new DBHelper(getContext());
        btnBackPassword1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new ProfileFragment());
            }
        });
        btnChangePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=edtEmail.getText().toString();
                String password=edtPassword.getText().toString();
                if(email.equals("")||password.equals("")){
                    Toast.makeText(getContext(), "Please enter your email or password", Toast.LENGTH_SHORT).show();
                }else{
                    Boolean checkemalpass=DB.checkEmailPassword(email,password);
                    if(checkemalpass==true){
                        Toast.makeText(getContext(), "Successful", Toast.LENGTH_SHORT).show();
                        Bundle bundle= new Bundle();
                        bundle.putString("email",edtEmail.getText().toString());
                        bundle.putString("password",edtPassword.getText().toString());
                        ProfilePassword2Fragment profilePassword2= new ProfilePassword2Fragment();
                        profilePassword2.setArguments(bundle);
                        getParentFragmentManager().beginTransaction().replace(R.id.frame_layout,profilePassword2).commit();
                    }else {
                        Toast.makeText(getContext(), "Email or password does not exists", Toast.LENGTH_SHORT).show();
                    }
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