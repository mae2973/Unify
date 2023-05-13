package com.example.unify;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class overlay_param_accueil extends AppCompatActivity {

    Button buttonDeco;
    Button buttonCompte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.param_accueil);

        // Dans la méthode onCreate() ou onResume() de votre activité overlay_param_accueil
        Intent intent = getIntent();

// Vérifiez si l'intention contient l'extra avec la clé spécifiée
        if (intent.hasExtra("INTENT_EXTRA")) {
            // Récupérez l'Intent supplémentaire en tant qu'extra
            Intent autreIntent = intent.getParcelableExtra("INTENT_EXTRA");

            // Vérifiez si l'Intent supplémentaire contient l'extra avec la clé spécifiée
            if (autreIntent.hasExtra("IDENTIFIANT_EXTRA")) {
                // Récupérez l'identifiant de l'Intent supplémentaire
                String identifiant = autreIntent.getStringExtra("IDENTIFIANT_EXTRA");

            }
        }

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
