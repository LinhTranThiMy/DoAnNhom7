package com.example.drawermenuex;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class RateUs extends Fragment {

    Button btnCamera, btnRateUs;
    ImageButton btnBackRate;
    ImageView imvPhoto;
    EditText edtComment;
    RatingBar ratingStar;

    BottomSheetDialog sheetDialog;

    LinearLayout sheetOpenCam, sheetOpenGallery;

    ActivityResultLauncher<Intent> activityResultLauncher;

    boolean isCamera;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rateus, container, false);
        //Ẩn actionBar
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();

        btnCamera= view.findViewById(R.id.btnCamera);
        btnRateUs=view.findViewById(R.id.btnRateUs);
        imvPhoto=view.findViewById(R.id.imvPhoto);
        edtComment=view.findViewById(R.id.edtComment);
        ratingStar=view.findViewById(R.id.ratingStar);
        btnBackRate=view.findViewById(R.id.btnBackRate);

        addEvents();
        createBottomSheet();
        activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            private static final int RESULT_OK =-1 ;

            @Override
            public void onActivityResult(ActivityResult result) {
                //bắt điều kiện để lưu ảnh chụp
                if(result.getResultCode() == RESULT_OK && result.getData()!=null){
                    if(isCamera){
                        Bitmap bitmap = (Bitmap) result.getData().getExtras().get("data");
                        imvPhoto.setImageBitmap(bitmap);
                    }else{
                        Uri uri = result.getData().getData();
                        if(uri != null){
                            try {
                                InputStream inputStream = getActivity().getContentResolver().openInputStream(uri);
                                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                                imvPhoto.setImageBitmap(bitmap);
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                }
            }
        });


        return view;
    }
    private void addEvents() {
        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Open bottom sheet
                sheetDialog.show();
            }
        });
        btnRateUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Chỗ này chưa được ai cíu dùm em!!!!

                if(edtComment.equals("") || imvPhoto.getDrawable()==null) {
                    Toast.makeText(getActivity(), "Please fill all fields", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getActivity(),"Rate success!",Toast.LENGTH_SHORT).show();
                    replaceFragment(new MyOrderFragment());
                }
            }
        });
        btnBackRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager().popBackStack();
            }
        });
    }

    private void createBottomSheet() {
        if(sheetDialog == null) {
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.bottom_sheet, null);
            sheetOpenCam = view.findViewById(R.id.sheetOpenCamera);
            sheetOpenCam.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Open cam
                    isCamera = true;
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    activityResultLauncher.launch(intent);
                    sheetDialog.dismiss();

                }
            });

            sheetOpenGallery = view.findViewById(R.id.sheetOpenGallery);
            sheetOpenGallery.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Open gallery
                    isCamera = false;
                    Intent intent = new Intent(Intent.ACTION_PICK);
                    intent.setType("image/*");
                    activityResultLauncher.launch(intent);
                    sheetDialog.dismiss();
                }
            });
            sheetDialog = new BottomSheetDialog(getActivity());
            sheetDialog.setContentView(view); //truyền vô view bottom sheet đã nạp ở trên
        }
    }
    private void replaceFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }

}