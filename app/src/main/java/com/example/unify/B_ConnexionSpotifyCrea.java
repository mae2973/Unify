package com.example.unify;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class B_ConnexionSpotifyCrea extends AppCompatActivity {
    Button buttonValider;
    Button buttonAnnuler;

    Button buttonParametre;

    private FirebaseFirestore db;
    private CollectionReference roomsRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.b_connexion_spotify_crea);

        db = FirebaseFirestore.getInstance();
        roomsRef = db.collection("rooms");

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
        Random random = new Random();
        int initialCodeSalon;

        do {
            initialCodeSalon = random.nextInt(9000) + 1000;
        } while (initialCodeSalonExists(initialCodeSalon));

        final int codeSalon = initialCodeSalon;
        String identifiant = getIntent().getStringExtra("IDENTIFIANT_EXTRA");

        storeCodeSalon(codeSalon, identifiant);

        Intent switchActivityIntent = new Intent(this, C_InterfacePrincipale.class);
        switchActivityIntent.putExtra("CODE_SALON", String.valueOf(codeSalon));
        switchActivityIntent.putExtra("IDENTIFIANT_EXTRA", identifiant);
        startActivity(switchActivityIntent);
        overridePendingTransition(0, 0);
    }

    private boolean initialCodeSalonExists(int codeSalon) {
        final boolean[] exists = {false};

        roomsRef.document(String.valueOf(codeSalon))
                .get()
                .addOnSuccessListener(documentSnapshot -> {
                    if (documentSnapshot.exists()) {
                        exists[0] = true;
                    }
                })
                .addOnFailureListener(e -> {
                    // Gestion des erreurs lors de la requête
                });

        return exists[0];
    }

    private void storeCodeSalon(int codeSalon, String identifiant) {
        DocumentReference roomDocRef = roomsRef.document(String.valueOf(codeSalon));

        Map<String, Object> roomData = new HashMap<>();
        roomData.put("idCrea", identifiant);
        roomData.put("participants", new ArrayList<String>(Collections.singleton(identifiant)));

        roomDocRef.set(roomData)
                .addOnSuccessListener(aVoid -> {
                    // code stocké ok
                })
                .addOnFailureListener(e -> {
                    // Gestion des erreurs lors de la création du salon
                });
    }

    private void setButtonAnnuler() {
        this.finish();
        overridePendingTransition(0, 0);
    }

    private void setButtonParametre() {
        Intent switchActivityIntent = new Intent(this, D_OverlayParamAccueil.class);

        String identifiant = getIntent().getStringExtra("IDENTIFIANT_EXTRA");
        switchActivityIntent.putExtra("IDENTIFIANT_EXTRA", identifiant);

        startActivity(switchActivityIntent);
        overridePendingTransition(0, 0);
    }
}
