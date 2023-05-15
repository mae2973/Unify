package com.example.unify;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class D_OverlayModifierCompte  extends AppCompatActivity {
    private FirebaseFirestore db;
    private EditText nomEditText;
    private EditText prenomEditText;
    private EditText mailEditText;
    //private EditText identifiantEditText;
    private Button validationButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.d_modif_compte);

        db = FirebaseFirestore.getInstance();

        nomEditText = findViewById(R.id.nom);
        prenomEditText = findViewById(R.id.prenom);
        mailEditText = findViewById(R.id.mail);
        //identifiantEditText = findViewById(R.id.identifiant);

        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // No need to do anything here.
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // No need to do anything here.
            }

            @Override
            public void afterTextChanged(Editable s) {
                validationButton.setEnabled(
                        !nomEditText.getText().toString().trim().isEmpty() &&
                                !prenomEditText.getText().toString().trim().isEmpty() &&
                                !mailEditText.getText().toString().trim().isEmpty() //&&
                                //!identifiantEditText.getText().toString().trim().isEmpty()
                );
            }
        };

        nomEditText.addTextChangedListener(textWatcher);
        prenomEditText.addTextChangedListener(textWatcher);
        mailEditText.addTextChangedListener(textWatcher);
        //identifiantEditText.addTextChangedListener(textWatcher);


        validationButton = findViewById(R.id.button_validation);
        validationButton.setEnabled(false);
        // Get the identifier from the intent that started this activity
        Intent intent = getIntent();
        String identifiant = intent.getStringExtra("IDENTIFIANT_EXTRA");

        // Rest of your code...

        validationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nom = nomEditText.getText().toString();
                String prenom = prenomEditText.getText().toString();
                String mail = mailEditText.getText().toString();
                //String identifiant = identifiantEditText.getText().toString();

                Map<String, Object> user = new HashMap<>();
                user.put("nom", nom);
                user.put("prenom", prenom);
                user.put("mail", mail);
                //user.put("identifiant", identifiant);

                // Update the document with the ID from the intent
                db.collection("users").document(identifiant)
                        .set(user)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Log.d("Info", "DocumentSnapshot successfully updated!");
                                finish();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w("Erreur", "Error updating document", e);
                            }
                        });
            }
        });
    }
}