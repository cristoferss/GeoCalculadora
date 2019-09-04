package com.example.geocal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
//import android.widget.TextView;
import android.widget.Toast;
//import java.math.*;

public class Cuadrado extends AppCompatActivity {

    private Button btnVolver;
    private Button btnCalcular;
    private EditText etLadoCuadrado;
    //private TextView textViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuadrado);

        //Botones
        btnVolver  = (Button)findViewById(R.id.btnVolver);
        btnCalcular  = (Button)findViewById(R.id.btnCalcular);

        final String figura = "Cuadrado";

        //Variables de numeros para el calculo
        etLadoCuadrado = (EditText)findViewById(R.id.etLadoA);

        //Variable resultado
        //textViewResultado = (TextView)findViewById(R.id.textViewResultado);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validar()){

                    Toast.makeText(Cuadrado.this,"Datos ingresados correctamente",Toast.LENGTH_LONG).show();

                    int lado = Integer.parseInt(etLadoCuadrado.getText().toString());

                    int area = lado * lado;
                    int perimetro = lado * 4;
                    double diagonal = Math.sqrt(2) * lado;

                    String resuArea = String.valueOf(area);
                    String resuPerimetro = String.valueOf(perimetro);
                    String resuDiagonal = String.valueOf(diagonal);
                    //textViewResultado.setText(resu);

                    //Envio de variables a activity resultados Usando el metodo intent

                    Intent enviar = new Intent(getApplicationContext(), Resultados.class);
                    enviar.putExtra("figura", figura);
                    enviar.putExtra("area",resuArea);
                    enviar.putExtra("perimetro", resuPerimetro);
                    enviar.putExtra("diagonal", resuDiagonal);

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

        boolean retorno = true;

        String lado = etLadoCuadrado.getText().toString();

        if(lado.isEmpty()){
            etLadoCuadrado.setError("Debe ingresar el lado");
            retorno = false;
        }

        return retorno;
    }
}
