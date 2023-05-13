package com.example.unify;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.widget.GridView;
import android.widget.ListAdapter;

import androidx.appcompat.app.AppCompatActivity;
import com.example.unify.databinding.CParticipantsBinding;
import java.util.ArrayList;


public class Participants extends AppCompatActivity {

    private ArrayList<GridItem> liste_participants = new ArrayList<>();
    private LayoutInflater inflater ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // binding = ActivityParticipantsBinding.inflate(getLayoutInflater());
        setContentView(R.layout.c_participants);
        // setContentView(binding.getRoot());

        inflater = getLayoutInflater();

        ajouterParticipant("Lucrece","Fodouop",R.drawable.icone) ;
        ajouterParticipant("Lu","Fo",R.drawable.icone) ;

        GridView grid = findViewById(R.id.gridView) ;
        grid.setAdapter(new GridAdaptater(this,liste_participants,inflater));

    }

    private void ajouterParticipant(String nom, String prenom, int drawableId) {
        GridItem g = new GridItem(nom, prenom, drawableId);
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









