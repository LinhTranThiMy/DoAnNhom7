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
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class DetailAccountFragment extends Fragment {

    Button btnEditProfile;
    ImageButton btnBackMyAccount1;
    TextView txtFullName,txtUserName,txtEmail,txtBirthDay;
    DBHelper DB;
    View mView;



    public DetailAccountFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_detail_account, container, false);
        linkViews();
        addEvents();
        setData();
        return mView;
    }

    private void linkViews() {
        btnEditProfile=mView.findViewById(R.id.btnEditProfile);
        btnBackMyAccount1=mView.findViewById(R.id.btnBackMyAccount1);
        txtFullName=mView.findViewById(R.id.txtFullName);
        txtUserName=mView.findViewById(R.id.txtUserName);
        txtEmail=mView.findViewById(R.id.txtEmail);
        txtBirthDay=mView.findViewById(R.id.txtBirthDay);
    }

    private void setData(){
        DB = new DBHelper(getContext());
        Bundle bundle = getArguments();
        if(bundle != null) {
            String data = bundle.getString(USER);
            Cursor res = DB.getdata(data);
            if (res.getCount() == 0) {
                Toast.makeText(getContext(), "No Entry Exists", Toast.LENGTH_SHORT).show();
            }
            while (res.moveToNext()) {
                String pfUsername = res.getString(1);
                String pfFullName = res.getString(0);
                String pfEmail = res.getString(2);
                String pfDob = res.getString(5);

                txtUserName.setText(pfUsername);
                txtFullName.setText(pfFullName);
                txtEmail.setText(pfEmail);
                txtBirthDay.setText(pfDob);

            }
        }
    }

    private void addEvents() {
        btnEditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = getArguments();
                if(bundle != null) {
                    String key = bundle.getString(USER);
                    AppCompatActivity activity = (AppCompatActivity) v.getContext();
                    EditProfileFragment fragment = new EditProfileFragment();
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, fragment).addToBackStack(null).commit();
                    bundle.putSerializable(USER, key);
                    fragment.setArguments(bundle);
                }
            }
        });
        btnBackMyAccount1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = getArguments();
                if(bundle != null) {
                    String key = bundle.getString(USER);
                    AppCompatActivity activity = (AppCompatActivity) v.getContext();
                    ProfileFragment fragment = new ProfileFragment();
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, fragment).addToBackStack(null).commit();
                    bundle.putSerializable(USER, key);
                    fragment.setArguments(bundle);
                }
            }
        });
    }


}