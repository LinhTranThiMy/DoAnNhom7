package com.example.drawermenuex;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.bumptech.glide.Glide;
import com.example.adapter.ProductDetailsAdapter;
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

    //Dialog
    Spinner spSelectDeviceBN, spSelectDeviceATC;
    ArrayList<String> selectDeviceBN, selectDeviceATC;
    ArrayAdapter<String> adapterSelectDeviceBN, adapterSelectDeviceATC;
    ImageView imvBuyNow, imvAddToCart;
    TextView txtNameBuyNow, txtPriceBuyNow, txtQuantityBuyNow, txtNameAddToCart, txtPriceAddToCart, txtQuantityAddToCart;
    ImageButton btnMinusBuyNow, btnAddBuyNow, btnMinusAddToCart, btnAddAddToCart ;
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
                spSelectDeviceBN=dialog.findViewById(R.id.spSelectDeviceBN);
                btnAddBuyNow=dialog.findViewById(R.id.btnAddBuyNow);
                btnMinusBuyNow=dialog.findViewById(R.id.btnMinusBuyNow);
                txtQuantityBuyNow=dialog.findViewById(R.id.txtQuantityBuyNow);
                //addEvents
                btnAddBuyNow.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int quantity=Integer.parseInt(txtQuantityBuyNow.getText().toString());
                        if(quantity < 10)
                        {
                            quantity+=1;
                            txtQuantityBuyNow.setText(Integer.toString(quantity));
                        }else{
                            Toast.makeText(getContext(), "Vượt quá số lượng đặt hàng cho phép", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                btnMinusBuyNow.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int quantity=Integer.parseInt(txtQuantityBuyNow.getText().toString());
                        if(quantity > 1)
                        {
                            quantity-=1;
                            txtQuantityBuyNow.setText(Integer.toString(quantity));
                        }
                    }
                });
                //loadData
//                imvBuyNow.setImageResource(p.getProductThumb());
                Glide.with(getContext()).load(p.getProductThumb()).into(imvBuyNow);
                txtNameBuyNow.setText(p.getProductName());
                txtPriceBuyNow.setText(String.valueOf(p.getProductPrice()));
                selectDeviceBN= new ArrayList<String>();
                selectDeviceBN.add("Select one");
                selectDeviceBN.add("Iphone 13");
                selectDeviceBN.add("Iphone 11");
                selectDeviceBN.add("Iphone X");
                selectDeviceBN.add("Iphone 7");
                adapterSelectDeviceBN= new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item,selectDeviceBN);
                spSelectDeviceBN.setAdapter(adapterSelectDeviceBN);
                dialog.show();
            }
        });
        btnAddtoCartPD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(getContext());
                dialog.setContentView(R.layout.fragment_addtocart);
                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
                dialog.getWindow().setGravity(Gravity.BOTTOM);
                //LinkViews
                imvAddToCart=dialog.findViewById(R.id.imvAddToCart);
                txtNameAddToCart=dialog.findViewById(R.id.txtNameAddToCart);
                txtPriceAddToCart=dialog.findViewById(R.id.txtPriceAddToCart);
                spSelectDeviceATC=dialog.findViewById(R.id.spSelectDeviceATC);
                btnAddAddToCart=dialog.findViewById(R.id.btnAddAddToCart);
                btnMinusAddToCart=dialog.findViewById(R.id.btnMinusAddToCart);
                txtQuantityAddToCart=dialog.findViewById(R.id.txtQuantityAddToCart);
                //addEvents
                btnAddAddToCart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int quantity=Integer.parseInt(txtQuantityAddToCart.getText().toString());
                        if(quantity < 10)
                        {
                            quantity+=1;
                            txtQuantityAddToCart.setText(Integer.toString(quantity));
                        }else{
                            Toast.makeText(getContext(), "Vượt quá số lượng đặt hàng cho phép", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                btnMinusAddToCart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int quantity=Integer.parseInt(txtQuantityAddToCart.getText().toString());
                        if(quantity > 1)
                        {
                            quantity-=1;
                            txtQuantityAddToCart.setText(Integer.toString(quantity));
                        }
                    }
                });
                //loadData
//                imvAddToCart.setImageResource(p.getProductThumb());
                Glide.with(getContext()).load(p.getProductThumb()).into(imvAddToCart);
                txtNameAddToCart.setText(p.getProductName());
                txtPriceAddToCart.setText(String.valueOf(p.getProductPrice()));
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