package com.example.unify;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.unify.databinding.CParticipantsBinding;

import java.util.ArrayList;
import java.util.List;

public class C_Participants_TODO extends AppCompatActivity {

    CParticipantsBinding binding;
    List<String> itemList;
    ItemAdapter itemAdapter;
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = CParticipantsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        String[] nom_participants = {"Prénom1 Nom1", "Prénom2 Nom2", "Prénom3 Nom3", "Prénom4 Nom4", "Prénom5 Nom5", "Prénom6 Nom6"};
        String[] ini_participants = {"P1", "P2", "P3", "P4", "P5", "P6"};
        int[] image = {R.drawable.fond, R.drawable.fond, R.drawable.fond, R.drawable.fond, R.drawable.fond, R.drawable.fond};


        GridAdapter gridAdapter = new GridAdapter(C_Participants_TODO.this, nom_participants, ini_participants, image);
        //binding.gridView.setAdapter(gridAdapter);

        //binding.gridView.setOnItemClickListener(new OnItemClickListener() {

        //    @Override
        //    public void onItemClick(AdapterView parent, View view, int position, long id) {

        //        Toast.makeText(Participants.this, "You clicked on" + nom_participants[position], Toast.LENGTH_SHORT).show();

        //    }
        //});
        itemList = new ArrayList<>();
        itemList.add("Element 1");
        itemList.add("Element 2");
        itemList.add("Element 3");
        itemAdapter = new ItemAdapter(itemList);
        recyclerView = findViewById(R.id.recyclerView_participants);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(itemAdapter);
        itemList.add("Element 3");


    }
}




