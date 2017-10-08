package com.example.damir.a12;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Intent i = getIntent();
        Bundle bun = i.getExtras();
        TextView textoPrincipal = (TextView) findViewById(R.id.textoPrincipal);

        if(bun != null) {
            textoPrincipal.setText("¡Hola!, "+bun.getString("nombre")+" por favor, introduce tu edad.");
        }

        Button btnVolver = (Button) findViewById(R.id.volver);
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent infoADevolver = new Intent();
                EditText edad = (EditText) findViewById(R.id.edad);
                infoADevolver.putExtra("edad",Integer.parseInt(edad.getText().toString()));
                setResult(Activity.RESULT_OK,infoADevolver);
                finish();
            }
        });

    }

}
