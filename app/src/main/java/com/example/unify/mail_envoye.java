package com.example.unify;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class mail_envoye extends AppCompatActivity {

    Button buttonValider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mail_envoye);


        buttonValider = findViewById(R.id.button_validation);
        buttonValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setButtonValider();
            }
        });
    }

    private void setButtonValider() {
        // TODO avant le changement de fenetre, vérifier que le numéro rentrer par le mec est celui recu par mail
        Intent switchActivityIntent = new Intent(this, overlay_changer_mdp.class);
        // destination à modif une fois qu'on aura les bons trucs avec les fragments
        startActivity(switchActivityIntent);
        this.finish();
        overridePendingTransition(0, 0);
    }
}