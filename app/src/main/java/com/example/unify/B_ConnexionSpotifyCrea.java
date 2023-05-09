package com.example.unify;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class B_ConnexionSpotifyCrea extends AppCompatActivity {
    Button buttonValider;
    Button buttonAnnuler;

    Button buttonParametre;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ba_connexion_spotify_crea);

        buttonValider = findViewById(R.id.bouton_valid_spotify_crea);
        buttonValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setButtonValider();
            }
        });

        buttonAnnuler = findViewById(R.id.bouton_annul_spotify_crea);
        buttonAnnuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setButtonAnnuler();
            }
        });

        buttonParametre = findViewById(R.id.param_connexion_spotify_crea);
        buttonParametre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setButtonParametre();
            }
        });
    }

    private void setButtonValider() {
        Intent switchActivityIntent = new Intent(this, InterfacePrincipale.class);
        // destination à modif une fois qu'on aura les bons trucs avec les fragments
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