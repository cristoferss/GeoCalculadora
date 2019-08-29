package com.example.geocal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Rombo extends AppCompatActivity {

    private Button btnVolver;
    private Button btnCalcular;
    private EditText etArea,etPerimetro,etDiagonal;
    private TextView textViewResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rombo);

        //Botones
        btnVolver  = (Button)findViewById(R.id.btnVolver);
        btnVolver  = (Button)findViewById(R.id.btnVolver);
        btnCalcular  = (Button)findViewById(R.id.btnCalcular);
        //Variables de numeros para el calculo

        etArea = (EditText)findViewById(R.id.etArea);
        etDiagonal = (EditText)findViewById(R.id.etDiagonal);
        etPerimetro = (EditText)findViewById(R.id.etPerimetro);

        //Variable resultado
        textViewResultado = (TextView)findViewById(R.id.textViewResultado);


        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int area = Integer.parseInt(etArea.getText().toString());
                int diagonal = Integer.parseInt(etDiagonal.getText().toString());
                int perimetro = Integer.parseInt(etPerimetro.getText().toString());
                int suma = (area+diagonal+perimetro);
                String resu = String.valueOf(suma);
                textViewResultado.setText(resu);


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
}
