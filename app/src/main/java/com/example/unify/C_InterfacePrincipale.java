package com.example.unify;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class C_InterfacePrincipale extends AppCompatActivity {


ImageButton parametreh2 ;
ImageButton flecheg ;
ImageButton fleched;


    ArrayList<RvMusiqueItem> songs ;
    LinearLayoutManager layoutManager ;
    AdapterM adapter ;
    RecyclerView rvM ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c_interface_principale);



        // Recycler view
        songs = new ArrayList<>();
        initRecyclerview();

        ajouterMusique("Lucrece","Fodouop",R.drawable.icone,"Starset","Carnivore") ;
        ajouterMusique("Ehmhucrece","Fodouop",R.drawable.icone,"Imagine Dragons","Waves") ;
        ajouterMusique("Dghcce","Fodouop",R.drawable.icone,"Jane","The fool") ;
        ajouterMusique("Lue","Fodouop",R.drawable.icone,"Louane","Secret") ;
        ajouterMusique("Lucrece","Fodouop",R.drawable.icone,"Slimane","Chez toi") ;
        ajouterMusique("Lucrece","Fodouop",R.drawable.icone,"PLK","Demain") ;



        // Boutons
        parametreh2 = findViewById(R.id.parametrehost2) ;
        parametreh2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(C_InterfacePrincipale.this, D_OverlaySettingsHost.class);

                Intent currentIntent = getIntent();
                String codeSalon = currentIntent.getStringExtra("CODE_SALON");
                String identifiant = currentIntent.getStringExtra("IDENTIFIANT_EXTRA");

                intent.putExtra("CODE_SALON", codeSalon);
                intent.putExtra("IDENTIFIANT_EXTRA", identifiant);

                startActivity(intent);
            }
        });



        flecheg = findViewById(R.id.versParticipant) ;
        flecheg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setVersParticipant();
            }
        });


        fleched = findViewById(R.id.versSuggestion) ;
        fleched.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setVersSuggestion();
            }
        });


    }

    // Boutons

    private void setParametreH2() {
        Intent switchActivityIntent = new Intent(this, D_OverlaySettingsHost.class);

        Intent currentIntent = getIntent();
        String codeSalon = currentIntent.getStringExtra("CODE_SALON");
        String identifiant = currentIntent.getStringExtra("IDENTIFIANT_EXTRA");

        switchActivityIntent.putExtra("CODE_SALON", codeSalon);
        switchActivityIntent.putExtra("IDENTIFIANT_EXTRA", identifiant);

        startActivity(switchActivityIntent);
        overridePendingTransition(0, 0);
    }

    private void setVersParticipant() {
        Intent switchActivityIntent = new Intent(this, C_Participants.class);

        Intent currentIntent = getIntent();
        String codeSalon = currentIntent.getStringExtra("CODE_SALON");
        String identifiant = currentIntent.getStringExtra("IDENTIFIANT_EXTRA");

        switchActivityIntent.putExtra("CODE_SALON", codeSalon);
        switchActivityIntent.putExtra("IDENTIFIANT_EXTRA", identifiant);

        startActivity(switchActivityIntent);
        overridePendingTransition(0, 0);
        finish();
    }


    private void setVersSuggestion() {
        Intent switchActivityIntent = new Intent(this, C_MenuSuggestionsPart.class);

        Intent currentIntent = getIntent();
        String codeSalon = currentIntent.getStringExtra("CODE_SALON");
        String identifiant = currentIntent.getStringExtra("IDENTIFIANT_EXTRA");

        switchActivityIntent.putExtra("CODE_SALON", codeSalon);
        switchActivityIntent.putExtra("IDENTIFIANT_EXTRA", identifiant);

        startActivity(switchActivityIntent);
        overridePendingTransition(0, 0);
        finish();
    }


    // Recyler view
    private void initRecyclerview() {
        rvM = findViewById(R.id.rvMusique);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        rvM.setLayoutManager(layoutManager);
        adapter = new AdapterM(songs);
        rvM.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }


    private void ajouterMusique(String p, String n, int image, String a, String t) {
        User user = new User(p, n);
        Song song = new Song(a, t);
        RvMusiqueItem m = new RvMusiqueItem(user, image, song);
        songs.add(m);
        adapter.notifyDataSetChanged();
    }

    }





