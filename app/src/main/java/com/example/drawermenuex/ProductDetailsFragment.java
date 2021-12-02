package com.example.drawermenuex;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adapter.ProductDetailsAdapter;
import com.example.adapter.ViewPagerAdapterCase;
import com.example.adapter.ViewPagerAdapterProductDetails;
import com.example.model.Product;
import com.example.model.ProductDetailsBanner;
import com.example.util.Constant;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;


public class ProductDetailsFragment extends Fragment {
    ImageButton btnBackProductDetails;
    Button btnBuyNowPD,btnAddtoCartPD;
    TextView txtNameProductDetails, txtRatingProductDetails, txtPriceProductDetails,txtDescription;
    RatingBar Rating_bar_products_details;
    RecyclerView rcvProductDetails;
    ArrayList<ProductDetailsBanner> productDetails;
    ProductDetailsAdapter adapter;
    Product p;
    TabLayout tabLayoutProductDetails;
    ViewPager2 viewPagerProductDetails;
    ViewPagerAdapterProductDetails adapterProductDetails;

    //Dialog Buy Now
    Spinner spSelectDevice;
    ArrayList<String> selectDevice;
    ArrayAdapter<String> adapterSelectDevice;
    ImageView imvBuyNow;
    TextView txtNameBuyNow, txtPriceBuyNow;
    ImageButton btnAddBuyNow,btnMinusBuyNow;
    TextView txtNumberBuyNow;

    //Dialog Add to Cart
    Spinner spSelectDeviceATC;
    ArrayList<String> selectDeviceATC;
    ArrayAdapter<String> adapterSelectDeviceATC;
    ImageView imvAddtoCart;
    TextView txtNameAddtoCart, txtPriceAddtoCart;
    ImageButton btnAddAddtoCart,btnMinusAddtoCart;
    TextView txtNumberAddtoCart;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_product_details, container, false);
        //Ẩn actionBar
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        //linkViews
        btnBackProductDetails=view.findViewById(R.id.btnBackProductDetails);
        txtNameProductDetails=view.findViewById(R.id.txtNameProductDetails);
        txtRatingProductDetails=view.findViewById(R.id.txtRatingProductDetails);
        txtPriceProductDetails=view.findViewById(R.id.txtPriceProductDetails);
        Rating_bar_products_details=view.findViewById(R.id.Rating_bar_products_details);
        rcvProductDetails=view.findViewById(R.id.rcvProductDetails);
        tabLayoutProductDetails=view.findViewById(R.id.tabLayoutProductDetails);
        viewPagerProductDetails=view.findViewById(R.id.viewPagerProductDetails);
        btnBuyNowPD=view.findViewById(R.id.btnBuyNowPD);
        btnAddtoCartPD=view.findViewById(R.id.btnAddtoCartPD);
        //lấy dữ liệu từ màn hình sản phẩm
        Bundle bundle = getArguments();
        if(bundle != null)
        {
            p= (Product) bundle.get(Constant.SELECTED_ITEM);
            txtNameProductDetails.setText(p.getProductName());
            txtPriceProductDetails.setText(String.valueOf(p.getProductPrice()));
            txtRatingProductDetails.setText(p.getProductRatingNumber());
            Rating_bar_products_details.setRating(p.getProductRating());
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
            rcvProductDetails.setLayoutManager(linearLayoutManager);
            productDetails= new ArrayList<ProductDetailsBanner>();
            productDetails.add(new ProductDetailsBanner(p.getProductThumb()));
            productDetails.add(new ProductDetailsBanner(p.getProductThumb()));
            adapter = new ProductDetailsAdapter(getContext(),productDetails);
            rcvProductDetails.setAdapter(adapter);
        }

        tabLayoutProductDetails.addTab(tabLayoutProductDetails.newTab().setText("Description"));
        tabLayoutProductDetails.addTab(tabLayoutProductDetails.newTab().setText("Review"));
        adapterProductDetails = new ViewPagerAdapterProductDetails(getActivity());
        viewPagerProductDetails.setAdapter(adapterProductDetails);

        tabLayoutProductDetails.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPagerProductDetails.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPagerProductDetails.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayoutProductDetails.selectTab(tabLayoutProductDetails.getTabAt(position));
            }
        });
        addEvents();
        return view;
    }

    private void addEvents() {
        btnBackProductDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });
        btnBuyNowPD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(getContext());
                dialog.setContentView(R.layout.fragment_buy_now);
                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
                dialog.getWindow().setGravity(Gravity.BOTTOM);
                //LinkViews
                imvBuyNow=dialog.findViewById(R.id.imvBuyNow);
                txtNameBuyNow=dialog.findViewById(R.id.txtNameBuyNow);
                txtPriceBuyNow=dialog.findViewById(R.id.txtPriceBuyNow);
                spSelectDevice=dialog.findViewById(R.id.spSelectDevice);
                btnAddBuyNow=dialog.findViewById(R.id.btnaddBuyNow);
                btnMinusBuyNow=dialog.findViewById(R.id.btnminusBuyNow);
                txtNumberBuyNow=dialog.findViewById(R.id.txtNumberBuyNow);
                //addEvents
                btnAddBuyNow.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int num = Integer.parseInt(txtNumberBuyNow.getText().toString());
                        int sum = num +1;
                        if(sum<10) {
                            txtNumberBuyNow.setText(String.valueOf(sum));
                        }else{
                            Toast.makeText(getContext(), "Vượt quá số lượng đặt hàng cho phép", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                btnMinusBuyNow.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int num = Integer.parseInt(txtNumberBuyNow.getText().toString());
                        int sum = num -1;
                        if(sum>=0) {
                            txtNumberBuyNow.setText(String.valueOf(sum));
                        }
                    }
                });
                //loadData
                imvBuyNow.setImageResource(p.getProductThumb());
                txtNameBuyNow.setText(p.getProductName());
                txtPriceBuyNow.setText(String.valueOf(p.getProductPrice()));
                selectDevice= new ArrayList<String>();
                selectDevice.add("Select one");
                selectDevice.add("Iphone 13");
                selectDevice.add("Iphone 11");
                selectDevice.add("Iphone X");
                selectDevice.add("Iphone 7");
                adapterSelectDevice= new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item,selectDevice);
                spSelectDevice.setAdapter(adapterSelectDevice);
                dialog.show();
            }
        });
        btnAddtoCartPD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(getContext());
                dialog.setContentView(R.layout.fragment_add_to_cart);
                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
                dialog.getWindow().setGravity(Gravity.BOTTOM);
                //LinkViews
                imvAddtoCart=dialog.findViewById(R.id.imvAddtoCart);
                txtNameAddtoCart=dialog.findViewById(R.id.txtNameAddtoCart);
                txtPriceAddtoCart=dialog.findViewById(R.id.txtPriceAddtoCart);
                spSelectDeviceATC=dialog.findViewById(R.id.spSelectDeviceATC);
                btnAddAddtoCart=dialog.findViewById(R.id.btnaddAddtoCart);
                btnMinusAddtoCart=dialog.findViewById(R.id.btnminusAddtoCart);
                txtNumberAddtoCart=dialog.findViewById(R.id.txtNumberAddtoCart);
                //addEvents
                btnAddAddtoCart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int num = Integer.parseInt(txtNumberAddtoCart.getText().toString());
                        int sum = num +1;
                        if(sum<10) {
                            txtNumberAddtoCart.setText(String.valueOf(sum));
                        }else{
                            Toast.makeText(getContext(), "Vượt quá số lượng đặt hàng cho phép", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                btnMinusAddtoCart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int num = Integer.parseInt(txtNumberAddtoCart.getText().toString());
                        int sum = num -1;
                        if(sum>=0) {
                            txtNumberAddtoCart.setText(String.valueOf(sum));
                        }
                    }
                });
                //loadData
                imvAddtoCart.setImageResource(p.getProductThumb());
                txtNameAddtoCart.setText(p.getProductName());
                txtPriceAddtoCart.setText(String.valueOf(p.getProductPrice()));
                selectDeviceATC= new ArrayList<String>();
                selectDeviceATC.add("Select one");
                selectDeviceATC.add("Iphone 13");
                selectDeviceATC.add("Iphone 11");
                selectDeviceATC.add("Iphone X");
                selectDeviceATC.add("Iphone 7");
                adapterSelectDeviceATC= new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item,selectDeviceATC);
                spSelectDeviceATC.setAdapter(adapterSelectDeviceATC);
                dialog.show();
            }
        });
    }


}