package com.example.unify;

import android.content.Intent;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ListAdapter;

import androidx.appcompat.app.AppCompatActivity;
import com.example.unify.databinding.CParticipantsBinding;
import java.util.ArrayList;


public class Participants extends AppCompatActivity {

    ImageButton flechedroite;
    ImageButton parametreh1 ;

    private ArrayList<GridItem> liste_participants = new ArrayList<>();
    private LayoutInflater inflater ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // binding = ActivityParticipantsBinding.inflate(getLayoutInflater());
        setContentView(R.layout.c_participants);
        // setContentView(binding.getRoot());




        // Boutons
        flechedroite = findViewById(R.id.versMusique);
        parametreh1 = findViewById(R.id.parametrehost1) ;

        flechedroite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFlechedroite();
            }
        });

        parametreh1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setParametreH1();
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




        GridView grid = findViewById(R.id.gridView) ;
        grid.setAdapter(new GridAdaptater(this,liste_participants,inflater));

    }


    // Boutons
    private void setFlechedroite() {
        Intent switchActivityIntent = new Intent(this, InterfacePrincipale.class);
        startActivity(switchActivityIntent);
        overridePendingTransition(0, 0);
    }

    private void setParametreH1() {
        Intent switchActivityIntent = new Intent(this, overlay_settings_host.class);
        startActivity(switchActivityIntent);
        overridePendingTransition(0, 0);
    }




    // Grid View
    private void ajouterParticipant(String prenom, String nom, int drawableId) {
        User user = new User(prenom, nom);
        GridItem g = new GridItem(user, drawableId);
        liste_participants.add(g);

    }
}




















        /*String[] nom_participants = {"Prénom1 Nom1", "Prénom2 Nom2", "Prénom3 Nom3", "Prénom4 Nom4", "Prénom5 Nom5", "Prénom6 Nom6"};
        String[] ini_participants = {"P1", "P2", "P3", "P4", "P5", "P6"};
        int[] image = {R.drawable.fond, R.drawable.fond, R.drawable.fond, R.drawable.fond, R.drawable.fond, R.drawable.fond};




        GridAdapter gridAdapter = new GridAdapter(Participants.this, nom_participants,prenom_participants,ini_participants, image);
        binding.gridView.setAdapter(gridAdapter);

        binding.gridView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {

                Toast.makeText(Participants.this, "You clicked on" + nom_participants[position], Toast.LENGTH_SHORT).show();

            }
        });

         */









