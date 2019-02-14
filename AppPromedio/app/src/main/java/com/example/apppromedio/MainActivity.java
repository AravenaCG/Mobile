package com.example.apppromedio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {


    private EditText et1;
    private EditText et2;
    private EditText et3;
    private TextView tv1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = (EditText) findViewById(R.id.etMate);
        et2 = (EditText) findViewById(R.id.etFisic);
        et3 = (EditText) findViewById(R.id.etQuimica);
        tv1 = (TextView) findViewById(R.id.tvStatus);

    }


    public void Promediar(View view)
    {
        String msj;
        float promedio;

        float suma = Integer.parseInt(et1.getText().toString()) + Integer.parseInt(et2.getText().toString()) + Integer.parseInt(et3.getText().toString());

        promedio = suma / 3;

        if (promedio >= 6)
        {
            msj = "Alumno aprobado con " + promedio;

        }
        else
        {
            msj = "Alumno reprobado con " + promedio;
        }

        tv1.setText(msj);
    }



}
