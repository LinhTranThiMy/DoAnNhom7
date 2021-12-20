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

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.bumptech.glide.Glide;
import com.example.adapter.ProductDetailsAdapter;
import com.example.interfaces.ICartLoadListener;
import com.example.model.CartModel;
import com.example.model.Product;
import com.example.model.ProductDetailsBanner;
import com.example.util.Constant;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class ProductDetailsFragment extends Fragment {
    ImageButton btnBackProductDetails;
    Button btnBuyNowPD,btnAddtoCartPD;
    TextView txtNameProductDetails, txtRatingProductDetails, txtPriceProductDetails,txtDescription;
    RatingBar Rating_bar_products_details;
    RecyclerView rcvProductDetails;
    ArrayList<ProductDetailsBanner> productDetails;
    ProductDetailsAdapter adapter;
    Product p;


    //Dialog
    Spinner spSelectDeviceBN, spSelectDeviceATC;
    ArrayList<String> selectDeviceBN, selectDeviceATC;
    ArrayAdapter<String> adapterSelectDeviceBN, adapterSelectDeviceATC;
    ImageView imvBuyNow, imvAddToCart;
    TextView txtNameBuyNow, txtPriceBuyNow, txtQuantityBuyNow, txtNameAddToCart, txtPriceAddToCart, txtQuantityAddToCart;
    ImageButton btnMinusBuyNow, btnAddBuyNow, btnMinusAddToCart, btnAddAddToCart ;

    ICartLoadListener cartLoadListener;

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
        txtDescription=view.findViewById(R.id.txtDescription);


        btnBuyNowPD=view.findViewById(R.id.btnBuyNowPD);
        btnAddtoCartPD=view.findViewById(R.id.btnAddtoCartPD);
        //lấy dữ liệu từ màn hình sản phẩm
        Bundle bundle = getArguments();
        if(bundle != null)
        {
            p = (Product) bundle.get(Constant.SELECTED_ITEM);
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
            txtDescription.setText(p.getProductDes());
        }


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
                addToCart();
                replaceFragment( new CartFragment());
            }
        });
        btnAddtoCartPD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToCart();
            }
        });

    }
    private void replaceFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction= getParentFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();
    }

    private void addToCart() {
        DatabaseReference userCart = FirebaseDatabase
                .getInstance()
                .getReference("Cart")
                .child("UNIQUE_USER_ID"); //In other project, you'll add user id here

        userCart.child("NUMBER")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        if (snapshot.exists()) //If user already have item in cart
                        {
                            //Just update quantity and totalPrice
                            CartModel cartModel = snapshot.getValue(CartModel.class);
                            cartModel.setQuantity(cartModel.getQuantity() + 1);
                            Map<String, Object> updateData = new HashMap<>();
                            updateData.put("quantity", cartModel.getQuantity() + 1);
                            updateData.put("totalPrice", cartModel.getQuantity() * Double.parseDouble(cartModel.getPrice()));

                            userCart.child("NUMBER")
                                    .updateChildren(updateData)
                                    .addOnSuccessListener(aVoid -> {
                                        cartLoadListener.onCartLoadFailed("Add To Cart Success!");
                                    })
                                    .addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            cartLoadListener.onCartLoadFailed(e.getMessage());
                                        }
                                    });

                        } else //If item not have in cart, add new
                        {
                            CartModel cartModel = new CartModel();
                            cartModel.setName(p.getProductName());
                            cartModel.setImage(p.getProductThumb());
                            cartModel.setKey(p.getKey());
                            cartModel.setPrice(String.valueOf(p.getProductPrice()));
                            cartModel.setQuantity(1);
                            cartModel.setTotalPrice((p.getProductPrice()));

                            userCart.child(p.getProductId())
                                    .setValue(cartModel).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    Toast.makeText(getContext(), "Success", Toast.LENGTH_SHORT).show();
                                }
                            })
                                    .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(getContext(), "Fail", Toast.LENGTH_SHORT).show();
                                }
                            });
//                                    .addOnSuccessListener(aVoid -> {
//                                        cartLoadListener.onCartLoadFailed("Add To Cart Success!");
//                                    })
//
                            //7:11 - Part 2
//                                    .addOnFailureListener(e -> cartLoadListener.onCartLoadFailed(e.getMessage()));
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                        cartLoadListener.onCartLoadFailed(error.getMessage());

                    }
                });
    }


}