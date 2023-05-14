package com.example.unify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;

public class InterfacePrincipaleGuest extends AppCompatActivity {

    ImageButton parametreg1;
    ImageButton flecheg_g;

    ImageButton fleched_g;


    ArrayList<RvMusiqueItem> songs2;
    LinearLayoutManager layoutManagerguest;
    AdapterM adapterguest;
    RecyclerView rvM2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interface_principale_invite);

        // Boutons
        parametreg1 = findViewById(R.id.parametreguest1);
        parametreg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InterfacePrincipaleGuest.this, overlay_settings_guest.class);

                Intent currentIntent = getIntent();
                String codeSalon = currentIntent.getStringExtra("CODE_SALON");

                intent.putExtra("CODE_SALON", codeSalon);

                startActivity(intent);
            }
        });


        flecheg_g = findViewById(R.id.versParticipant_Guest);
        flecheg_g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setVersParticipant_Guest();
            }
        });


        fleched_g = findViewById(R.id.versSuggestion_Guest);
        fleched_g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setVersSuggestion_Guest();
            }
        });


        // Recycler view
        songs2 = new ArrayList<>();
        initRecyclerview2();

        ajouterMusique("Lucrece", "Fodouop", R.drawable.icone, "lcjck", "lqZJH");
        ajouterMusique("Ehmhucrece", "Fodouop", R.drawable.icone, "qgeg", "lqZJH");
        ajouterMusique("Dghcce", "Fodouop", R.drawable.icone, "geqsh", "lqZJH");
        ajouterMusique("Lue", "Fodouop", R.drawable.icone, "Hkjhd", "lqZJH");
        ajouterMusique("Lucrece", "Fodouop", R.drawable.icone, "hrjh", "lqZJH");
        ajouterMusique("BALAece", "Nkzhkz", R.drawable.icone, "hrjh", "lqZJH");
        ajouterMusique("BALAece", "Nkzhkz", R.drawable.icone, "hrjh", "lqZJH");


    }


    // Boutons


    private void setVersParticipant_Guest() {
        Intent switchActivityIntent = new Intent(this, ParticipantGuest.class);
        startActivity(switchActivityIntent);
        overridePendingTransition(0, 0);
    }


    private void setVersSuggestion_Guest() {
        Intent switchActivityIntent = new Intent(this, MenuSuggestionsPart.class);
        startActivity(switchActivityIntent);
        overridePendingTransition(0, 0);
    }


    // Recyler view
    private void initRecyclerview2() {
        rvM2 = findViewById(R.id.rvMusiqueGuest);
        layoutManagerguest = new LinearLayoutManager(this);
        layoutManagerguest.setOrientation(RecyclerView.VERTICAL);
        rvM2.setLayoutManager(layoutManagerguest);
        adapterguest = new AdapterM(songs2);
        rvM2.setAdapter(adapterguest);
        adapterguest.notifyDataSetChanged();

    }


    private void ajouterMusique(String p, String n, int image, String a, String t) {
        User user = new User(p, n);
        Song song = new Song(a, t);
        RvMusiqueItem m3 = new RvMusiqueItem(user, image, song);
        songs2.add(m3);
        adapterguest.notifyDataSetChanged();

    }
}
