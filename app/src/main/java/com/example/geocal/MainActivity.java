package com.example.geocal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    private Button btnSeleccionar;
    private RadioButton rbCuadrado;
    private RadioButton rbCirculo;
    private RadioButton rbTriangulos;
    private RadioButton rbRombo;
    private RadioButton rbRectangulo;
    private RadioButton rbSomos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        rbSomos = (RadioButton) findViewById(R.id.rbSomos);
        rbCuadrado = (RadioButton) findViewById(R.id.rbCuadrado);
        rbCirculo = (RadioButton) findViewById(R.id.rbCirculo);
        rbRectangulo = (RadioButton) findViewById(R.id.rbRectangulo);
        rbRombo = (RadioButton) findViewById(R.id.rbRombo);
        rbTriangulos = (RadioButton) findViewById(R.id.rbTriangulos);
        btnSeleccionar  = (Button)findViewById(R.id.btnSeleccion);


        btnSeleccionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(rbCuadrado.isChecked() == true){
                   // Toast.makeText(getApplicationContext(),"CUadrado",Toast.LENGTH_LONG).show();
                    Intent btnSiguiente = new Intent(getApplicationContext(), Cuadrado.class);
                    startActivity(btnSiguiente);

                }else if(rbRectangulo.isChecked() == true){

                    Intent btnSiguiente = new Intent(getApplicationContext(), Rectangulo.class);
                    startActivity(btnSiguiente);

                }else if(rbTriangulos.isChecked() == true){

                    Intent btnSiguiente = new Intent(getApplicationContext(), Triangulos.class);
                    startActivity(btnSiguiente);

                }else if(rbRombo.isChecked() == true){

                    Intent btnSiguiente = new Intent(getApplicationContext(), Rombo.class);
                    startActivity(btnSiguiente);

                }else if(rbCirculo.isChecked() == true){

                    Intent btnSiguiente = new Intent(getApplicationContext(), Circulo.class);
                    startActivity(btnSiguiente);

                }else if(rbSomos.isChecked() == true){

                    Intent btnSiguiente = new Intent(getApplicationContext(), QuienesSomos.class);
                    startActivity(btnSiguiente);

                }



            }
        });//FIn boton seleccionar



    }
}
