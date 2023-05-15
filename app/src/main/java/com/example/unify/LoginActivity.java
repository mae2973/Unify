package com.example.unify;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);

        session = new Session(getApplicationContext());

        if (session.isLoggedIn()) {
            // l'utilisateur est connecté, vous pouvez passer à la MainActivity
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    public void loginUser(String token) {
        session.createLoginSession(token);
        // l'utilisateur est maintenant connecté, passons à la MainActivity
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}

