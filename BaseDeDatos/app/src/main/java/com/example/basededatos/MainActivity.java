package com.example.basededatos;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.strictmode.SqliteObjectLeakedViolation;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et_codigo,et_descripcion,et_precio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_codigo = (EditText) findViewById(R.id.etID);
        et_descripcion= (EditText) findViewById( R.id.etDescripcion);
        et_precio = (EditText) findViewById(R.id.etPrecio);

    }

    public void Registrar(View view)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase baseDeDatos = admin.getWritableDatabase();
        String codigo = et_codigo.getText().toString();
        String descripcion = et_descripcion.getText().toString();
        String precio= et_precio.getText().toString();

        if (!codigo.isEmpty() && !descripcion.isEmpty() && !precio.isEmpty())
        {
            ContentValues registro = new ContentValues();
            registro.put("codigo",codigo);
            registro.put("descripcion",descripcion);
            registro.put("Precio",precio);

            baseDeDatos.insert("articulos", null, registro);
            baseDeDatos.close();
            et_codigo.setText("");
            et_descripcion.setText("");
            et_precio.setText("");
            Toast.makeText(this,"Registro Exitoso", Toast.LENGTH_SHORT).show();

        }
        else{
            Toast.makeText(this,"Complete los campos", Toast.LENGTH_SHORT).show();
        }



    }

    public void Buscar(View view)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null,1);
        SQLiteDatabase baseDeDatos = admin.getWritableDatabase();

        String codigo = et_codigo.getText().toString();

        if (!codigo.isEmpty())
        {
            Cursor fila = baseDeDatos.rawQuery("select descripcion, precio from articulos where codigo =" + codigo,null);

            if (fila.moveToFirst()){
                et_descripcion.setText(fila.getString(0));
                et_precio.setText(fila.getString(1));

                baseDeDatos.close();

            }else{
                Toast.makeText(this,"No existe el articulo",Toast.LENGTH_SHORT).show();
                baseDeDatos.close();
            }

        }else{

        }

    }

    public void Eliminar (View view)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administracion",null,1);
        SQLiteDatabase baseDeDatos = admin.getWritableDatabase();

        String codigo = et_codigo.getText().toString();

        if(!codigo.isEmpty())
        {
            int cantidad = baseDeDatos.delete("articulos", "codigo ="+ codigo,null);

            baseDeDatos.close();

            et_precio.setText("");
            et_codigo.setText("");
            et_descripcion.setText("");


            if (cantidad == 1  ){
                Toast.makeText(this, "Se ha borrado exitosamente", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this,"no se ha encontrado articulo para eliminar",Toast.LENGTH_SHORT).show();
            }

        }else {

            Toast.makeText(this, "No se ha ingresado Codigo para buscar!", Toast.LENGTH_SHORT).show();
        }
    }

    public void Modificar(View view)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null,1);
        SQLiteDatabase baseDeDatos = admin.getWritableDatabase();


        String codigo = et_codigo.getText().toString();
        String descripcion = et_descripcion.getText().toString();
        String precio= et_precio.getText().toString();


        if (!codigo.isEmpty() && !descripcion.isEmpty() && !precio.isEmpty())
        {
           ContentValues registro = new ContentValues();
           registro.put("codigo", codigo);
           registro.put("descripcion", descripcion);
           registro.put("precio", precio);

           int cantidad = baseDeDatos.update("articulos", registro, "codigo ="+ codigo,null);
           baseDeDatos.close();

           if (cantidad == 1)
           {
               Toast.makeText(this,"se ha actualizado el registro", Toast.LENGTH_SHORT).show();

           } else
           {
               Toast.makeText(this, "No se ha ingresado Codigo para buscar!", Toast.LENGTH_SHORT).show();
           }
        }
        else{
            Toast.makeText(this,"Complete los campos", Toast.LENGTH_SHORT).show();
        }



    }
}
