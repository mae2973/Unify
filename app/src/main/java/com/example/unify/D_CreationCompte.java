package com.example.unify;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

public class D_CreationCompte extends AppCompatActivity {

    Button buttonValider;
    Button buttonAnnuler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.d_creation_compte);

        buttonValider = findViewById(R.id.valid);

        buttonAnnuler = findViewById(R.id.annuler);
        buttonAnnuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setButtonAnnuler();
            }
        });

        // BOUTON POUR VALIDER (s'active seulement si tous les champs sont remplis)
        EditText nom2 = findViewById(R.id.nom_user);
        EditText prenom2 = findViewById(R.id.prenom_user);
        EditText mail2 = findViewById(R.id.mail_user);
        EditText identifiant2 = findViewById(R.id.identifiant_user);
        EditText mdp2 = findViewById(R.id.mdp_user);
        EditText confirm_mdp2 = findViewById(R.id.confirm_mdp_user);

        buttonValider.setEnabled(false);

        TextWatcher formulaireValidation = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String nom = nom2.getText().toString().trim();
                String prenom = prenom2.getText().toString().trim();
                String id = identifiant2.getText().toString().trim();
                String mail = mail2.getText().toString().trim();
                String mdp = mdp2.getText().toString().trim();
                String conf_mdp = confirm_mdp2.getText().toString().trim();
                buttonValider.setEnabled(!nom.isEmpty() && !prenom.isEmpty() && !id.isEmpty() && !mail.isEmpty() && !mdp.isEmpty() && !conf_mdp.isEmpty() && mdp.equals(conf_mdp));
            }

            @Override
            public void afterTextChanged(Editable s) {}
        };

        buttonValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseFirestore db = FirebaseFirestore.getInstance();

                // Récupérer l'identifiant saisi
                EditText identifiant = findViewById(R.id.identifiant_user);
                String id_text = identifiant.getText().toString();

                // Vérifier si l'identifiant existe déjà
                db.collection("user")
                        .whereEqualTo("identifiant", id_text)
                        .get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                if (task.isSuccessful()) {
                                    QuerySnapshot querySnapshot = task.getResult();
                                    if (querySnapshot != null && !querySnapshot.isEmpty()) {
                                        // L'identifiant existe déjà, afficher un message d'erreur ou prendre une action appropriée
                                        Toast.makeText(D_CreationCompte.this, "Cet identifiant existe déjà.", Toast.LENGTH_SHORT).show();
                                    } else {
                                        // L'identifiant n'existe pas, ajouter le document à la base de données

                                        // Génération du nom du document
                                        db.collection("user")
                                                .get()
                                                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                                                    @Override
                                                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                                        if (task.isSuccessful()) {
                                                            int count = task.getResult().size();
                                                            String documentName = "user" + (count + 1);

                                                            // Accédez à la collection et créez le document avec le nom choisi
                                                            DocumentReference documentRef = db.collection("user").document(documentName);

                                                            EditText nom = findViewById(R.id.nom_user);
                                                            String nom_text = nom.getText().toString();

                                                            EditText prenom = findViewById(R.id.prenom_user);
                                                            String prenom_text = prenom.getText().toString();

                                                            EditText mail = findViewById(R.id.mail_user);
                                                            String mail_text = mail.getText().toString();

                                                            EditText mdp = findViewById(R.id.mdp_user);
                                                            String mdp_text = mdp.getText().toString();

                                                            // Créez les données à ajouter au document
                                                            Map<String, Object> data = new HashMap<>();
                                                            data.put("nom", nom_text);
                                                            data.put("prenom", prenom_text);
                                                            data.put("mail", mail_text);
                                                            // TODO: Vérifier que mdp = confirm mdp
                                                            data.put("identifiant", id_text);
                                                            data.put("mdp", mdp_text);

                                                            // Ajoutez le document à la base de données
                                                            documentRef.set(data)
                                                                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                                        @Override
                                                                        public void onSuccess(Void aVoid) {
                                                                            // Document créé avec succès
                                                                        }
                                                                    })
                                                                    .addOnFailureListener(new OnFailureListener() {
                                                                        @Override
                                                                        public void onFailure(@NonNull Exception e) {
                                                                            // Erreur lors de la création du document
                                                                        }
                                                                    });

                                                            Intent switchActivityIntent = new Intent(D_CreationCompte.this, B_PageConnexion.class);
                                                            startActivity(switchActivityIntent);
                                                            overridePendingTransition(0, 0);
                                                        } else {
                                                            // Une erreur s'est produite lors de la récupération du nombre de documents
                                                            Toast.makeText(D_CreationCompte.this, "Erreur lors de la génération du nom du document.", Toast.LENGTH_SHORT).show();
                                                        }
                                                    }
                                                });
                                    }
                                } else {
                                    // Une erreur s'est produite lors de la vérification
                                    Toast.makeText(D_CreationCompte.this, "Erreur lors de la vérification de l'identifiant.", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });

        prenom2.addTextChangedListener(formulaireValidation);
        nom2.addTextChangedListener(formulaireValidation);
        mail2.addTextChangedListener(formulaireValidation);
        identifiant2.addTextChangedListener(formulaireValidation);
        mdp2.addTextChangedListener(formulaireValidation);
        confirm_mdp2.addTextChangedListener(formulaireValidation);
    }

    private void setButtonAnnuler() {
        Intent switchActivityIntent = new Intent(this, B_PageConnexion.class);
        startActivity(switchActivityIntent);
        overridePendingTransition(0, 0);
    }
}


