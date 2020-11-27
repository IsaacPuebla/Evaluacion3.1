package com.example.evaluacion3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

import Clases.BBDD;


public class Firebase_act extends AppCompatActivity {
    private EditText editNombre, editDestino, editPromo;
    private Button btnGuardar, btnMostrar;

    FirebaseDatabase firebase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_act);

        btnGuardar=findViewById(R.id.btnGuardar);
        btnMostrar=findViewById(R.id.btnMostrar);
        editNombre=findViewById(R.id.editNombre);
        editDestino=findViewById(R.id.editDestino);
        editPromo=findViewById(R.id.editPromo);

        inicializar();
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!editNombre.getText().toString().equals("") &&!editDestino.getText().toString().equals("") && !editPromo.getText().toString().equals("")){
                    BBDD bd=new BBDD();

                    bd.setId(UUID.randomUUID().toString());
                    bd.setNombre(editNombre.getText().toString());
                    bd.setDestino(editDestino.getText().toString());
                    bd.setPromocion(editPromo.getText().toString());

                    databaseReference.child("BBDD").child(bd.getId()).setValue(bd);
                    Toast.makeText(getBaseContext(),"Guardado con exito",Toast.LENGTH_LONG).show();
                }
                else Toast.makeText(getBaseContext(),"No debe dejar ningun campo vacio",Toast.LENGTH_LONG).show();


            }
        });
    }
    public void inicializar(){
        FirebaseApp.initializeApp(this);
        firebase= FirebaseDatabase.getInstance();
        databaseReference=firebase.getReference();
    }
    public void Mostrar(View v){
        Intent i=new Intent(getBaseContext(),Listado_act.class);
        startActivity(i);
    }
}