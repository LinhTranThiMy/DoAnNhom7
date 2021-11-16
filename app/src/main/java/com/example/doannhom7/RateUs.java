package com.example.doannhom7;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class RateUs extends AppCompatActivity {
    Button btnOpenCamera,btnRateUs;
    ImageView imvPhoto;
    ActivityResultLauncher<Intent> activityResultLauncher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_us);
        linkViews();
        addEvents();


        activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        //Get image from camera
                        Bitmap bitmap = (Bitmap) result.getData().getExtras().get("data");
                        if (bitmap != null) {
                            imvPhoto.setImageBitmap(bitmap);
                        }

                    }
                });
    }


    private void linkViews() {
        btnOpenCamera = findViewById(R.id.btnOpenCamera);
        btnRateUs=findViewById(R.id.btnRateUs);
        imvPhoto = findViewById(R.id.imvPhoto);
    }

    private void addEvents() {
        btnOpenCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                if(intent.resolveActivity(getPackageManager()) !=null){
                activityResultLauncher.launch(intent);
//                }else{
//                    Toast.makeText(MainActivity.this, "No app support!",
//                            Toast.LENGTH_SHORT).show();
//                }

            }
        });
        btnRateUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RateUs.this,MyOrders.class);
                startActivity(intent);
            }
        });
    }
}