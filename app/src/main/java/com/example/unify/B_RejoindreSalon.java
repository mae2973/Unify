package com.example.unify;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class B_RejoindreSalon extends AppCompatActivity {

    Button buttonOk;
    Button buttonAnnuler;

    Button buttonParametre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.b_connexion_salon);

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

        buttonParametre = findViewById(R.id.param_rejoindre_salon);
        buttonParametre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setButtonParametre();
            }
        });

    }

    private void setButtonOk(){
        Intent switchActivityIntent = new Intent(this, B_ConnexionSpotifyUser.class);
        startActivity(switchActivityIntent);
        overridePendingTransition(0, 0);
    }
    private void setButtonAnnuler() {
        this.finish();
        overridePendingTransition(0, 0);
    }

    private void setButtonParametre() {
        Intent switchActivityIntent = new Intent(this, B_RejoindreSalon.class);
        // METTRE LA BONNE DESTINATION, ICI L'OVERLAY PARAMETRES QU'ON A PAS ENCORE FAIT
        startActivity(switchActivityIntent);
        overridePendingTransition(0, 0);
    }


}