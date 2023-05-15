package com.example.unify;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FieldPath;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class C_ParticipantGuest extends AppCompatActivity {

    ImageButton fleched_g;
    ImageButton parametreg2 ;
    GridView grid2;

    private ArrayList<GridItem_guest> liste_participants2 = new ArrayList<>();
    private LayoutInflater inflater ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c_participant_guest);


        // Boutons
        fleched_g = findViewById(R.id.versMusique_Guest);
        parametreg2 = findViewById(R.id.parametreguest2) ;

         grid2 = findViewById(R.id.gridView_g) ;

       fleched_g.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               setFleched();
           }
       });


        parametreg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setParam();
            }
        });



        // Grid View
        inflater = getLayoutInflater();

/*
        ajouterParticipant("Lucrece","Fodouop",R.drawable.icone) ;
        ajouterParticipant("Luqahd","Foaqkj",R.drawable.icone) ;
        ajouterParticipant("Zqahd","Foeeqkj",R.drawable.icone) ;
        ajouterParticipant("Luqahd","Foaqkj",R.drawable.icone) ;
        ajouterParticipant("Zqahd","Foeeeqkj",R.drawable.icone) ;
        ajouterParticipant("Zqahd","Foeeegzkj",R.drawable.icone) ;
        ajouterParticipant("Zqsf,nahd","Foeqkj",R.drawable.icone) ;
        ajouterParticipant("Zqahd","Foeeekj",R.drawable.icone) ;
        ajouterParticipant("Zqsf,nnzahd","Foeeegqkj",R.drawable.icone) ;
        ajouterParticipant("Hqahd","Foeeeqkj",R.drawable.icone) ;
        ajouterParticipant("Eqahd","Foeeegzeqkj",R.drawable.icone) ;
        ajouterParticipant("Rqkefnjkzahd","Foeeegj",R.drawable.icone) ;
        ajouterParticipant("Iqahd","Foeeegzekj",R.drawable.icone) ;
        */

        Intent currentIntent = getIntent();
        String code_room = currentIntent.getStringExtra("CODE_SALON");
        FirebaseFirestore db = FirebaseFirestore.getInstance();


        db.collection("rooms")
                .whereEqualTo(FieldPath.documentId(), code_room)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d("Room", document.getId() + " => " + document.getData());
                                List<String> list = (List<String>) document.get("participants");
                                for (String participant : list) {
                                    ajouterParticipant(participant, participant, R.drawable.icone);
                                }
                            }
                        } else {
                            Log.w("Erreur", "Error getting documents.", task.getException());
                        }
                    }
                });


    }


    // Boutons
    private void setFleched() {
        Intent switchActivityIntent = new Intent(this, C_InterfacePrincipaleGuest.class);

        Intent currentIntent = getIntent();
        String codeSalon = currentIntent.getStringExtra("CODE_SALON");
        String identifiant = currentIntent.getStringExtra("IDENTIFIANT_EXTRA");

        switchActivityIntent.putExtra("CODE_SALON", codeSalon);
        switchActivityIntent.putExtra("IDENTIFIANT_EXTRA", identifiant);

        startActivity(switchActivityIntent);
        overridePendingTransition(0, 0);
    }

    private void setParam() {
        Intent switchActivityIntent = new Intent(this, D_OverlaySettingsGuest.class);

        Intent currentIntent = getIntent();
        String codeSalon = currentIntent.getStringExtra("CODE_SALON");
        String identifiant = currentIntent.getStringExtra("IDENTIFIANT_EXTRA");

        switchActivityIntent.putExtra("CODE_SALON", codeSalon);
        switchActivityIntent.putExtra("IDENTIFIANT_EXTRA", identifiant);

        startActivity(switchActivityIntent);
        overridePendingTransition(0, 0);
    }


    // Grid View
    private void ajouterParticipant(String prenom, String nom, int drawableId) {
        User user = new User(prenom, nom);
        GridItem_guest g2 = new GridItem_guest(user, drawableId);
        liste_participants2.add(g2);
        grid2.setAdapter(new GridAdaptater_guest(this,liste_participants2,inflater));

    }
}