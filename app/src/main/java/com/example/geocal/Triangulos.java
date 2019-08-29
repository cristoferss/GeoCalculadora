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

    private Button btnVolver;
    private Button btnCalcular;
    private EditText etArea,etSemiperimetro,etPerimetro;
    private TextView textViewResultado;
    private RadioButton rbEquilatero;
    private RadioButton rbIsosceles;
    private RadioButton rbEscaleno;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangulos);

        //Botones
        btnVolver  = (Button)findViewById(R.id.btnVolver);
        btnCalcular  = (Button)findViewById(R.id.btnCalcular);
        //Variables de numeros para el calculo

        etArea = (EditText)findViewById(R.id.etArea);
        etPerimetro = (EditText)findViewById(R.id.etPerimetro);
        etSemiperimetro = (EditText)findViewById(R.id.etSemiperimetro);

        //Variables radio buttons
        rbEquilatero = (RadioButton) findViewById(R.id.rbEquilatero);
        rbEscaleno = (RadioButton) findViewById(R.id.rbEscaleno);
        rbIsosceles = (RadioButton) findViewById(R.id.rbIsosceles);
        //Variable resultado
        textViewResultado = (TextView)findViewById(R.id.textViewResultado);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(Validar()){
                    if (rbEquilatero.isChecked() == true){

                        Toast.makeText(Triangulos.this,"Datos ingresados correctamente",Toast.LENGTH_SHORT).show();
                        int area = Integer.parseInt(etArea.getText().toString());
                        int semiperimetro = Integer.parseInt(etSemiperimetro.getText().toString());
                        int perimetro = Integer.parseInt(etPerimetro.getText().toString());
                        int suma = (area+semiperimetro+perimetro);
                        String resu = String.valueOf(suma);
                        textViewResultado.setText(resu);

                    }else if (rbEscaleno.isChecked() == true){

                        Toast.makeText(Triangulos.this,"Datos ingresados correctamente",Toast.LENGTH_LONG).show();
                        int area = Integer.parseInt(etArea.getText().toString());
                        int semiperimetro = Integer.parseInt(etSemiperimetro.getText().toString());
                        int perimetro = Integer.parseInt(etPerimetro.getText().toString());
                        int suma = (area+semiperimetro+perimetro);
                        String resu = String.valueOf(suma);
                        textViewResultado.setText(resu);

                    }if (rbIsosceles.isChecked() == true){

                        Toast.makeText(Triangulos.this,"Datos ingresados correctamente",Toast.LENGTH_LONG).show();
                        int area = Integer.parseInt(etArea.getText().toString());
                        int semiperimetro = Integer.parseInt(etSemiperimetro.getText().toString());
                        int perimetro = Integer.parseInt(etPerimetro.getText().toString());
                        int suma = (area+semiperimetro+perimetro);
                        String resu = String.valueOf(suma);
                        textViewResultado.setText(resu);

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
    public boolean Validar(){
        boolean retorno=true;
        String area=etArea.getText().toString();
        String semiperimetro=etSemiperimetro.getText().toString();
        String perimetro=etPerimetro.getText().toString();
        if(area.isEmpty()){

            etArea.setError("Debe ingresar el Área");
            retorno=false;
        }
        if(semiperimetro.isEmpty()){

            etSemiperimetro.setError("Debe ingresar el SemiPerimetro");
            retorno=false;
        }

        if(perimetro.isEmpty()){

            etPerimetro.setError("Debe ingresar el Perimetro");
            retorno=false;
        }
        return retorno;
    }
}
