package com.example.bancobpm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.security.MessageDigest;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Seguridad_act extends AppCompatActivity {
    private EditText editext2;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seguridad_act);
        editext2=(EditText) findViewById(R.id.editext2);
        textView =(TextView)findViewById(R.id.textView);

    }
    private SecretKeySpec generatekey(String password)throws Exception{

        MessageDigest sh= MessageDigest.getInstance("SHA-256");// firma hmac sirve para garantizar la firma de los datos
        byte[] key = password.getBytes ("UTF-8");
        key = sh.digest(key);
        SecretKeySpec secretkey = new SecretKeySpec(key, "AES");
        return secretkey ;

    }
    public  String encriptar ( String datos,String password)throws Exception {
        // metodo para encriptar bajo el sifrado aes
        if (!editext2.getText().toString().isEmpty()){
            // encripta el dato, llamos a la llave
            SecretKeySpec secretkey = generatekey(password); // recibimos la clave
            Cipher cipher = Cipher.getInstance("AES"); // obtengo el algoritmo de la clase cipher
            cipher.init(cipher.ENCRYPT_MODE,secretkey); // encriptamos la llave

            byte[]encriptar = cipher.doFinal(datos.getBytes());
            String datosencriptadosstring = Base64.encodeToString(encriptar, Base64.DEFAULT);


            return datosencriptadosstring;
        }else{
            Toast.makeText(this, " debe ingresar contraseña", Toast.LENGTH_LONG).show();
            return null;
        }


    }
    public  void encriptar (View view){
        try{
            String mensaje= encriptar(editext2.getText().toString(), textView.getText().toString());
            textView.setText(mensaje);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}