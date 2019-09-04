package com.example.geocal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Circulo extends AppCompatActivity {

    private Button btnVolver;
    private Button btnCalcular;
    private EditText etLadoA;
    private TextView textViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circulo);

        final String figura = "Círculo";

        //Botones
        btnVolver  = (Button)findViewById(R.id.btnVolver);
        btnVolver  = (Button)findViewById(R.id.btnVolver);
        btnCalcular  = (Button)findViewById(R.id.btnCalcular);
        //Variables de numeros para el calculo

        etLadoA = (EditText)findViewById(R.id.etLadoA);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(validar()){

                    Toast.makeText(Circulo.this,"Datos ingresados correctamente",Toast.LENGTH_LONG).show();

                    int radio = Integer.parseInt(etLadoA.getText().toString());

                    double area = Math.PI * Math.pow(radio, 2);
                    double perimetro = 2 * Math.PI * radio;
                    double diametro = 2 * radio;

                    String resuArea = String.valueOf(area);
                    String resuPerimetro = String.valueOf(perimetro);
                    String resuDiametro = String.valueOf(diametro);

                    Intent enviar = new Intent(getApplicationContext(), Resultados.class);
                    enviar.putExtra("figura", figura);
                    enviar.putExtra("area",resuArea);
                    enviar.putExtra("perimetro", resuPerimetro);
                    enviar.putExtra("diametro", resuDiametro);

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

        if (ladoA.isEmpty()) {
            etLadoA.setError("Debe ingresar el radio");
            retorno = false;
        }

        return retorno;
    }
}
