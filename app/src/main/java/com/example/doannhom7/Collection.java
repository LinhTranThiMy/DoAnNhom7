package com.example.doannhom7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.adapter.ProductAdapterCollection;
import com.example.model.ProductCollection;

import java.util.ArrayList;

public class Collection extends AppCompatActivity {
    RecyclerView mRvNew, mRvPopular, mRvSale;
    ArrayList<ProductCollection> mProductList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);

        mRvNew = findViewById(R.id.mrvNew);
        mRvPopular = findViewById(R.id.mrvPopular);
        mRvSale = findViewById(R.id.mrvSale);

        mRvNew.setNestedScrollingEnabled(false);
        mRvPopular.setNestedScrollingEnabled(false);
        mRvSale.setNestedScrollingEnabled(false);

        mRvNew.setLayoutManager(new GridLayoutManager(Collection.this, 3));
        mRvPopular.setLayoutManager(new GridLayoutManager(Collection.this, 3));
        mRvSale.setLayoutManager(new GridLayoutManager(Collection.this, 3));

        mProductList = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            ProductCollection ob1 = new ProductCollection(R.drawable.product, "CUSTOM CASE", "$13.50");
            mProductList.add(ob1);
        }


        mRvNew.setAdapter(new ProductAdapterCollection(mProductList));
        mRvPopular.setAdapter(new ProductAdapterCollection(mProductList));
        mRvSale.setAdapter(new ProductAdapterCollection(mProductList));
    }
}