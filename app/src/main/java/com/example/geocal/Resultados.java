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
    private TextView textViewSemiperimetro;
    private TextView textViewDiametro;

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
        textViewDiametro = (TextView) findViewById(R.id.textViewDiametro);
        textViewSemiperimetro = (TextView) findViewById(R.id.textViewSemiperimetro);

        //Variable recibidas desde activity triangulos
        //Enviadas desde el metodo intent
        String figura = getIntent().getStringExtra("figura");
        String area = getIntent().getStringExtra("area");
        String perimetro = getIntent().getStringExtra("perimetro");
        String diagonal = getIntent().getStringExtra("diagonal");
        String diametro = getIntent().getStringExtra("diametro");
        String semiperimetro = getIntent().getStringExtra("semiperimetro");

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
            case "Ractángulo":
                textViewFigura.setText("Figura: " + figura);
                textViewArea.setText("Área: " + area);
                textViewPerimetro.setText("Perímetro: " + perimetro);
                textViewDiagonal.setText("Diagonal: " + diagonal);
                textViewArea.setVisibility(View.VISIBLE);
                textViewPerimetro.setVisibility(View.VISIBLE);
                textViewDiagonal.setVisibility(View.VISIBLE);
                break;
            case "Círculo":
                textViewFigura.setText("Figura: " + figura);
                textViewArea.setText("Área: " + area);
                textViewPerimetro.setText("Perímetro: " + perimetro);
                textViewDiametro.setText("Diametro: " + diametro);
                textViewArea.setVisibility(View.VISIBLE);
                textViewPerimetro.setVisibility(View.VISIBLE);
                textViewDiametro.setVisibility(View.VISIBLE);
                break;
            case "Triángulo equilatero":
                textViewFigura.setText("Figura: " + figura);
                textViewArea.setText("Área: " + area);
                textViewPerimetro.setText("Perímetro: " + perimetro);
                textViewSemiperimetro.setText("Semiperimetro: " + semiperimetro);
                textViewArea.setVisibility(View.VISIBLE);
                textViewPerimetro.setVisibility(View.VISIBLE);
                textViewSemiperimetro.setVisibility(View.VISIBLE);
                break;
            case "Triángulo isósceles":
                textViewFigura.setText("Figura: " + figura);
                textViewArea.setText("Área: " + area);
                textViewPerimetro.setText("Perímetro: " + perimetro);
                textViewSemiperimetro.setText("Semiperimetro: " + semiperimetro);
                textViewArea.setVisibility(View.VISIBLE);
                textViewPerimetro.setVisibility(View.VISIBLE);
                textViewSemiperimetro.setVisibility(View.VISIBLE);
                break;
            case "Triángulo escaleno":
                textViewFigura.setText("Figura: " + figura);
                textViewArea.setText("Área: " + area);
                textViewPerimetro.setText("Perímetro: " + perimetro);
                textViewSemiperimetro.setText("Semiperimetro: " + semiperimetro);
                textViewArea.setVisibility(View.VISIBLE);
                textViewPerimetro.setVisibility(View.VISIBLE);
                textViewSemiperimetro.setVisibility(View.VISIBLE);
                break;
            case "Rombo":
                textViewFigura.setText("Figura: " + figura);
                textViewArea.setText("Área: " + area);
                textViewPerimetro.setText("Perímetro: " + perimetro);
                textViewArea.setVisibility(View.VISIBLE);
                textViewPerimetro.setVisibility(View.VISIBLE);
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
