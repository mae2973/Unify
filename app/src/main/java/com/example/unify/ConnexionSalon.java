package com.example.unify;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class ConnexionSalon extends AppCompatActivity {

    ImageButton switchToChoixTypeActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.connexion_salon);

        switchToChoixTypeActivity = findViewById(R.id.rejoindre);
        switchToChoixTypeActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchActivities();
            }
        });

    }



    private void switchActivities() {
        Intent switchActivityIntent = new Intent(this, ChoixTypeSalon.class);
        startActivity(switchActivityIntent);
    }


}