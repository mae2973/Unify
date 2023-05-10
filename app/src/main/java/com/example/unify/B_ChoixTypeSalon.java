package com.example.unify;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class B_ChoixTypeSalon extends AppCompatActivity {

    ImageButton buttonCreer;
    ImageButton buttonRejoindre;
    Button buttonParametre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.b_choix_type_salon);


        buttonCreer = findViewById(R.id.creer);
        buttonCreer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setButtonCreer();
            }
        });

        buttonRejoindre = findViewById(R.id.rejoindre_salon);
        buttonRejoindre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setButtonRejoindre();
            }
        });

        buttonParametre = findViewById(R.id.param_choix_salon);
        buttonParametre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setButtonParametre();
            }
        });

    }

    private void setButtonCreer() {
        Intent switchActivityIntent = new Intent(this, B_ConnexionSpotifyCrea.class);
        startActivity(switchActivityIntent);
        overridePendingTransition(0, 0);
    }

    private void setButtonRejoindre() {
        Intent switchActivityIntent = new Intent(this, B_RejoindreSalon.class);
        startActivity(switchActivityIntent);
        overridePendingTransition(0, 0);
    }

    private void setButtonParametre() {
        Intent switchActivityIntent = new Intent(this, B_RejoindreSalon.class);
        // METTRE LA BONNE DESTINATION, ICI L'OVERLAY PARAMETRES QU'ON A PAS ENCORE FAIT
        startActivity(switchActivityIntent);
        overridePendingTransition(0, 0);
    }

}