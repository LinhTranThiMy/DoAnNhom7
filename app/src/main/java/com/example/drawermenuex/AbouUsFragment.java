package com.example.drawermenuex;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;


public class AbouUsFragment extends Fragment {

    TextView txtFacebook, txtInstagram;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_aboutus, container, false);


        txtFacebook = view.findViewById(R.id.txtFacebook);
        txtInstagram=view.findViewById(R.id.txtInstagram);

        txtFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/fukishopne"));
                startActivity(intent);
            }
        });
        txtInstagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/fukiaccessories"));
                startActivity(intent);
            }
        });

        return view;
    }
}