package com.example.vibha.diarypro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Modify_main extends AppCompatActivity {
EditText id_mod;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_main);
    }
public void buttonpress(View v)
{
    id_mod = (EditText)findViewById(R.id.id_mod);
    String s_mod = id_mod.getText().toString();
    String ret="";
    String s="" ;
    int n=0,z=0;
    try
    {
        InputStreamReader fin = new InputStreamReader(openFileInput("main_f.txt"));
        Scanner scanner = new Scanner(fin);
        while(scanner.hasNextLine())
        {   n++;
            s = scanner.nextLine();
            if(s.equals(s_mod))
            {
                z=n;
                break;
            }
        }
        if(z>0)
        {   String pass = Integer.toString(z);
            Intent intent = new Intent(Modify_main.this, Mod_sub.class);
            intent.putExtra("message",pass);
            startActivity(intent);
            finish();
            overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
        }else
        {String s_mess = "No Such Record Exists";
            Toast.makeText(getBaseContext(),s_mess, Toast.LENGTH_SHORT).show();}
        scanner.close();
    }
    catch (Exception e)
    {}
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
