package com.example.unify;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;

public class B_RejoindreSalon extends AppCompatActivity {

    Button buttonOk;
    Button buttonAnnuler;

    Button buttonParametre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.b_connexion_salon);

        buttonOk = findViewById(R.id.connexion_salon_ok);
        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setButtonOk();
            }
        });

        buttonAnnuler = findViewById(R.id.connexion_salon_annuler);
        buttonAnnuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setButtonAnnuler();
            }
        });

        buttonParametre = findViewById(R.id.param_rejoindre_salon);
        buttonParametre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setButtonParametre();
            }
        });

    }

    private void setButtonOk() {
        TextView textViewCode = findViewById(R.id.code_salon_user);
        String codeSalon = textViewCode.getText().toString();
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        CollectionReference roomsRef = db.collection("rooms");

        roomsRef.document(codeSalon)
                .get()
                .addOnSuccessListener(documentSnapshot -> {
                    if (documentSnapshot.exists()) {
                        // Salon existe, ajouter l'identifiant de l'utilisateur à la liste des participants
                        String identifiant = getIntent().getStringExtra("IDENTIFIANT_EXTRA");
                        roomsRef.document(codeSalon)
                                .update("participants", FieldValue.arrayUnion(identifiant))
                                .addOnSuccessListener(aVoid -> {
                                    // id ajouté, on transmet le code du salon et l'identifiant à l'act suivante
                                    Intent switchActivityIntent = new Intent(B_RejoindreSalon.this, InterfacePrincipaleGuest.class);
                                    switchActivityIntent.putExtra("CODE_SALON", codeSalon);
                                    switchActivityIntent.putExtra("IDENTIFIANT_EXTRA", identifiant);
                                    startActivity(switchActivityIntent);
                                    overridePendingTransition(0, 0);
                                })
                                .addOnFailureListener(e -> {
                                    // Gérer les erreurs lors de l'ajout de l'identifiant à la liste des participants
                                });
                    } else {
                        // le salon n'existe pas => message d'erreur
                        Toast.makeText(B_RejoindreSalon.this, "Le salon n'existe pas", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(e -> {
                    // Gérer les erreurs lors de la requête
                });
    }



    private void setButtonAnnuler() {
        this.finish();
        overridePendingTransition(0, 0);
    }

    private void setButtonParametre() {
        Intent switchActivityIntent = new Intent(this, overlay_param_accueil.class);

        String identifiant = getIntent().getStringExtra("IDENTIFIANT_EXTRA");
        switchActivityIntent.putExtra("IDENTIFIANT_EXTRA", identifiant);

        startActivity(switchActivityIntent);
        overridePendingTransition(0, 0);
    }


}