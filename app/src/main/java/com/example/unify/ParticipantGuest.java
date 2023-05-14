package com.example.unify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageButton;

import java.util.ArrayList;

public class ParticipantGuest extends AppCompatActivity {

    ImageButton fleched_g;
    ImageButton parametreg2 ;


    private ArrayList<GridItem_guest> liste_participants2 = new ArrayList<>();
    private LayoutInflater inflater ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_participant_guest);


        // Boutons
        fleched_g = findViewById(R.id.versMusique_Guest);
        parametreg2 = findViewById(R.id.parametreguest2) ;

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

        GridView grid2 = findViewById(R.id.gridView_g) ;
        grid2.setAdapter(new GridAdaptater_guest(this,liste_participants2,inflater));

    }


    // Boutons
    private void setFleched() {
        Intent switchActivityIntent = new Intent(this, InterfacePrincipaleGuest.class);
        startActivity(switchActivityIntent);
        overridePendingTransition(0, 0);
    }

    private void setParam() {
        Intent switchActivityIntent = new Intent(this, overlay_settings_guest.class);
        startActivity(switchActivityIntent);
        overridePendingTransition(0, 0);
    }


    // Grid View
    private void ajouterParticipant(String prenom, String nom, int drawableId) {
        User user = new User(prenom, nom);
        GridItem_guest g2 = new GridItem_guest(user, drawableId);
        liste_participants2.add(g2);

    }
}