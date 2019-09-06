package com.example.geocal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Rombo extends AppCompatActivity {

    private Button btnVolver;
    private Button btnCalcular;
    private EditText etLadoA, etLadoB;
    private TextView textViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rombo);

        final String figura = "Rombo";

        //Botones
        btnVolver  = (Button)findViewById(R.id.btnVolver);
        btnCalcular  = (Button)findViewById(R.id.btnCalcular);

        //Variables de numeros para el calculo
        etLadoA = (EditText)findViewById(R.id.etLadoA);
        etLadoB = (EditText)findViewById(R.id.etLadoB);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (validar()) {

                    Toast.makeText(Rombo.this,"Datos ingresados correctamente",Toast.LENGTH_LONG).show();

                    int lado = Integer.parseInt(etLadoA.getText().toString());
                    int altura =  Integer.parseInt(etLadoB.getText().toString());

                    int area = lado * altura;
                    int perimetro = 4 * lado;

                    String resuArea = String.valueOf(area);
                    String resuPerimetro = String.valueOf(perimetro);

                    Intent enviar = new Intent(getApplicationContext(), Resultados.class);
                    enviar.putExtra("figura", figura);
                    enviar.putExtra("area",resuArea);
                    enviar.putExtra("perimetro", resuPerimetro);

                    //Envio de paratametros a activity resultados
                    startActivity(enviar);

                }


            }
        });

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent btnVolver = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(btnVolver);
            }
        });
    }

    public boolean validar(){
        boolean retorno=true;

        String ladoA = etLadoA.getText().toString();
        String ladoB = etLadoB.getText().toString();

        if (ladoA.isEmpty()) {
            etLadoA.setError("Debe ingresar el lado");
            retorno = false;
        }

        if (ladoB.isEmpty()) {
            etLadoB.setError("Debe ingresar la altura");
            retorno = false;
        }

        return retorno;
    }
}
