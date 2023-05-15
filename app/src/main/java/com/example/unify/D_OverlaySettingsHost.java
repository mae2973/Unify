package com.example.unify;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.FirebaseFirestore;

public class D_OverlaySettingsHost extends AppCompatActivity {

    Button buttonQuitterSalon;
    Button buttonCompte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.overlay_settings_host);

        Intent currentIntent = getIntent();
        String codeSalon = currentIntent.getStringExtra("CODE_SALON");

        TextView codeSalonTextView = findViewById(R.id.Code_Salon);
        codeSalonTextView.setText(codeSalon);

        buttonQuitterSalon = findViewById(R.id.Quitter_salon);
        buttonQuitterSalon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setButtonQuitterSalon();
            }
        });

        buttonCompte = findViewById(R.id.Mon_compte);
        buttonCompte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setButtonCompte();
            }
        });
    }

    private void setButtonQuitterSalon() {
        String identifiant = getIntent().getStringExtra("IDENTIFIANT_EXTRA");
        String codeSalon = getIntent().getStringExtra("CODE_SALON");

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        db.collection("rooms").document(codeSalon)
                .delete()
                .addOnSuccessListener(aVoid -> {
                    // le créateur quitte la room => on la supprime entièrement de la bdd
                })
                .addOnFailureListener(e -> {
                    // Gérer les erreurs lors de la suppression de la room
                });

        Intent switchActivityIntent = new Intent(this, B_ChoixTypeSalon.class);
        switchActivityIntent.putExtra("IDENTIFIANT_EXTRA", identifiant);
        startActivity(switchActivityIntent);
        //TODO: la je change d'activité mais je ne kill pas celles d'avant, voir si on peut le faire
        overridePendingTransition(0, 0);
        finish();
    }

    private void setButtonCompte(){
        Intent switchActivityIntent = new Intent(this, AB_MonCompte.class);

        // on récupère l'id depuis l'intent actuel
        Intent intent = getIntent();
        String identifiant = intent.getStringExtra("IDENTIFIANT_EXTRA");

        // on l'ajoute en tant qu'extra à l'intent de l'activité de destination
        switchActivityIntent.putExtra("IDENTIFIANT_EXTRA", identifiant);

        startActivity(switchActivityIntent);
        overridePendingTransition(0, 0);
    }

}
