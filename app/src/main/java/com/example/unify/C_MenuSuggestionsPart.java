package com.example.unify;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class C_MenuSuggestionsPart extends AppCompatActivity {

    // Suggestion GUEST !!!

    ImageButton flecheg2 ;
    ImageButton par ;


    ArrayList<CA_Sugestion_TODO> suggestions;
    LinearLayoutManager layoutManager2;
    AdapterS adapter2;
    RecyclerView rvSS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_suggestions_part_deprecated);


        // Recycler view
        suggestions = new ArrayList<>();
        initRecyclerview2();

        ajouterSuggestion("Lucrece","Fodouop",R.drawable.icone,"Tino Rossi","Chanson aux nuages"); ;
        ajouterSuggestion("Ehmhucrece","Fodouop",R.drawable.icone,"Nekfeu","Esquimaux"); ;
        ajouterSuggestion("Lue","Fodouop",R.drawable.icone,"Mandragora","Sunshine 3000"); ;
        ajouterSuggestion("BuMLLMe","Fodouop",R.drawable.icone,"dbk,,PLK","Demain");




        // BOUTONS
        flecheg2 = findViewById(R.id.versMusique2) ;
        flecheg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setVersMusique2();
            }
        });

        par = findViewById(R.id.parametreguest3) ;
        par.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setPar();
            }
        });
    }


    // Recyler view
    private void initRecyclerview2() {
        rvSS = findViewById(R.id.rvS);
        layoutManager2 = new LinearLayoutManager(this);
        layoutManager2.setOrientation(RecyclerView.VERTICAL);
        rvSS.setLayoutManager(layoutManager2);
        adapter2 = new AdapterS(suggestions);
        rvSS.setAdapter(adapter2);
        adapter2.notifyDataSetChanged();
    }

    private void ajouterSuggestion(String p1, String n1, int image1, String a1, String t1) {
        User user = new User(p1, n1);
        Song song = new Song(a1, t1);
        CA_Sugestion_TODO s = new CA_Sugestion_TODO(user, image1, song);
        suggestions.add(s);
        adapter2.notifyDataSetChanged();
    }





    // BOUTONS
    private void setVersMusique2() {
        Intent switchActivityIntent = new Intent(this, C_InterfacePrincipaleGuest.class);

        Intent currentIntent = getIntent();
        String codeSalon = currentIntent.getStringExtra("CODE_SALON");
        String identifiant = currentIntent.getStringExtra("IDENTIFIANT_EXTRA");

        switchActivityIntent.putExtra("CODE_SALON", codeSalon);
        switchActivityIntent.putExtra("IDENTIFIANT_EXTRA", identifiant);

        startActivity(switchActivityIntent);
        overridePendingTransition(0, 0);
        finish();
    }
    private void setPar() {
        Intent switchActivityIntent = new Intent(this, D_OverlaySettingsGuest.class);

        Intent currentIntent = getIntent();
        String codeSalon = currentIntent.getStringExtra("CODE_SALON");
        String identifiant = currentIntent.getStringExtra("IDENTIFIANT_EXTRA");

        switchActivityIntent.putExtra("CODE_SALON", codeSalon);
        switchActivityIntent.putExtra("IDENTIFIANT_EXTRA", identifiant);

        startActivity(switchActivityIntent);
        overridePendingTransition(0, 0);
    }
}
