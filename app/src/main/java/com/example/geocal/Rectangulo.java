package com.example.geocal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Rectangulo extends AppCompatActivity {

    private Button btnVolver;
    private Button btnCalcular;
    private EditText etLadoA, etLadoB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangulo);

        final String figura = "Rectángulo";

        //Botones
        btnVolver  = (Button)findViewById(R.id.btnVolver);
        btnVolver  = (Button)findViewById(R.id.btnVolver);
        btnCalcular  = (Button)findViewById(R.id.btnCalcular);
        //Variables de numeros para el calculo

        etLadoA = (EditText)findViewById(R.id.etLadoA);
        etLadoB = (EditText)findViewById(R.id.etLadoB);


        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (validar()) {

                    Toast.makeText(Rectangulo.this,"Datos ingresados correctamente",Toast.LENGTH_LONG).show();

                    int ladoA = Integer.parseInt(etLadoA.getText().toString());
                    int ladoB = Integer.parseInt(etLadoB.getText().toString());

                    int area = ladoA * ladoB;
                    int perimetro = 2 * (ladoA * ladoB);
                    double diagonal = Math.sqrt( Math.pow(ladoA, 2) +  Math.pow(ladoB, 2) );

                    String resuArea = String.valueOf(area);
                    String resuPerimetro = String.valueOf(perimetro);
                    String resuDiagonal = String.valueOf(diagonal);

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

        String ladoA = etLadoA.getText().toString();
        String ladoB = etLadoB.getText().toString();

        if (ladoA.isEmpty()) {
            etLadoA.setError("Debe ingresar el lado");
            retorno = false;
        }

        if (ladoB.isEmpty()) {
            etLadoA.setError("Debe ingresar el lado");
            retorno = false;
        }

        return retorno;
    }
}
