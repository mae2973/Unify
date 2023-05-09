package com.example.unify;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class B_ChoixTypeSalon extends AppCompatActivity {

    ImageButton buttonCreer;
    ImageButton buttonRejoindre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_type_salon);


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

    }

    private void setButtonCreer() {
        Intent switchActivityIntent = new Intent(this, B_ConnexionSpotifyUser.class);
        startActivity(switchActivityIntent);
        overridePendingTransition(0, 0);
    }

    private void setButtonRejoindre() {
        Intent switchActivityIntent = new Intent(this, B_RejoindreSalon.class);
        startActivity(switchActivityIntent);
        overridePendingTransition(0, 0);
    }

}