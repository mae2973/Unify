package com.example.unify;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class RejoindreSalon extends AppCompatActivity {

    Button buttonOk;
    Button buttonAnnuler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.connexion_salon);

        buttonOk = findViewById(R.id.connexion_salon_ok);
        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setButtonOk();
            }
        });

        buttonAnnuler = findViewById(R.id.connexion_salon_annuler);
        buttonAnnuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setButtonAnnuler();
            }
        });

    }

    private void setButtonOk(){
        Intent switchActivityIntent = new Intent(this, ConnexionSpotify.class);
        startActivity(switchActivityIntent);
    }
    private void setButtonAnnuler() {
        this.finish();
    }


}