package com.example.unify;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.unify.databinding.ActivityParticipantsBinding;

public class Participants extends AppCompatActivity {

    ActivityParticipantsBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityParticipantsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        String[] nom_participants = {"Prénom1 Nom1", "Prénom2 Nom2", "Prénom3 Nom3", "Prénom4 Nom4", "Prénom5 Nom5", "Prénom6 Nom6"};
        String[] ini_participants = {"P1", "P2", "P3", "P4", "P5", "P6"};
        int[] image = {R.drawable.fond, R.drawable.fond, R.drawable.fond, R.drawable.fond, R.drawable.fond, R.drawable.fond};


        GridAdapter gridAdapter = new GridAdapter(Participants.this, nom_participants, ini_participants, image);
        binding.gridView.setAdapter(gridAdapter);

        binding.gridView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {

                Toast.makeText(Participants.this, "You clicked on" + nom_participants[position], Toast.LENGTH_SHORT).show();

            }
        });
    }
}




