package com.example.unify;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class creation_compte extends AppCompatActivity {

    Button buttonValider;

    Button buttonAnnuler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creation_compte);


        buttonValider = findViewById(R.id.valid);
        buttonValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setButtonValider();
            }
        });

        buttonAnnuler = findViewById(R.id.annuler);
        buttonAnnuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setButtonAnnuler();
            }
        });
    }

    private void setButtonValider() {
        Intent switchActivityIntent = new Intent(this, B_PageConnexion.class);
        startActivity(switchActivityIntent);
        overridePendingTransition(0, 0);
    }

    private void setButtonAnnuler() {
        Intent switchActivityIntent = new Intent(this, B_PageConnexion.class);
        startActivity(switchActivityIntent);
        overridePendingTransition(0, 0);
    }
}