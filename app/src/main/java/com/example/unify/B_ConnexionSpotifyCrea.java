package com.example.unify;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class B_ConnexionSpotifyCrea extends AppCompatActivity {
    Button buttonValider;
    Button buttonAnnuler;

    Button buttonParametre;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ba_connexion_spotify_crea);

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
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        CollectionReference roomsRef = db.collection("rooms");

        Random random = new Random();
        int initialCodeSalon;

        do {
            initialCodeSalon = random.nextInt(9000) + 1000;
        } while (initialCodeSalonExists(initialCodeSalon, roomsRef));

        final int codeSalon = initialCodeSalon;

        Intent switchActivityIntent = new Intent(this, InterfacePrincipale.class);
        switchActivityIntent.putExtra("CODE_SALON", String.valueOf(codeSalon));
        startActivity(switchActivityIntent);
        overridePendingTransition(0, 0);
    }

    private boolean initialCodeSalonExists(int codeSalon, CollectionReference roomsRef) {
        final boolean[] exists = {false};

        roomsRef.whereEqualTo("codeSalon", String.valueOf(codeSalon))
                .get()
                .addOnSuccessListener(queryDocumentSnapshots -> {
                    if (!queryDocumentSnapshots.isEmpty()) {
                        exists[0] = true;
                    }
                })
                .addOnFailureListener(e -> {
                    // Gestion des erreurs lors de la requête
                });

        return exists[0];
    }


    private void setButtonAnnuler() {
        this.finish();
        overridePendingTransition(0, 0);
    }

    private void setButtonParametre() {
        Intent switchActivityIntent = new Intent(this, B_RejoindreSalon.class);
        // METTRE LA BONNE DESTINATION, ICI L'OVERLAY PARAMETRES QU'ON A PAS ENCORE FAIT
        startActivity(switchActivityIntent);
        overridePendingTransition(0, 0);
    }
}