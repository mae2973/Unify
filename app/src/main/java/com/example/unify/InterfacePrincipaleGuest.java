package com.example.unify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class InterfacePrincipaleGuest extends AppCompatActivity {

    ImageButton parametreg1 ;
    ImageButton flecheg_g ;

    ImageButton fleched_g;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interface_principale_invite);

        // Boutons
        parametreg1 = findViewById(R.id.parametreguest1) ;
        parametreg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InterfacePrincipaleGuest.this, overlay_settings_guest.class);

                Intent currentIntent = getIntent();
                String codeSalon = currentIntent.getStringExtra("CODE_SALON");

                intent.putExtra("CODE_SALON", codeSalon);

                startActivity(intent);
            }
        });


        flecheg_g = findViewById(R.id.versParticipant_Guest) ;
        flecheg_g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setVersParticipant_Guest();
            }
        });


        fleched_g = findViewById(R.id.versSuggestion_Guest) ;
        fleched_g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setVersSuggestion_Guest();
            }
        });


    }


    // Boutons



    private void setVersParticipant_Guest() {
        Intent switchActivityIntent = new Intent(this, ParticipantGuest.class);
        startActivity(switchActivityIntent);
        overridePendingTransition(0, 0);
    }


    private void setVersSuggestion_Guest() {
        Intent switchActivityIntent = new Intent(this, MenuSuggestionsPart.class);
        startActivity(switchActivityIntent);
        overridePendingTransition(0, 0);
    }

    }
