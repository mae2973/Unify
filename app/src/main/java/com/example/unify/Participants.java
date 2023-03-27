package com.example.unify;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import com.example.unify.databinding.ActivityParticipantsBinding;

public class Participants extends AppCompatActivity {

    ActivityParticipantsBinding binding ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityParticipantsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        String[] nom_participants = {"Prénom1 Nom1", "Prénom2 Nom2","Prénom3 Nom3","Prénom4 Nom4","Prénom5 Nom5","Prénom6 Nom6"} ;
        String[] ini_participants = {"P1","P2","P3","P4","P5","P6"} ;
        int[] fond_colore = {R.drawable.fond,R.drawable.fond,R.drawable.fond,R.drawable.fond,R.drawable.fond,R.drawable.fond} ;


        GridAdapter gridAdapter = new GridAdapter(MainActivity.this,nom_participants,ini_participants,fond_colore) ;
        binding.gridView.setAdapter(gridAdapter) ;

        binding.gridView.setOnItem

    }
}