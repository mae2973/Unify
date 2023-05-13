package com.example.unify;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.WriteBatch;

public class B_PageConnexion extends AppCompatActivity {
    Button buttonCompte;
    Button buttonMdp;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.d_page_connexion);

        db = FirebaseFirestore.getInstance();


        buttonCompte = findViewById(R.id.button_création_compte);
        buttonCompte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setButtonCompte();
            }
        });

        buttonMdp = findViewById(R.id.button_mdp_oublié);
        buttonMdp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setButtonMdp();
            }
        });

        // BOUTON POUR VALIDER ( s'active seulement si tous les champs sont remplis )
        EditText idt = findViewById(R.id.identifiant_connexion);
        EditText mdp = findViewById(R.id.mdp_saisi_user);
        Button Valider = findViewById(R.id.button_validation);

        Valider.setEnabled(false);

        TextWatcher formulaireValidationWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String nom = idt.getText().toString().trim();
                String prenom = mdp.getText().toString().trim();
                Valider.setEnabled(!nom.isEmpty() && !prenom.isEmpty());
            }

            @Override
            public void afterTextChanged(Editable s) {}
        };

        Valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v3) {
                EditText id_saisi = findViewById(R.id.identifiant_connexion);
                String id_text = id_saisi.getText().toString();

                EditText mdp_saisi = findViewById(R.id.mdp_saisi_user);
                String mdp_text = mdp_saisi.getText().toString();

                // Vérifier si le mot de passe correspond à l'identifiant
                if (verifierMotDePasse(id_text, mdp_text)) {
                    // Mot de passe correct, autoriser le passage à la page suivante
                    Intent intent = new Intent(B_PageConnexion.this, B_ChoixTypeSalon.class);
                    startActivity(intent);
                } else {
                    // Mot de passe incorrect, afficher un message d'erreur
                    Toast.makeText(B_PageConnexion.this, "Identifiant ou mot de passe incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        });

        idt.addTextChangedListener(formulaireValidationWatcher);
        mdp.addTextChangedListener(formulaireValidationWatcher);
    }

    private void setButtonCompte() {
        Intent switchActivityIntent = new Intent(this, D_CreationCompte.class);
        startActivity(switchActivityIntent);
        overridePendingTransition(0, 0);
    }

    private void setButtonMdp() {
        Intent switchActivityIntent = new Intent(this, D_MdpOublie.class);
        startActivity(switchActivityIntent);
        overridePendingTransition(0, 0);
    }

    private boolean verifierMotDePasse(String identifiant, String motDePasse) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        // Effectuer la requête pour obtenir le document correspondant à l'identifiant
        db.collection("user")
                .whereEqualTo("identifiant", identifiant)
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        QuerySnapshot querySnapshot = task.getResult();
                        if (querySnapshot != null && !querySnapshot.isEmpty()) {
                            // Le document utilisateur correspondant à l'identifiant existe
                            DocumentSnapshot documentSnapshot = querySnapshot.getDocuments().get(0);
                            String motDePasseStocke = documentSnapshot.getString("motDePasse");

                            if (motDePasseStocke != null && motDePasseStocke.equals(motDePasse)) {
                                // Mot de passe correct
                                // Autoriser le passage à la page suivante ici
                                // ...
                            } else {
                                // Mot de passe incorrect
                                // Afficher un message d'erreur ici
                                // ...
                            }
                        } else {
                            // Aucun document utilisateur trouvé avec l'identifiant donné
                            // Afficher un message d'erreur ici
                            // ...
                        }
                    } else {
                        // Une erreur s'est produite lors de la récupération du document utilisateur
                        // Afficher un message d'erreur ici
                        // ...
                    }
                });

        return false; // Retourner une valeur par défaut
}
}
