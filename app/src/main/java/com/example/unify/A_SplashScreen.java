package com.example.unify;

import android.content.Intent;
import android.os.Bundle;
import android.os. Handler ;
import androidx.appcompat.app.AppCompatActivity;

public class A_SplashScreen extends AppCompatActivity {

    private final int SPLASH_SCREEN_TIMEOUT = 3000 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_splash_screen);



        // Rediriger vers la page Connexion après 3 secondes
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                // Démarrer une page
                Intent intent = new Intent(getApplicationContext(), B_PageConnexion.class) ;
                startActivity(intent) ;
                finish();
            }
        } ;



        // Création d'un Handler post delayed
        new Handler().postDelayed(runnable,SPLASH_SCREEN_TIMEOUT) ;


    }
}