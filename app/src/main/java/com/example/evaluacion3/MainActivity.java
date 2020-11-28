package com.example.evaluacion3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText nombre,pass;
    private Button btnIngreso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre=findViewById(R.id.editNombre);
        pass=findViewById(R.id.editPass);
        btnIngreso=findViewById(R.id.btnIngresar);
        btnIngreso.setBackgroundColor(Color.WHITE);
        btnIngreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String NombreIngresado=nombre.getText().toString();
                String PassIngresado=pass.getText().toString();

                if(NombreIngresado.equals("Android") || NombreIngresado.equals("ANDROID") && PassIngresado.equals("123")){
                    Intent i=new Intent(getBaseContext(),Meun_Act.class);
                    startActivity(i);
                    Toast.makeText(getBaseContext(),"Bienvenido",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getBaseContext(),"El nombre o la contraseña son erroneas",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}