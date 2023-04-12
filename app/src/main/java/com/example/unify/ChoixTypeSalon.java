package com.example.unify;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class ChoixTypeSalon extends AppCompatActivity {

    ImageButton switchToConnexionActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_type_salon);


        switchToConnexionActivity = findViewById(R.id.rejoindre);
        switchToConnexionActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchActivities();
            }
        });

    }

    private void switchActivities() {
        Intent switchActivityIntent = new Intent(this, ConnexionSalon.class);
        startActivity(switchActivityIntent);
    }

}