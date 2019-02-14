package com.example.projectmerchan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import android.widget.Toast;
import android.view.View;

public class MainActivity extends AppCompatActivity {

   // private EditText pass;
    private EditText user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // pass =  findViewById(R.id.textPass);
        user =  findViewById(R.id.txtUser);
    }

    public void Ingresar (View view)
    {

        String auxuser =  user.getText().toString();
       // String auxpass =  pass.getText().toString();

        if (  auxuser.contentEquals("admin"))
        {
            Toast.makeText(this, "Access Granted", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "Access Denied",Toast.LENGTH_SHORT).show();
        }



    }
}
