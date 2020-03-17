package com.example.vibha.diarypro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Mod_sub extends AppCompatActivity {
    TextView txtView;
    String etID_s="123";
    EditText name1_;
    EditText name2_;
    EditText address_;
    EditText city_;
    EditText dob_;
    EditText mail_;
    EditText mob_;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mod_sub);
        Bundle bundle = getIntent().getExtras();
        etID_s = bundle.getString("message");
    }
    public void butt_click(View V)
    {
        name1_ = (EditText)findViewById(R.id.fname_);
        name2_ = (EditText)findViewById(R.id.lname_);
        address_ = (EditText)findViewById(R.id.address_);
        city_ = (EditText)findViewById(R.id.city_);
        dob_ = (EditText)findViewById(R.id.dob_);
        mail_ = (EditText)findViewById(R.id.mail_);
        mob_ = (EditText)findViewById(R.id.mob_);
        String name1_s = name1_.getText().toString();
        String name2_s = name2_.getText().toString();
        String address_s = address_.getText().toString();
        String city_s = city_.getText().toString();
        String dob_s = dob_.getText().toString();
        String mail_s = mail_.getText().toString();
        String mob_s = mob_.getText().toString();
        int n1=0;
        int z=Integer.parseInt(etID_s);
        String[] info ={name1_s,name2_s,address_s,city_s,dob_s,mail_s,mob_s};
            /*File newfile = new File("temp.txt");*/

            try
            {   File dir = getFilesDir();
                File newfile = new File(dir,"temp.txt");
                InputStreamReader fin = new InputStreamReader(openFileInput("main_f.txt"));
                Scanner scanner = new Scanner(fin);
                OutputStreamWriter f_out = new OutputStreamWriter(openFileOutput("temp.txt",MODE_APPEND));

                while (scanner.hasNextLine())
                {
                    n1++;
                    String a = scanner.nextLine();
                    if (n1 == z&&!(name1_s.equals(""))&&!(name2_s.equals(""))&&!(address_s.equals(""))&&!(city_s.equals(""))&&!(dob_s.equals(""))&&!(mail_s.equals("")))

                    { f_out.write(a + "\n");
                        for (int i = 0; i < 7; i++)
                        {
                            f_out.write(info[i] + "\n");
                            String tem = scanner.nextLine();
                        }
                    }
                    else
                        f_out.write(a + "\n");
                }
                f_out.close();
                scanner.close();
                File dir2 = getFilesDir();
                File oldfile = new File(dir2,"main_f.txt");
                Boolean b1 = oldfile.delete();
                Boolean b = newfile.renameTo(oldfile);
                if (!(name1_s.equals(""))&&!(name2_s.equals(""))&&!(address_s.equals(""))&&!(city_s.equals(""))&&!(dob_s.equals(""))&&!(mail_s.equals(""))&&!(mob_s.equals("")))
                {String s_mess = "Modified";
                Toast.makeText(getBaseContext(),s_mess, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
                    overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);}
                else
                    {String s_mess = "All fields are compulsory";
                        Toast.makeText(getBaseContext(),s_mess, Toast.LENGTH_SHORT).show();

                }
            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            /*File oldfile = new
            File("data.txt");
            Boolean b1 = oldfile.delete();
            Boolean b = newfile.renameTo(oldfile);*/
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
