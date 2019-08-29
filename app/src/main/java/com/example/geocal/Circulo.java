package com.example.geocal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Circulo extends AppCompatActivity {

    private Button btnVolver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circulo);

        btnVolver  = (Button)findViewById(R.id.btnVolver);

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent btnVolver = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(btnVolver);
            }
        });
    }
}
