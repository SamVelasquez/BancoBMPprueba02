package com.example.bancobpm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class Prestamos_act extends AppCompatActivity {
    private Spinner spinner , spinner2;
    private TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prestamos_act);
        spinner = (Spinner)findViewById(R.id.spinner);
        spinner2=(Spinner)findViewById(R.id.spinner2);
        textView2= (TextView)findViewById(R.id.textView2);

        //recibo el dato para el spiner1
        ArrayList<String> listaClientes = (ArrayList<String>)getIntent().getSerializableExtra("listaClientes");
        //creo el array adapter para el spinner
        ArrayAdapter<String> adapter=new ArrayAdapter<> (this, android.R.layout.simple_list_item_1, listaClientes);
        spinner.setAdapter(adapter);
        //recibo el dato para el spiner2
        ArrayList<String> listaCreditos = (ArrayList<String>)getIntent().getSerializableExtra("listaCreditos");
        ArrayAdapter<String> adapt =new ArrayAdapter<> (this, android.R.layout.simple_list_item_1, listaCreditos);
        spinner2.setAdapter(adapt);
    }

    public  void CalcularPrestamos (View view){
        String cliente = spinner.getSelectedItem().toString();
        String credito = spinner2.getSelectedItem().toString();

        if (cliente.equals("Axel") && credito.equals("credito Hipotecario")){

            int a = 1000000 + 750000 ;
            String resultado = String.valueOf(a);

            textView2.setText("Su prestamo es: " + resultado);
        }
        else if (cliente.equals("Roxana") && credito.equals("credito Hipotecario")){

            int a = 1000000 + 900000 ;
            String resultado = String.valueOf(a);

            textView2.setText("Su prestamo es: " + resultado);
        }
        else if (cliente.equals("Axel") && credito.equals("credito Automotriz")){

            int a = 500000 + 750000 ;
            String resultado = String.valueOf(a);

            textView2.setText("Su prestamo es: " + resultado);
        }
        else if (cliente.equals("Roxana") && credito.equals("credito Automotriz")){

            int a = 500000  + 900000 ;
            String resultado = String.valueOf(a);

            textView2.setText("Su prestamo es: " + resultado);
        }

    }
    public void calculardeuda (View view){

        String cliente = spinner.getSelectedItem().toString();
        String credito = spinner2.getSelectedItem().toString();

        if (cliente.equals("Axel") && credito.equals("credito Hipotecario")){

            int a = (1000000 + 750000)/12 ;
            String resultado = String.valueOf(a);

            textView2.setText("El total de su saldo hipotecario es: " + resultado);
        }
        else if (cliente.equals("Roxana") && credito.equals("credito Hipotecario")){

            int a = (1000000 + 900000)/12 ;
            String resultado = String.valueOf(a);

            textView2.setText("Su deuda es: " + resultado);
        }
        else if (cliente.equals("Axel") && credito.equals("credito Automotriz")){

            int a = (500000 + 750000)/8 ;
            String resultado = String.valueOf(a);

            textView2.setText("Su deuda es: " + resultado);
        }
        else if (cliente.equals("Roxana") && credito.equals("credito Automotriz")){

            int a = (500000  + 900000)/8 ;
            String resultado = String.valueOf(a);

            textView2.setText("Su deauda es: " + resultado);
        }

    }
}