package com.example.vibha.diarypro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.File;
import java.io.InputStreamReader;
import java.util.Scanner;

public class First extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
    }
    public void button_new(View V)
    {   Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
