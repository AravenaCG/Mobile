package com.example.promerchan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText textUser;
    private EditText textPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textUser = findViewById(R.id.txtUser);
        textPass = findViewById(R.id.txtPass);

    }


    public void Ingresar (View view)
    {
        String auxUsr = textUser.getText().toString();
        String auxPass =  textPass.getText().toString();

        if (auxUsr.contentEquals("admin") && auxPass.contentEquals("admin"))
        {
            Toast.makeText(this,"Acces Granted", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, MenuActivity.class);
            startActivity(i);
        }
        else
        {
            Toast.makeText(this, "Access Denied",Toast.LENGTH_SHORT).show();
        }
    }
}
