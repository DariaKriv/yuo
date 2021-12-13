package com.example.mycamera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private Button btnCamera;
    private ImageView imgPhoto;
    private final int REQUEST_CAMERA_IMAGE = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCamera = (Button) findViewById(R.id.button);
        imgPhoto = (ImageView) findViewById(R.id.imageView);
    }

    public void onClick(View view) {
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent,REQUEST_CAMERA_IMAGE);
    }

    @Override
    protected void onActivityResult (int reguestCode,int resultCode,Intent data){
        super.onActivityResult(reguestCode,resultCode,data);
        if (reguestCode == REQUEST_CAMERA_IMAGE){
            Bitmap imageBitmap = (Bitmap)  data.getExtras().get("data");
            imgPhoto.setImageBitmap(imageBitmap);
        }
    }
}