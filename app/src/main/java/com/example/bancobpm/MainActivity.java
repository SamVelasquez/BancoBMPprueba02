package com.example.bancobpm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progress;
    private Button btton1;
    private EditText edtNombre, edtpassowrd;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // declaracion de variable
        progress = (ProgressBar)findViewById(R.id.progressBar);
        btton1 = (Button)findViewById(R.id.btton1);
        edtNombre= (EditText)findViewById(R.id.edtNombre);
        edtpassowrd= (EditText)findViewById(R.id.edtPassword);

        btton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = edtNombre.getText().toString();
                String pass = edtpassowrd.getText().toString();
                if(nombre.equalsIgnoreCase("android") && pass.equals("123")) {

                    new Task().execute(); // ejecuta mi tarea asíncrona.
                }
                else{
                    Toast.makeText(getApplicationContext(),"Datos incorrectos",Toast.LENGTH_SHORT).show();
                }


            }
        });


        progress.setVisibility(View.INVISIBLE); // desaparece el elemento para que no se vea antes de iniicar la actividad.
    }

    // Tarea Asíncrona.

    class Task extends AsyncTask<String, Void, String> {

        @Override  // Vamos a darle la configuración inicial a la tarea
        protected void onPreExecute() {

            progress.setVisibility(View.VISIBLE);
        }


        @Override // vamos a emplear el proceso o tarea pesada en segundo plano.
        protected String doInBackground(String... strings) {


           /* if(nombre.equalsIgnoreCase("android") && pass.equals("123"))
            {
                for(int i = 1; i < 10; i++)
                {
                    try {
                        Thread.sleep(1000);

                    }catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            }
            else{
                Toast.makeText(getApplicationContext(),"Datos incorrectos",Toast.LENGTH_SHORT).show();
            }*/
            for(int i = 1; i < 10; i++)
            {
                try {
                    Thread.sleep(1000);

                }catch (Exception e)
                {
                    e.printStackTrace();
                }
            }

            return null;
        }

        @Override // finalizamos la tarea
        protected void onPostExecute(String s) {

            progress.setVisibility(View.INVISIBLE);

            Intent i = new Intent(getBaseContext(), Home_act.class);
            startActivity(i);

        }
    }


}