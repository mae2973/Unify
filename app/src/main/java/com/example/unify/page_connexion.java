package com.example.unify;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class page_connexion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_connexion);

        // BOUTON POUR CREER UN COMPTE
        Button CreerCompte = findViewById(R.id.button_création_compte);
        CreerCompte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                Intent intent1 = new Intent(page_connexion.this, creation_compte.class);
                startActivity(intent1);
            }
        });

        // BOUTON POUR MDP OUBLIE
        Button MdpOublie = findViewById(R.id.button_mdp_oublié);
        MdpOublie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v2) {
                Intent intent2 = new Intent(page_connexion.this,mdp_oublie.class);
                startActivity(intent2);
            }
        });

        // BOUTON POUR VALIDER ( s'active seulement si tous les champs sont remplis )
        EditText editTextNom = findViewById(R.id.identifiant);
        EditText editTextPrenom = findViewById(R.id.editTextTextPassword2);
        Button Valider = findViewById(R.id.button_validation);

        Valider.setEnabled(false);

        TextWatcher formulaireValidationWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String nom = editTextNom.getText().toString().trim();
                String prenom = editTextPrenom.getText().toString().trim();
                Valider.setEnabled(!nom.isEmpty() && !prenom.isEmpty());
            }

            @Override
            public void afterTextChanged(Editable s) {}
        };

        Valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v3) {
                Intent intent3 = new Intent(page_connexion.this,ChoixTypeSalon.class);
                startActivity(intent3);
            }
        });

        editTextNom.addTextChangedListener(formulaireValidationWatcher);
        editTextPrenom.addTextChangedListener(formulaireValidationWatcher);
    }
}