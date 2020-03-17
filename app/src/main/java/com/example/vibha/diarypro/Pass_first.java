package com.example.vibha.diarypro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.OutputStreamWriter;

public class Pass_first extends AppCompatActivity {
    EditText et_pass;
    EditText et_pass2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass_first);
    }
    public void button_pass(View V)
    {et_pass = (EditText) findViewById(R.id.et_pass);
     et_pass2 = (EditText) findViewById(R.id.et_pass2);
     String et_pass_s = et_pass.getText().toString();
     String et_pass2_s = et_pass2.getText().toString();
     if(!(et_pass2_s.equals(et_pass_s))||et_pass2_s.length()!=4||et_pass_s.length()!=4)
     {String s_mess = "Wrong Input";
      Toast.makeText(getBaseContext(),s_mess, Toast.LENGTH_LONG).show();}
      else
     {try{
         OutputStreamWriter f_out = new OutputStreamWriter(openFileOutput("pass.txt",MODE_PRIVATE));

     f_out.write(et_pass_s);}
     catch (Exception e)
     {}}
    }

}
