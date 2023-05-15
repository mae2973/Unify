package com.example.unify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;

public class SuggestionHost extends AppCompatActivity {

// Boutons
    ImageButton flecheg3 ;
    ImageButton par2 ;



// Recycler view
    ArrayList<SuggestionItemHost> suggestions_host;
    LinearLayoutManager layoutManager3;
    AdapterS_Host adapter3;
    RecyclerView recyclerview;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestion_host);



        // BOUTONS
        flecheg3 = findViewById(R.id.versMusique3) ;
        flecheg3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setVersMusique3();
            }
        });

        par2 = findViewById(R.id.parametrehost3) ;
        par2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setPar2();
            }
        });







        // Recycler view
        suggestions_host= new ArrayList<>();
        initRecyclerview4();

        ajouterSuggestion("Lucrece","Fodouop",R.drawable.icone,"Tino Rossi","Chanson aux nuages"); ;
        ajouterSuggestion("Ehmhucrece","Fodouop",R.drawable.icone,"Nekfeu","Esquimaux"); ;
        ajouterSuggestion("Lue","Fodouop",R.drawable.icone,"Mandragora","Sunshine 3000"); ;
        ajouterSuggestion("BuMLLMe","Fodouop",R.drawable.icone,"dbk,,PLK","Demain"); ;


    }



    // BOUTONS
    private void setVersMusique3() {
        Intent switchActivityIntent = new Intent(this, InterfacePrincipale.class);
        startActivity(switchActivityIntent);
        overridePendingTransition(0, 0);
    }
    private void setPar2() {
        Intent switchActivityIntent = new Intent(this, overlay_settings_host.class);
        startActivity(switchActivityIntent);
        overridePendingTransition(0, 0);
    }





    // Recyler view
    private void initRecyclerview4() {
        recyclerview = findViewById(R.id.rvSH);
        layoutManager3 = new LinearLayoutManager(this);
        layoutManager3.setOrientation(RecyclerView.VERTICAL);
        recyclerview.setLayoutManager(layoutManager3);
        adapter3 = new AdapterS_Host(suggestions_host);
        recyclerview.setAdapter(adapter3);
        adapter3.notifyDataSetChanged();
    }

    private void ajouterSuggestion(String p1, String n1, int image2, String a1, String t1) {
        User u = new User(p1, n1);
        Song s = new Song(a1, t1);
        SuggestionItemHost ss = new SuggestionItemHost (image2,u, s);
        suggestions_host.add(ss);
        adapter3.notifyDataSetChanged();
    }
    }
