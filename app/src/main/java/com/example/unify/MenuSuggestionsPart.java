package com.example.unify;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MenuSuggestionsPart extends AppCompatActivity {

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
        setContentView(R.layout.menu_suggestions_part);


        // Recycler view
        suggestions = new ArrayList<>();
        initRecyclerview2();

        ajouterSuggestion("Lucrece","Fodouop",R.drawable.icone,"lcjck","lqZJH"); ;
        ajouterSuggestion("Ehmhucrece","Fodouop",R.drawable.icone,"qghsbjc","lqZJH"); ;
        ajouterSuggestion("Dghe","Fodp",R.drawable.icone,"KNVK","lqZ,vne"); ;
        ajouterSuggestion("Lue","Fodouop",R.drawable.icone,"Hkjhd","lqZJH"); ;
        ajouterSuggestion("BuMLLMe","Fodouop",R.drawable.icone,"dbk,,nekbh","lqZJH"); ;




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
        Intent switchActivityIntent = new Intent(this, InterfacePrincipaleGuest.class);
        startActivity(switchActivityIntent);
        overridePendingTransition(0, 0);
    }
    private void setPar() {
        Intent switchActivityIntent = new Intent(this, overlay_settings_guest.class);
        startActivity(switchActivityIntent);
        overridePendingTransition(0, 0);
    }
}
