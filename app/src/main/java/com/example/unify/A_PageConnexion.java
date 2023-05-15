package com.example.unify;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.concurrent.atomic.AtomicBoolean;

public class A_PageConnexion extends AppCompatActivity {
    Button buttonCompte;
    Button buttonMdp;
    FirebaseFirestore db;

    private String identifiant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_page_connexion);

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
                identifiant = id_saisi.getText().toString(); // assigner l'id à la variable saisie

                EditText mdp_saisi = findViewById(R.id.mdp_saisi_user);
                String mdp_text = mdp_saisi.getText().toString();

                verifierMotDePasse(identifiant,mdp_text);
            }
        });


        idt.addTextChangedListener(formulaireValidationWatcher);
        mdp.addTextChangedListener(formulaireValidationWatcher);


        db.collection("users")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d("Info", document.getId() + " => " + document.getData());
                            }
                        } else {
                            Log.w("Info", "Error getting documents.", task.getException());
                        }
                    }
                });

    }

    private void setButtonCompte() {
        Intent switchActivityIntent = new Intent(this, B_CreationCompte.class);
        startActivity(switchActivityIntent);
        overridePendingTransition(0, 0);
    }

    private void setButtonMdp() {
        Intent switchActivityIntent = new Intent(this, AB_MdpOublie.class);
        startActivity(switchActivityIntent);
        overridePendingTransition(0, 0);
    }

    private boolean verifierMotDePasse(String identifiant, String password) {

        AtomicBoolean value = new AtomicBoolean(false);
        // Effectuer la requête pour obtenir le document correspondant à l'identifiant

        db.collection("user")
                .whereEqualTo("identifiant", identifiant)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            QuerySnapshot result = task.getResult();
                            Log.d("Firebase", "Number of documents: " + result.size());
                            for (QueryDocumentSnapshot document : result) {
                                String storedPassword = document.getString("mdp");
                                if (password.equals(storedPassword)) {
                                    // password correct
                                    Log.d("Firebase", "Connexion established");
                                    Intent intent = new Intent(A_PageConnexion.this, B_ChoixTypeSalon.class);
                                    intent.putExtra("identifiant", identifiant); // Passer l'id à la page suivante
                                    startActivity(intent);
                                } else {
                                    // password incorrect
                                    Toast.makeText(A_PageConnexion.this, "Incorrect password.",
                                            Toast.LENGTH_SHORT).show();
                                    Log.d("Firebase", "Incorrect password.");
                                }
                            }

                        } else {
                            // Log the error
                            Toast.makeText(A_PageConnexion.this, "Error getting documents: ",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });

        return value.get(); // retourne une valeur par défaut
    }
}
