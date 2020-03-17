package com.example.vibha.diarypro;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Add_Record extends AppCompatActivity {
    EditText etID;
    EditText name1;
    EditText name2;
    EditText address;
    EditText city;
    EditText dob;
    EditText mail;
    EditText mob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__record);
    }
    public void button_done(View v)
    {
        name1 = (EditText)findViewById(R.id.fname);
        name2 = (EditText)findViewById(R.id.lname);
        address = (EditText)findViewById(R.id.address);
        city = (EditText)findViewById(R.id.city);
        dob = (EditText)findViewById(R.id.dob);
        mail = (EditText)findViewById(R.id.mail);
        mob = (EditText)findViewById(R.id.mob);
        String etIDs = "123";
        String name1s = name1.getText().toString();
        String name2s = name2.getText().toString();
        String addresss = address.getText().toString();
        String citys = city.getText().toString();
        String dobs = dob.getText().toString();
        String mails = mail.getText().toString();
        String mobs = mob.getText().toString();
        try {
            OutputStreamWriter f_out = new OutputStreamWriter(openFileOutput("main_f.txt",MODE_APPEND));
            try{
                InputStreamReader fin = new InputStreamReader(openFileInput("id.txt"));
                Scanner scanner = new Scanner(fin);
                etIDs = scanner.nextLine();
                scanner.close();
            }catch (FileNotFoundException m)
            {  etIDs = "101";}

            String[] info ={etIDs,name1s,name2s,addresss,citys,dobs,mails,mobs};
            if(!(etIDs.equals(""))&&!(name1s.equals(""))&&!(name2s.equals(""))&&!(addresss.equals(""))&&!(citys.equals(""))&&!(dobs.equals(""))&&!(mails.equals(""))&&!(mobs.equals("")))
            for(int i =0; i < info.length; i++)
                f_out.write(info[i]+"\n");
           /* File fileDir = new File(getFilesDir(),"main_f.txt");
            Toast.makeText(getBaseContext(),"File Saved at "+fileDir,Toast.LENGTH_LONG).show();*/

            f_out.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
       if(!(etIDs.equals(""))&&!(name1s.equals(""))&&!(name2s.equals(""))&&!(addresss.equals(""))&&!(citys.equals(""))&&!(dobs.equals(""))&&!(mails.equals(""))&&!(mobs.equals("")))
       { String s_mess = "Added";
        Toast.makeText(getBaseContext(),s_mess, Toast.LENGTH_SHORT).show();
           try
           {
               OutputStreamWriter f_out = new OutputStreamWriter(openFileOutput("id.txt",MODE_PRIVATE));
               int id = (Integer.parseInt(etIDs));
               id++;
               String id_new = Integer.toString(id);
               f_out.write(id_new);
               f_out.close();
           }catch (FileNotFoundException e) {
               e.printStackTrace();} catch (IOException e) {
               e.printStackTrace();
           }

           Intent intent = new Intent(this, MainActivity.class);
           startActivity(intent);
           finish();
           overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
       }
        else
       {
           String s_mess = "All Fields are compulsory!";
           Toast.makeText(getBaseContext(),s_mess, Toast.LENGTH_SHORT).show();
       }

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
