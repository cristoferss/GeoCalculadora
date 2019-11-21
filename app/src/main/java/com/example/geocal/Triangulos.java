package com.example.geocal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
    private Toast toastTipoTriangulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangulos);

        btnEnviar  = (Button)findViewById(R.id.btnEnviar);
        //Botones
        btnVolver  = (Button)findViewById(R.id.btnVolver);
        btnCalcular  = (Button)findViewById(R.id.btnCalcular);
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

        toastTipoTriangulo = Toast.makeText(Triangulos.this,"Debe seleccionar un tipo de rectángulo",Toast.LENGTH_LONG);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (tipoTriangulo()) {

                    if (validar()) {

                        String resuArea = "";
                        String resuPerimetro = "";
                        String resuSemiperimetro = "";

                        if (rbEquilatero.isChecked()) {

                            String figura = "Triángulo equilatero";

                            int lado = Integer.parseInt(etLadoA.getText().toString());

                            double area = (Math.sqrt(3) / 4) * Math.pow(lado, 2);
                            int perimetro = 3 * lado;
                            double semiperimetro = perimetro / 2;

                            resuArea = String.valueOf(area);
                            resuPerimetro = String.valueOf(perimetro);
                            resuSemiperimetro = String.valueOf(semiperimetro);

                            Intent enviar = new Intent(getApplicationContext(), Resultados.class);
                            enviar.putExtra("figura", figura);
                            enviar.putExtra("area", resuArea);
                            enviar.putExtra("perimetro", resuPerimetro);
                            enviar.putExtra("semiperimetro", resuSemiperimetro);

                            //Envio de paratametros a activity resultados
                            Toast.makeText(Triangulos.this, "Datos ingresados correctamente", Toast.LENGTH_LONG).show();
                            startActivity(enviar);

                        } else if (rbIsosceles.isChecked()) {

                            String figura = "Triángulo isósceles";

                            int ladoA = Integer.parseInt(etLadoA.getText().toString());
                            int ladoB = Integer.parseInt(etLadoB.getText().toString());

                            double area = (ladoB * (Math.sqrt(Math.pow(ladoA, 2) - (Math.pow(ladoB, 2) / 4)))) / 2;
                            int perimetro = (2 * ladoA) + ladoB;
                            double semiperimetro = perimetro / 2;

                            resuArea = String.valueOf(area);
                            resuPerimetro = String.valueOf(perimetro);
                            resuSemiperimetro = String.valueOf(semiperimetro);

                            Intent enviar = new Intent(getApplicationContext(), Resultados.class);
                            enviar.putExtra("figura", figura);
                            enviar.putExtra("area", resuArea);
                            enviar.putExtra("perimetro", resuPerimetro);
                            enviar.putExtra("semiperimetro", resuSemiperimetro);

                            //Envio de paratametros a activity resultados
                            Toast.makeText(Triangulos.this, "Datos ingresados correctamente", Toast.LENGTH_LONG).show();
                            startActivity(enviar);

                        }
                        if (rbEscaleno.isChecked() == true) {

                            String figura = "Triángulo escaleno";

                            int ladoA = Integer.parseInt(etLadoA.getText().toString());
                            int ladoB = Integer.parseInt(etLadoB.getText().toString());
                            int ladoC = Integer.parseInt(etLadoC.getText().toString());

                            int perimetro = ladoA + ladoB + ladoC;
                            double semiperimetro = perimetro / 2;
                            double area = Math.sqrt(semiperimetro * (semiperimetro - ladoA) * (semiperimetro - ladoB) * (semiperimetro - ladoC));
                            //double area = semiperimetro * (semiperimetro - ladoA) * (semiperimetro - ladoB) * (semiperimetro - ladoC);
                            // 4,5 x (4,5-2) * (4,5-4) * (4,5*3)
                            // 4,5 x (2,5) * (0,5) * (1,5)
                            // 8,4375
                            Log.d("valor area", String.valueOf(area));

                            resuArea = String.valueOf(area);
                            resuPerimetro = String.valueOf(perimetro);
                            resuSemiperimetro = String.valueOf(semiperimetro);

                            Intent enviar = new Intent(getApplicationContext(), Resultados.class);
                            enviar.putExtra("figura", figura);
                            enviar.putExtra("area", resuArea);
                            enviar.putExtra("perimetro", resuPerimetro);
                            enviar.putExtra("semiperimetro", resuSemiperimetro);

                            //Envio de paratametros a activity resultados
                            Toast.makeText(Triangulos.this, "Datos ingresados correctamente", Toast.LENGTH_LONG).show();
                            //Toast.makeText(Triangulos.this, resuArea, Toast.LENGTH_LONG).show();
                            startActivity(enviar);

                        }
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

    public boolean tipoTriangulo() {

        if (rbEquilatero.isChecked()) {
            return true;
        } else if (rbIsosceles.isChecked()) {
            return true;
        } else if (rbEscaleno.isChecked()) {
            return true;
        } else {
            toastTipoTriangulo.show();
            return false;
        }
    }

    public boolean validar(){

        boolean retorno = true;

        etLadoA.setError(null);
        etLadoB.setError(null);
        etLadoC.setError(null);
        etLadoA.clearFocus();
        etLadoB.clearFocus();
        etLadoC.clearFocus();

        String ladoA = etLadoA.getText().toString();
        String ladoB = etLadoB.getText().toString();
        String ladoC = etLadoC.getText().toString();

        if (ladoA.isEmpty()) {
            etLadoA.setError("Debe ingresar el lado");
            retorno = false;
        }

        if (rbIsosceles.isChecked() || rbEscaleno.isChecked()) {
            if (ladoB.isEmpty()) {
                etLadoB.setError("Debe ingresar el lado");
                retorno = false;
            }
        }

        if (rbEscaleno.isChecked()) {
            if (ladoC.isEmpty()) {
                etLadoC.setError("Debe ingresar el lado");
                retorno = false;
            }
        }

        return retorno;
    }

}
