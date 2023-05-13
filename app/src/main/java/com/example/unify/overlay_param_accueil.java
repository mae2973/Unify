package com.example.unify;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class overlay_param_accueil extends AppCompatActivity {

    Button buttonDeco;
    Button buttonCompte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.param_accueil);

        buttonDeco = findViewById(R.id.deco);
        buttonDeco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setButtonDeco();
            }
        });

        buttonCompte = findViewById(R.id.mon_compte);
        buttonCompte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setButtonCompte();
            }
        });
    }

    private void setButtonDeco() {
        Intent switchActivityIntent = new Intent(this, B_PageConnexion.class);
        startActivity(switchActivityIntent);
        // TODO : gérer la déconnexion
        overridePendingTransition(0, 0);
    }

    private void setButtonCompte() {
        Intent switchActivityIntent = new Intent(this, mon_compte.class);

        // Récupérez l'identifiant depuis l'intent actuel
        Intent intent = getIntent();
        String identifiant = intent.getStringExtra("IDENTIFIANT_EXTRA");

        // Ajoutez l'identifiant en tant qu'extra à l'intention de l'activité de destination
        switchActivityIntent.putExtra("IDENTIFIANT_EXTRA", identifiant);

        startActivity(switchActivityIntent);
        overridePendingTransition(0, 0);
    }
}
