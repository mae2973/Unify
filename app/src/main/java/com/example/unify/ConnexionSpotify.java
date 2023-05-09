package com.example.unify;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ConnexionSpotify extends AppCompatActivity {
    Button buttonValider;
    Button buttonAnnuler;

    Button buttonPasser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion_spotify_user);

        buttonValider = findViewById(R.id.boutton_valid_spotify_opt);
        buttonValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setButtonValider();
            }
        });

        buttonAnnuler = findViewById(R.id.boutton_annul_spotify_opt);
        buttonAnnuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setButtonAnnuler();
            }
        });

        buttonPasser = findViewById(R.id.boutton_passer_spotify_opt);
        buttonPasser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setButtonPasser();
            }
        });
    }

    private void setButtonValider() {
        Intent switchActivityIntent = new Intent(this, InterfacePrincipale.class);
        // destination à modif une fois qu'on aura les bons trucs avec les fragments, ici interface principale pour invité
        startActivity(switchActivityIntent);
    }

    private void setButtonAnnuler() {
        this.finish();
    }

    private void setButtonPasser(){
        Intent switchActivityIntent = new Intent(this, InterfacePrincipale.class);
        // destination à modif une fois qu'on aura les bons trucs avec les fragments, ici interface principale pour invité
        startActivity(switchActivityIntent);
    }
}