package com.example.bancobpm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import Clases.AdminSQLiteOpenHelper;

public class Clientes_act extends AppCompatActivity {
    private EditText codigo, nombre, salario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes_act);
        codigo = (EditText)findViewById(R.id.codigo);
        nombre = (EditText)findViewById(R.id.nombre);
        salario = (EditText)findViewById(R.id.salario);
    }

    public void crearCliente(View view)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "fichero", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();
        if(!codigo.getText().toString().isEmpty())
        {
            ContentValues cont = new ContentValues();
            cont.put("codigo", codigo.getText().toString());
            cont.put("nombre", nombre.getText().toString());
            cont.put("salario", salario.getText().toString());
            db.insert("productos",null,cont);
            db.close();
            Toast.makeText(this,"Se ha insertado un producto", Toast.LENGTH_LONG).show();
            codigo.setText("");
            nombre.setText("");
            salario.setText("");
        }else{
            Toast.makeText(this,"Ha ocurrido un problema al insertar", Toast.LENGTH_LONG).show();
        }
    }

    public void mostrarCliente(View view) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "fichero", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();
        String numero = codigo.getText().toString();

        if (!numero.isEmpty())
        {
            Cursor fila = db.rawQuery("SELECT  nombre, salario FROM productos WHERE codigo= " + numero, null);
            if (fila.moveToFirst()) //SI HAY DATOS
            {
                nombre.setText(fila.getString(0));
                salario.setText(fila.getString(1));
            }
            else{
                Toast.makeText(this, " no hay campos en la tabla ",Toast.LENGTH_LONG).show(); }
            }
            else {
            Toast.makeText(this, "No exiete producto", Toast.LENGTH_LONG).show();
        }
    }

    public void eliminarCliente(View view) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "fichero", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();
        String numero = codigo.getText().toString();

        if (!numero.isEmpty())
        {
            db.delete("productos","codigo="+numero,null);
            db.close();
            codigo.setText("");
            nombre.setText("");
            salario.setText("");
            Toast.makeText(this, "Se ha eliminado el producto", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this, "No exiete producto", Toast.LENGTH_LONG).show();
        }
    }

    public void actualizarCliente(View view) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "fichero", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();
        String numero = codigo.getText().toString();

        ContentValues cont = new ContentValues();

        cont.put("codigo",codigo.getText().toString());
        cont.put("nombre",nombre.getText().toString());
        cont.put("salario",salario.getText().toString());

        if (!numero.isEmpty())
        {
           db.update("productos",cont,"codigo="+numero,null);
            db.close();
            codigo.setText("");
            nombre.setText("");
            salario.setText("");
            Toast.makeText(this, "Se ha actualizado el producto", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this, "No se ha podido actualizar el producto", Toast.LENGTH_LONG).show();
        }
    }

}