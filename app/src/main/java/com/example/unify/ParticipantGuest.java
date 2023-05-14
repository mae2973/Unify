package com.example.unify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ParticipantGuest extends AppCompatActivity {

    ImageButton fleched_g;
    ImageButton parametreg2 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_participant_guest);


        // Boutons
        fleched_g = findViewById(R.id.versMusique);
        parametreg2 = findViewById(R.id.parametrehost1) ;

        fleched_g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFleched();
            }
        });

        parametreg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setParam();
            }
        });
    }


    // Boutons
    private void setFleched() {
        Intent switchActivityIntent = new Intent(this, InterfacePrincipaleGuest.class);
        startActivity(switchActivityIntent);
        overridePendingTransition(0, 0);
    }

    private void setParam() {
        Intent switchActivityIntent = new Intent(this, overlay_settings_guest.class);
        startActivity(switchActivityIntent);
        overridePendingTransition(0, 0);
    }
}