package com.example.drawermenuex;

import static com.example.util.Constant.USER;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
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

public class EditProfileFragment extends Fragment {
    Button btnSaveProfile;
    ImageButton btnBackMyAccount2;
    EditText edtFullName,edtEmail,edtBirthDay;
    TextView txtUserName;
    public static DBHelper DB;
    String mPassUser;
    View mView;

    public EditProfileFragment(String passUser) {
        this.mPassUser = passUser;
    }

    public EditProfileFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_edit_profile, container, false);
        linkViews();
        addEvent();
        setData();
        return mView;
    }

    private void linkViews() {
        btnSaveProfile=mView.findViewById(R.id.btnSaveProfile);
        btnBackMyAccount2=mView.findViewById(R.id.btnBackMyAccount2);
        edtFullName=mView.findViewById(R.id.edtFullName);
        txtUserName=mView.findViewById(R.id.txtUserName);
        edtEmail=mView.findViewById(R.id.edtEmail);
        edtBirthDay=mView.findViewById(R.id.edtBirthDay);
    }

    private void addEvent() {
        btnBackMyAccount2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = getArguments();
                if(bundle != null) {
                    String key = bundle.getString(USER);
                    bundle.putSerializable(USER, key);
                    AppCompatActivity activity = (AppCompatActivity) v.getContext();
                    DetailAccountFragment fragment = new DetailAccountFragment();
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, fragment).addToBackStack(null).commit();
                    bundle.putSerializable(USER, key);
                    fragment.setArguments(bundle);
                }
            }
        });
        btnSaveProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String fullName = edtFullName.getText().toString();
                String username = txtUserName.getText().toString();
                String email = edtEmail.getText().toString();
                String dob = edtBirthDay.getText().toString();

                Boolean checkupdatedata = DB.updateuserdata(fullName, username, email, dob);
                if(checkupdatedata==true){
                    Toast.makeText(getContext(), "Entry Updated", Toast.LENGTH_SHORT).show();
                    Bundle bundle = getArguments();
                    if(bundle != null) {
                        String key = bundle.getString(USER);
                        bundle.putSerializable(USER, key);
                        AppCompatActivity activity = (AppCompatActivity) v.getContext();
                        DetailAccountFragment fragment = new DetailAccountFragment();
                        activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, fragment).addToBackStack(null).commit();
                        bundle.putSerializable(USER, key);
                        fragment.setArguments(bundle);
                    }
                }
                else
                    Toast.makeText(getContext(), "New Entry Not Updated", Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void setData(){

        Bundle bundle = getArguments();
        String key = bundle.getString(USER);

        DB = new DBHelper(getContext());

        Cursor res = DB.getdata(key);
        if(res.getCount()==0){
            Toast.makeText(getContext(), "No Entry Exists", Toast.LENGTH_SHORT).show();
        }
        while(res.moveToNext()){
            String pfUsername = res.getString(1);
            String pfFullName = res.getString(0);
            String pfEmail = res.getString(2);
            String pfDob = res.getString(5);

            edtFullName.setText(pfFullName);
            txtUserName.setText(pfUsername);
            edtEmail.setText(pfEmail);
            edtBirthDay.setText(pfDob);

        }
    }
}