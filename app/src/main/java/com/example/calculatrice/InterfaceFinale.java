package com.example.calculatrice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class InterfaceFinale extends AppCompatActivity {
    private Button boutton1;
    private Button boutton2;
    private Button boutton3;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.interfacefinale);
        boutton1= (Button) findViewById(R.id.button);
        boutton2 = (Button) findViewById(R.id.button2);
        boutton3 = (Button) findViewById(R.id.button3);

        boutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        InterfaceFinale.this,
                        MainActivity.class
                );

            }
        });
    }
}
