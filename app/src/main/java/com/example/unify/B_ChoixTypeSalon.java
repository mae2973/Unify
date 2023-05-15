package com.example.unify;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class B_ChoixTypeSalon extends AppCompatActivity {

    ImageButton buttonCreer;
    ImageButton buttonRejoindre;
    Button buttonParametre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.b_choix_type_salon);

        // récupération de l'id transmis depuis l'activité précédente
        String identifiant = getIntent().getStringExtra("identifiant");


        buttonCreer = findViewById(R.id.creer);
        buttonCreer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setButtonCreer();
            }
        });

        buttonRejoindre = findViewById(R.id.rejoindre_salon);
        buttonRejoindre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setButtonRejoindre();
            }
        });

        buttonParametre = findViewById(R.id.param_choix_salon);
        buttonParametre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setButtonParametre();
            }
        });


        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("rooms")
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

    private void setButtonCreer() {
        Intent switchActivityIntent = new Intent(this, B_ConnexionSpotifyCrea.class);

        String identifiant = getIntent().getStringExtra("identifiant");

        switchActivityIntent.putExtra("IDENTIFIANT_EXTRA", identifiant);

        startActivity(switchActivityIntent);
        overridePendingTransition(0, 0);
    }


    private void setButtonRejoindre() {
        Intent switchActivityIntent = new Intent(this, B_RejoindreSalon.class);

        String identifiant = getIntent().getStringExtra("identifiant");

        switchActivityIntent.putExtra("IDENTIFIANT_EXTRA", identifiant);

        startActivity(switchActivityIntent);
        overridePendingTransition(0, 0);
    }

    private void setButtonParametre() {
        Intent switchActivityIntent = new Intent(this, D_OverlayParamAccueil.class);

        String identifiant = getIntent().getStringExtra("identifiant");
        switchActivityIntent.putExtra("IDENTIFIANT_EXTRA", identifiant);

        startActivity(switchActivityIntent);
        overridePendingTransition(0, 0);
    }

}