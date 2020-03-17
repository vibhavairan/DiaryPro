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

public class Search_main extends AppCompatActivity
{
    EditText etID;
    TextView sear_inf;
    String[] s1={"ID: ","First Name: ","Last Name: ","Address: ","City: ","Date of Birth: ","Email: ","Contact No: "};
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_main);
    }
    public void button_check(View v)
    {   sear_inf = (TextView) findViewById(R.id.sear_inf);
        etID = (EditText)findViewById(R.id.etid);
        String etIDs = etID.getText().toString();
        String ret="";
        String s="" ;
        int x=0;
        try
        {
            InputStreamReader fin = new InputStreamReader(openFileInput("main_f.txt"));
            Scanner scanner = new Scanner(fin);
            while(scanner.hasNextLine())
            {
                s = scanner.nextLine();
                if(s.equals(etIDs))
                {
                    for(x=0;x<8;x++)
                    { ret = ret + s1[x];
                      ret = ret + s + "\n";
                      s = scanner.nextLine();}
                      break;
                }
            }

            scanner.close();}
        catch (Exception e)
        {}
        if(x==0)
        {String s_mess = "No Such Record Exists";
            Toast.makeText(getBaseContext(),s_mess, Toast.LENGTH_SHORT).show();}
            else
        {String s_mess = "Success";
        Toast.makeText(getBaseContext(),s_mess, Toast.LENGTH_SHORT).show();
        sear_inf.setText(ret);}
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
