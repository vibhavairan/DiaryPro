package com.example.vibha.diarypro;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class
Display_Record extends AppCompatActivity
{   String[] s1={"ID: ","First Name: ","Last Name: ","Address: ","City: ","Date of Birth: ","Email: ","Contact No: "};
    TextView tvInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display__record);
        tvInfo = (TextView) findViewById(R.id.tvInfo);
        String ret="";
        String s="" ;
        try
        {
        InputStreamReader fin = new InputStreamReader(openFileInput("main_f.txt"));
        Scanner scanner = new Scanner(fin);
        int n=1;int k=0;
        while(scanner.hasNextLine())
        {
             s = scanner.nextLine();
             if((n-1)%8==0)
              ret=ret+"Record Number: "+(((n-1)/8)+1)+"\n";
            ret = ret + s1[k];
            k++;
            if(k==8)
             k=0;
            ret = ret + s + "\n";
            if(n%8==0)
            ret= ret+"\n";
            n++;
        }
        scanner.close();
        }
        catch (Exception e){}
        if(ret.equals(""))
            ret="There are currently zero records";
        tvInfo.setText(ret);

    }
    public void click_button(View v)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
    }
}
