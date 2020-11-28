package com.example.evaluacion3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;


import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.EventListener;

import Clases.BBDD;

public class Listado_act extends AppCompatActivity {

    private ListView lista;
    private ArrayList < BBDD > listabbdd =new ArrayList <BBDD>();
    FirebaseDatabase firebase;
    DatabaseReference databaseReference;

    BBDD delete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_act);

        lista=findViewById(R.id.Lista);
        IniciarBase();

        databaseReference.child("BBDD").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot obj:snapshot.getChildren()){
                    BBDD dato=obj.getValue(BBDD.class);
                    listabbdd.add(dato);

                    ArrayAdapter adapter=new ArrayAdapter(getBaseContext(),android.R.layout.simple_list_item_1,listabbdd);
                    lista.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView < ? > parent, View view, int position, long id) {
                delete=(BBDD)parent.getItemAtPosition(position);
            }
        });
    }
    public void IniciarBase(){

        FirebaseApp.initializeApp(this);
        firebase= FirebaseDatabase.getInstance();
        databaseReference=firebase.getReference();
    }
    public void Eliminar(View v){
        BBDD c=new BBDD();
        c.setId(delete.getId());
        databaseReference.child("BBDD").child(c.getId()).removeValue();

        Toast.makeText(getBaseContext(),"Cliente eliminado",Toast.LENGTH_LONG).show();

        ArrayAdapter adapter=new ArrayAdapter(getBaseContext(),android.R.layout.simple_list_item_1,listabbdd);
        adapter.clear();
    }
}