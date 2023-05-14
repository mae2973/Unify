package com.example.unify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class SuggestionHost extends AppCompatActivity {

// Boutons
    ImageButton flecheg3 ;
    ImageButton par2 ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestion_host);



        // BOUTONS
        flecheg3 = findViewById(R.id.versMusique2) ;
        flecheg3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setVersMusique3();
            }
        });

        par2 = findViewById(R.id.parametreguest3) ;
        par2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setPar2();
            }
        });

    }



    // BOUTONS
    private void setVersMusique3() {
        Intent switchActivityIntent = new Intent(this, InterfacePrincipale.class);
        startActivity(switchActivityIntent);
        overridePendingTransition(0, 0);
    }
    private void setPar2() {
        Intent switchActivityIntent = new Intent(this, overlay_settings_host.class);
        startActivity(switchActivityIntent);
        overridePendingTransition(0, 0);
    }
    }
