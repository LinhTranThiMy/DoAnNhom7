package com.example.drawermenuex;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class Checkout1Fragment extends Fragment {
    Button btnContinueCheckOut1;
    AutoCompleteTextView spProvince;
    EditText edtFullNameCK,edtPhone,edtAddressDetail;
    String[] provinces={"An Giang","Long An","Bà Rịa – Vũng Tàu","Bạc Liêu","Bắc Giang","Bắc Kạn","Bắc Ninh","Bến Tre","Bình Dương", "Bình Định","Bình Phước","Cà Mau", "Bình Thuận"
    ,"Cao Bằng","Cần Thơ","Đà Nẵng","Đắk Lắk","Đắk Nông","Điện Biên","Đồng Nai","Đồng Tháp","Gia Lai","Hà Giang","Hà Nam","Hà Nội","Hà Tĩnh","Hải Dương","Hải Phòng","Hậu Giang","Hòa Bình","Thành phố Hồ Chí Minh"
            ,"Hưng Yên","Khánh Hòa","Kiên Giang","Kon Tum","Lai Châu","Lạng Sơn","Lào Cai","Lâm Đồng","Nam Định","Nghệ An","Ninh Bình","Ninh Thuận","Phú Thọ","Phú Yên","Quảng Bình","Quảng Nam","Quảng Ngãi","Quảng Ninh","Quảng Trị"
            ,"Sóc Trăng","Sơn La","Tây Ninh","Thái Bình","Thái Nguyên","Thanh Hóa","Thừa Thiên Huế","Tiền Giang","Trà Vinh","Tuyên Quang","Vĩnh Long","Vĩnh Phúc","Yên Bái"};
    private View view;
    ArrayAdapter<String> adapterProvince;
    public Checkout1Fragment(){

    }

//    public static final String DB_NAME = "dvhcvn.db";
//    public static final String DB_PATH_SUFFIX = "/databases/";
//    public static SQLiteDatabase db = null;




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_checkout1, container, false);
        linkViews();
//        initData();
        loadData();
        addEvents();
        return view;
    }

    private void linkViews() {
        btnContinueCheckOut1=view.findViewById(R.id.btnContinueCheckOut1);
        spProvince=view.findViewById(R.id.spProvince);
        edtFullNameCK=view.findViewById(R.id.edtFullNameCK);
        edtPhone=view.findViewById(R.id.edtPhone);
        edtAddressDetail=view.findViewById(R.id.edtAddressDetail);


    }

    private void addEvents() {
        spProvince.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnContinueCheckOut1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle= new Bundle();
                bundle.putString("fullname",edtFullNameCK.getText().toString());
                bundle.putString("phone",edtPhone.getText().toString());
                bundle.putString("province",spProvince.getText().toString());
                bundle.putString("adDetail",edtAddressDetail.getText().toString());
                Checkout2Fragment checkout2Fragment=new Checkout2Fragment();
                checkout2Fragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.layout_Checkout,checkout2Fragment).commit();
            }
        });
    }


    private void loadData() {
        adapterProvince= new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1,provinces);
        spProvince.setAdapter(adapterProvince);

    }
    private void replaceFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction= getParentFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();
    }


}
