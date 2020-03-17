package com.example.vibha.diarypro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Delete_main extends AppCompatActivity {
    EditText et_del;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_main);
    }

    public void del_button(View V)
    {
        et_del = (EditText)findViewById(R.id.et_del);
        String etIDs = et_del.getText().toString();
        String s="" ;
        String m="";
        int n=0,z=0,n1=0;
        try
        {
            InputStreamReader fin = new InputStreamReader(openFileInput("main_f.txt"));
            Scanner scanner = new Scanner(fin);
            while(scanner.hasNextLine())
            {   n++;
                s = scanner.nextLine();
                if(s.equals(etIDs))
                {
                    z=n;
                    String s_mess = "Deleted";
                    Toast.makeText(getBaseContext(),s_mess, Toast.LENGTH_SHORT).show();
                    break;
                }
            }
            scanner.close();}
        catch (Exception e)
        {}
        if(z!=0)
        {
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
                    if (n1 == z)
                    {
                        for (int x = 0; x < 7; x++)
                        m = scanner.nextLine();
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
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
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
        else
        {String s_mess = "No Such Record Exists";
            Toast.makeText(getBaseContext(),s_mess, Toast.LENGTH_SHORT).show();}
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
