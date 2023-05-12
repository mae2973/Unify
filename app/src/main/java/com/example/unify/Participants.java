package com.example.unify;

import android.os.Bundle;

import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import com.example.unify.GridItem;
import com.example.unify.GridAdapter;
import androidx.appcompat.app.AppCompatActivity;
import com.example.unify.databinding.ActivityParticipantsBinding;
import java.util.ArrayList;


public class Participants extends AppCompatActivity {

    ActivityParticipantsBinding binding;
    GridView grille ;
    ArrayList<GridItem> liste_participants;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // binding = ActivityParticipantsBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_participants);
       // setContentView(binding.getRoot());

        grille = findViewById(R.id.gridView);
        liste_participants = new ArrayList<>();

        GridItem nouvelItem = new GridItem("P", "Prénom", "Nom");
        ajouter_element_grille(nouvelItem);
    }



    public void ajouter_element_grille (GridItem item)  {
        this.liste_participants.add(item) ;
        GridAdapter adapter = new GridAdapter(this,0,liste_participants) ;
        grille.setAdapter(adapter);
        adapter.notifyDataSetChanged();
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




    }





