package com.example.geocal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ResultadosTriangulos extends AppCompatActivity {

    private Button btnVolver;
    private TextView textViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados_triangulos);


        //Botones
        btnVolver  = (Button)findViewById(R.id.btnVolver);


        //Variable resultado
        textViewResultado = (TextView)findViewById(R.id.textViewResultado);

        //Variable recibidas desde activity triangulos
        //Enviadas desde el metodo intent
        String dato1 = getIntent().getStringExtra("area");
        String dato2 = getIntent().getStringExtra("perimetro");
        String dato3 = getIntent().getStringExtra("semiperimetro");

        textViewResultado.setText(dato1+" "+dato2+" "+" "+dato3);



        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent btnVolver = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(btnVolver);
            }
        });
    }
}
