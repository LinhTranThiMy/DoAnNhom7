package com.example.drawermenuex;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.adapter.PopularAdapter;
import com.example.adapter.SearchAdapter;
import com.example.model.Product;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Locale;


public class SearchFragment<replaceFragment> extends Fragment {
    ImageView imvbtnCase,imvbtnCollection,imvbtnAccessories;
    RecyclerView rcvSearch;
    ArrayList<Product> search;
    SearchAdapter adapter;
    EditText edtSearch;
    DatabaseReference Data;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        //Hiện actionBar
        ((AppCompatActivity) getActivity()).getSupportActionBar().show();
        Data = FirebaseDatabase.getInstance().getReference();
        //linkViews
        imvbtnCase=view.findViewById(R.id.imvbtnCase);
        imvbtnAccessories = view.findViewById(R.id.imvbtnAccessories);
        imvbtnCollection=view.findViewById(R.id.imvbtnCollection);
        rcvSearch=view.findViewById(R.id.rcvSearch);
        edtSearch=view.findViewById(R.id.edtSearch);
        rcvSearch.setVisibility(View.INVISIBLE);
        //loadData
        GetDataFromFirebase();
        //addEvents
        edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Search(s.toString());
                rcvSearch.setVisibility(View.VISIBLE);
            }
        });

        imvbtnCase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new CasesFragment());
            }
        });
        imvbtnAccessories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new AccessoriesFragment());
            }
        });
        imvbtnCollection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new CollectionFragment());
            }
        });
        return view;

    }

    private void Search(String text) {
        ArrayList<Product> searchList = new ArrayList<>();
        for(Product p: search){
            if(p.getProductName().toLowerCase().contains(text.toLowerCase())){
                searchList.add(p);
            }
        }
        adapter.Search(searchList);
    }

    private void GetDataFromFirebase() {
        Data.child("AllCase").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                search = new ArrayList<Product>();
                LinearLayoutManager linearLayoutManager =  new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false);
                rcvSearch.setLayoutManager(linearLayoutManager);
                for (DataSnapshot snapshot : datasnapshot.getChildren()) {
                    Product product = snapshot.getValue(Product.class);
                    search.add(product);
                }
                adapter = new SearchAdapter(getActivity(), search);
                rcvSearch.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void replaceFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();
    }
}