package com.example.drawermenuex;

import android.content.Intent;
import android.database.Cursor;
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

public class EditProfileFragment extends Fragment {
    Button btnSaveProfile;
    ImageButton btnBackMyAccount2;
    EditText edtFullName,edtUserName,edtEmail,edtBirthDay;
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
        edtUserName=mView.findViewById(R.id.edtUsername);
        edtEmail=mView.findViewById(R.id.edtEmail);
        edtBirthDay=mView.findViewById(R.id.edtBirthDay);
    }

    private void addEvent() {
        btnBackMyAccount2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new DetailAccountFragment(mPassUser));
            }
        });
        btnSaveProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String fullName = edtFullName.getText().toString();
                String username = edtUserName.getText().toString();
                String email = edtEmail.getText().toString();
                String dob = edtBirthDay.getText().toString();

                Boolean checkupdatedata = DB.updateuserdata(mPassUser, fullName, username, email, dob);
                if(checkupdatedata==true){
                    Toast.makeText(getContext(), "Entry Updated, Please Login again", Toast.LENGTH_SHORT).show();

                    Intent intent= new Intent(getContext(),LoginActivity.class);
                    startActivity(intent);
                }
                else
                    Toast.makeText(getContext(), "New Entry Not Updated", Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void setData(){

        DB = new DBHelper(getContext());

        Cursor res = DB.getdata(mPassUser);
        if(res.getCount()==0){
            Toast.makeText(getContext(), "No Entry Exists", Toast.LENGTH_SHORT).show();
        }
        while(res.moveToNext()){
            String pfUsername = res.getString(1);
            String pfFullName = res.getString(0);
            String pfEmail = res.getString(2);
            String pfDob = res.getString(5);

            edtFullName.setText(pfFullName);
            edtUserName.setText(pfUsername);
            edtEmail.setText(pfEmail);
            edtBirthDay.setText(pfDob);

        }
    }
    private void replaceFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction= getParentFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();
    }
}