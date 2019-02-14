package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;



import static com.example.myapplication.Calculadora.*;


public class MainActivity extends AppCompatActivity {

    private EditText et1;
    private EditText et2;
    private TextView tv1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.Txt_num1);
        et2 = (EditText) findViewById(R.id.Txt_num2);
        tv1 = (TextView) findViewById(R.id.TxtResultado);





    }

    public void Sumar(View view)
    {
        int result = Suma(Integer.parseInt(et1.getText().toString()),Integer.parseInt(et2.getText().toString()));
        String mostrar = String.valueOf(result);
        tv1.setText(mostrar);

    }

    public void Restar(View view)
    {
        int result = Resta(Integer.parseInt(et1.getText().toString()),Integer.parseInt(et2.getText().toString()));
        String mostrar = String.valueOf(result);
        tv1.setText(mostrar);
    }

    public void Dividir(View view)
    {
        float result = Div(Integer.parseInt(et1.getText().toString()),Integer.parseInt(et2.getText().toString()),"No se puede dividir por ZERO!!");
        String mostrar = String.valueOf(result);
        tv1.setText(mostrar);
    }

    public void Multiplicar(View view)
    {
        int result = Multi(Integer.parseInt(et1.getText().toString()),Integer.parseInt(et2.getText().toString()));
        String mostrar = String.valueOf(result);
        tv1.setText(mostrar);
    }

}
