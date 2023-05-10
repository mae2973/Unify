package com.example.unify;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class mdp_oublie extends AppCompatActivity {

    Button buttonValider;

    Button buttonAnnuler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mdp_oublie);

        buttonValider = findViewById(R.id.button_validation);
        buttonValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setButtonValider();
            }
        });


        buttonAnnuler = findViewById(R.id.button_validation);
        buttonAnnuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setButtonAnnuler();
            }
        });
}
    private void setButtonValider() {
        Intent switchActivityIntent = new Intent(this, mail_envoye.class);
        // destination à modif une fois qu'on aura les bons trucs avec les fragments
        startActivity(switchActivityIntent);
        this.finish();
        overridePendingTransition(0, 0);
    }

    private void setButtonAnnuler() {
        this.finish();
        overridePendingTransition(0, 0);
    }
}