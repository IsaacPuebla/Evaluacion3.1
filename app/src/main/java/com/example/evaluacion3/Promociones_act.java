package com.example.evaluacion3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

import Clases.PROMOCIONES;

public class Promociones_act extends AppCompatActivity {
    private Spinner spin1;
    private EditText editPromo,editValor;
    private Button btnCalculo;
    private TextView textoInfo, textoValor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promociones_act);

        spin1=findViewById(R.id.spin);
        editPromo=findViewById(R.id.editPrmociond);
        editValor=findViewById(R.id.editValord);
        btnCalculo=findViewById(R.id.btnCalculo);
        textoInfo=findViewById(R.id.text);
        textoValor=findViewById(R.id.text2);

        String []Clientes={"SELECCIONE CLIENTE","RAMIRO","ROSA","ROBERT"};
        ArrayAdapter<String> spinner=new ArrayAdapter <String>(getBaseContext(),android.R.layout.simple_list_item_1,Clientes);
        spin1.setAdapter(spinner);

        btnCalculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PROMOCIONES select=new PROMOCIONES();
                String cliente=spin1.getSelectedItem().toString();

                if(!editPromo.getText().toString().equals("") && !editValor.getText().toString().equals("")){
                    if(editPromo.getText().toString().equals("Master pizza") || editPromo.getText().toString().equals("Pizzas promo") || editPromo.getText().toString().equals("Pizza max")){
                        switch (editPromo.getText().toString()){
                            case "Master pizza":
                                String ValorEnvio=editValor.getText().toString();
                                int envio= Integer.parseInt(ValorEnvio);
                                int PrecioFinal=envio+select.getMasterPizza();
                                NumberFormat formato=NumberFormat.getIntegerInstance();
                                textoInfo.setText("Estimado/a "+cliente+"costo de promocion: $ "+select.getMasterPizza()+" mas costo de envio: $ "+envio+" el costo total a cancelar es de: ");
                                textoValor.setText("$ "+formato.format(PrecioFinal));

                                break;
                            case "Pizzas promo":
                                String ValorEnvio1=editValor.getText().toString();
                                int envio1= Integer.parseInt(ValorEnvio1);
                                int PrecioFinal1=envio1+select.getPizzasPromo();
                                NumberFormat formato1=NumberFormat.getIntegerInstance();
                                textoInfo.setText("Estimado/a "+cliente+"costo de promocion: $ "+select.getPizzasPromo()+" mas costo de envio: $ "+envio1+" el costo total a cancelar es de: ");
                                textoValor.setText("$ "+formato1.format(PrecioFinal1));
                                break;
                            case "Pizza max":
                                String ValorEnvio2=editValor.getText().toString();
                                int envio2= Integer.parseInt(ValorEnvio2);
                                int PrecioFinal2=envio2+select.getPizzasMax();
                                NumberFormat formato2=NumberFormat.getIntegerInstance();
                                textoInfo.setText("Estimado/a "+cliente+"costo de promocion: $ "+select.getPizzasMax()+" mas costo de envio: $ "+envio2+" el costo total a cancelar es de: ");
                                textoValor.setText("$ "+formato2.format(PrecioFinal2));
                                break;

                        }


                    }
                    else Toast.makeText(getBaseContext(),"No se reconoce la Promocion indicada",Toast.LENGTH_LONG).show();

                }

                else Toast.makeText(getBaseContext(),"Debe rellenar los todos campos",Toast.LENGTH_LONG).show();
            }

        });
    }
}