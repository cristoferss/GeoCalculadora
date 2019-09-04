package com.example.geocal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Resultados extends AppCompatActivity {

    private Button btnVolver;
    private TextView textViewFigura;
    private TextView textViewArea;
    private TextView textViewPerimetro;
    private TextView textViewDiagonal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);

        //Botones
        btnVolver  = (Button)findViewById(R.id.btnVolver);

        //Variable resultado
        textViewFigura = (TextView)findViewById(R.id.textViewFigura);
        textViewArea = (TextView)findViewById(R.id.textViewArea);
        textViewPerimetro = (TextView) findViewById(R.id.textViewPerimetro);
        textViewDiagonal = (TextView) findViewById(R.id.textViewDiagonal);

        //Variable recibidas desde activity triangulos
        //Enviadas desde el metodo intent
        String figura = getIntent().getStringExtra("figura");
        String area = getIntent().getStringExtra("area");
        String perimetro = getIntent().getStringExtra("perimetro");
        String diagonal = getIntent().getStringExtra("diagonal");
        //String dato2 = getIntent().getStringExtra("perimetro");
        //String dato3 = getIntent().getStringExtra("semiperimetro");

        switch (figura) {
            case "Cuadrado":
                textViewFigura.setText("Figura: " + figura);
                textViewArea.setText("Área: " + area);
                textViewPerimetro.setText("Perímetro: " + perimetro);
                textViewDiagonal.setText("Diagonal: " + diagonal);
                textViewArea.setVisibility(View.VISIBLE);
                textViewPerimetro.setVisibility(View.VISIBLE);
                textViewDiagonal.setVisibility(View.VISIBLE);
                break;
        }

        //textViewResultado.setText(datos);

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent btnVolver = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(btnVolver);
            }
        });
    }
}
