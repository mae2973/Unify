package com.example.unify;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;

public class overlay_settings_guest extends AppCompatActivity {

    Button buttonQuitterSalon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.overlay_settings_guest);

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
    }

    private void setButtonQuitterSalon() {
        String identifiant = getIntent().getStringExtra("IDENTIFIANT_EXTRA");
        String codeSalon = getIntent().getStringExtra("CODE_SALON");

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        CollectionReference roomsRef = db.collection("rooms");

        roomsRef.document(codeSalon)
                .update("participants", FieldValue.arrayRemove(identifiant))
                .addOnSuccessListener(aVoid -> {
                    // Identifiant supprimé
                })
                .addOnFailureListener(e -> {
                    // Gérer les erreurs lors de la suppression de l'identifiant
                });
        Intent switchActivityIntent = new Intent(this, B_ChoixTypeSalon.class);
        startActivity(switchActivityIntent);
        //TODO: la je change d'activité mais je ne kill pas celles d'avant, voir si on peut le faire
        overridePendingTransition(0, 0);
    }
}
