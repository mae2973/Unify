package com.example.unify;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class B_PageConnexion extends AppCompatActivity {


    Button buttonCompte;

    Button buttonMdp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_connexion);


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
        EditText idt = findViewById(R.id.identifiant);
        EditText mdp = findViewById(R.id.editTextTextPassword2);
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
                Intent intent3 = new Intent(B_PageConnexion.this, B_ChoixTypeSalon.class);
                startActivity(intent3);
            }
        });

        idt.addTextChangedListener(formulaireValidationWatcher);
        mdp.addTextChangedListener(formulaireValidationWatcher);
    }

    private void setButtonCompte() {
        Intent switchActivityIntent = new Intent(this, creation_compte.class);
        startActivity(switchActivityIntent);
        overridePendingTransition(0, 0);
    }

    private void setButtonMdp() {
        Intent switchActivityIntent = new Intent(this, mdp_oublie.class);
        startActivity(switchActivityIntent);
        overridePendingTransition(0, 0);
    }
}