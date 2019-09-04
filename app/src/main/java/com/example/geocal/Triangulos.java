package com.example.geocal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Triangulos extends AppCompatActivity {

    private Button btnEnviar;
    private Button btnVolver;
    private Button btnCalcular;
    private EditText etLadoA, etLadoB, etLadoC;
    private TextView textViewResultado;
    private RadioButton rbEquilatero;
    private RadioButton rbIsosceles;
    private RadioButton rbEscaleno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangulos);

        final String figura = "Circulo";

        btnEnviar  = (Button)findViewById(R.id.btnEnviar);
        //Botones
        btnVolver  = (Button)findViewById(R.id.btnVolver);
        //btnCalcular  = (Button)findViewById(R.id.btnCalcular);
        //Variables de numeros para el calculo

        etLadoA = (EditText)findViewById(R.id.etLadoA);
        etLadoB = (EditText)findViewById(R.id.etLadoB);
        etLadoC = (EditText)findViewById(R.id.etLadoC);

        //Variables radio buttons
        rbEquilatero = (RadioButton) findViewById(R.id.rbEquilatero);
        rbEscaleno = (RadioButton) findViewById(R.id.rbEscaleno);
        rbIsosceles = (RadioButton) findViewById(R.id.rbIsosceles);
        //Variable resultado
        //textViewResultado = (TextView)findViewById(R.id.textViewResultado);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(validar()){

                    Toast.makeText(Triangulos.this,"Datos ingresados correctamente",Toast.LENGTH_SHORT).show();

                    if (rbEquilatero.isChecked() == true){

                        int lado = Integer.parseInt(etLadoA.getText().toString());

                        double area = ( Math.sqrt(3) / 4 ) * Math.pow(lado, 2);
                        int perimetro = 3 * lado;
                        int semiperimetro = perimetro / 2;

                        String resuArea = String.valueOf(area);
                        String resuPerimetro = String.valueOf(perimetro);
                        String resuSemiperimetro = String.valueOf(semiperimetro);

                        Intent enviar = new Intent(getApplicationContext(), Resultados.class);
                        enviar.putExtra("figura", figura);
                        enviar.putExtra("area",resuArea);
                        enviar.putExtra("perimetro", resuPerimetro);
                        enviar.putExtra("semiperimetro", resuSemiperimetro);

                        //Envio de paratametros a activity resultados
                        startActivity(enviar);

                    }else if (rbEscaleno.isChecked() == true){

                        int ladoA = Integer.parseInt(etLadoA.getText().toString());
                        int ladoB = Integer.parseInt(etLadoB.getText().toString());

                        double area = ( Math.sqrt(3) / 4 ) * Math.pow(lado, 2);
                        int perimetro = 3 * lado;
                        int semiperimetro = perimetro / 2;

                        String resuArea = String.valueOf(area);
                        String resuPerimetro = String.valueOf(perimetro);
                        String resuSemiperimetro = String.valueOf(semiperimetro);

                        Intent enviar = new Intent(getApplicationContext(), Resultados.class);
                        enviar.putExtra("figura", figura);
                        enviar.putExtra("area",resuArea);
                        enviar.putExtra("perimetro", resuPerimetro);
                        enviar.putExtra("semiperimetro", resuSemiperimetro);

                        //Envio de paratametros a activity resultados
                        startActivity(enviar);

                    }if (rbIsosceles.isChecked() == true){


                    }else{
                        Toast.makeText(Triangulos.this,"Debe seleccionar un tipo de rectángulo",Toast.LENGTH_SHORT).show();
                    }
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
        String ladoC = etLadoC.getText().toString();

        if (ladoA.isEmpty()) {
            etLadoA.setError("Debe ingresar el lado");
            retorno = false;
        }

        if (ladoB.isEmpty()) {
            etLadoB.setError("Debe ingresar el lado");
            retorno = false;
        }

        if (ladoC.isEmpty()) {
            etLadoC.setError("Debe ingresar el lado");
            retorno = false;
        }

        return retorno;
    }
}
