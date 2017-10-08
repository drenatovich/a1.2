package com.example.damir.a12;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Activity1 extends AppCompatActivity {

    EditText nombreEditText;
    int PEDIR_EDAD = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);


        Button enviar = (Button) findViewById(R.id.enviar);
        nombreEditText = (EditText) findViewById(R.id.nombre);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bun = new Bundle();
                bun.putCharSequence("nombre",nombreEditText.getText().toString());

                Intent i = new Intent(getApplicationContext(),Activity2.class);
                i.putExtras(bun);
                //Se empieza la activity y el entero sirve para identificar el Intent cuando vuelva.
                startActivityForResult(i,PEDIR_EDAD);
//                startActivity(i);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == PEDIR_EDAD || resultCode == RESULT_OK) {
            int edad = data.getIntExtra("edad",0);
            Log.d("EDAD----->"," "+edad);
            TextView textoFinal = (TextView) findViewById(R.id.textoFinal);
            if (edad > 18 && edad < 25) {
                textoFinal.setText("Eres mayor de edad");
            } else if (edad >= 25 && edad < 35) {
                textoFinal.setText("Estas en la flor de la vida");
            } else if (edad >= 35) {
                textoFinal.setText("Ay ,ay ,ay...");
            }

        }
    }
}
