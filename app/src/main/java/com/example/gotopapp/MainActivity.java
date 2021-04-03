package com.example.gotopapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tampilan_menu);
    }

    public void clickRS(View view) {

        //gambar RS di click
        Intent i = new Intent(this,RS.class);
        startActivity(i);
    }

    public void clickKP(View view) {
        //gambar KP di click
        Intent i = new Intent(this,KP.class);
        startActivity(i);
    }

    public void clickSP(View view) {
        //gambar SP di click
        Intent i = new Intent(this,SP.class);
        startActivity(i);
    }

    public void clickscool(View view) {
        //gambar school di click
        Intent i = new Intent(this, school.class);
        startActivity(i);
    }


}