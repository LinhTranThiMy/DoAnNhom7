package com.example.drawermenuex;

import static com.example.util.Constant.USER;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;


public class ProfilePassword1Fragment extends Fragment {
    ImageButton btnBackPassword1;
    Button btnChangePassword;
    EditText edtEmail,edtPassword1;
    ImageView imvProfilePassword;
    public static DBHelper DB;
    private View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_profile_password1, container, false);
        edtPassword1=view.findViewById(R.id.edtPassword1);
        btnBackPassword1=view.findViewById(R.id.btnBackPassword1);
        btnChangePassword=view.findViewById(R.id.btnChangePassword);
        edtEmail=view.findViewById(R.id.edtEmail);
        imvProfilePassword=view.findViewById(R.id.imvProfilePassword);
        imvProfilePassword.setImageResource(R.drawable.ic_hide_pass);
        DB=new DBHelper(getContext());
        imvProfilePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtPassword1.getTransformationMethod().equals(HideReturnsTransformationMethod.getInstance())){
                    //If password is visible then Hide it
                    edtPassword1.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    //Change icon
                    imvProfilePassword.setImageResource(R.drawable.ic_hide_pass);
                }else{
                    edtPassword1.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    imvProfilePassword.setImageResource(R.drawable.ic_show_pass);
                }
            }
        });
        btnBackPassword1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle = getArguments();
                if(bundle != null) {
                    String key = bundle.getString(USER);
                    bundle.putSerializable(USER, key);
                    AppCompatActivity activity = (AppCompatActivity) v.getContext();
                    ProfileFragment fragment = new ProfileFragment();
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, fragment).addToBackStack(null).commit();
                    bundle.putSerializable(USER, key);
                    fragment.setArguments(bundle);
                }

            }
        });
        btnChangePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=edtEmail.getText().toString();
                String password=edtPassword1.getText().toString();
                if(email.equals("")||password.equals("")){
                    Toast.makeText(getContext(), "Please enter your email or password", Toast.LENGTH_SHORT).show();
                }else{
                    Boolean checkemalpass=DB.checkEmailPassword(email,password);
                    if(checkemalpass==true){
                        Toast.makeText(getContext(), "Successful", Toast.LENGTH_SHORT).show();
                        Bundle bundle= new Bundle();
                        bundle.putString("email",edtEmail.getText().toString());
                        bundle.putString("password",edtPassword1.getText().toString());
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