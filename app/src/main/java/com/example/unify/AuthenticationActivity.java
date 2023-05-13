package com.example.unify;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.spotify.sdk.android.auth.AuthorizationClient;
import com.spotify.sdk.android.auth.AuthorizationRequest;
import com.spotify.sdk.android.auth.AuthorizationResponse;

public class AuthenticationActivity extends AppCompatActivity {
    private static final String CLIENT_ID = "9ef8387d89894e118397248505847c47";
    private static final String REDIRECT_URI = "unify://callback";
    private static final int REQUEST_CODE = 1337;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);

        AuthorizationRequest.Builder builder = new AuthorizationRequest.Builder(
                CLIENT_ID,
                AuthorizationResponse.Type.TOKEN,
                REDIRECT_URI);

        builder.setScopes(new String[]{"streaming"});
        AuthorizationRequest request = builder.build();

        AuthorizationClient.openLoginActivity(this, REQUEST_CODE, request);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE) {
            AuthorizationResponse response = AuthorizationClient.getResponse(resultCode, data);

            if (response.getType() == AuthorizationResponse.Type.TOKEN) {
                // Utilisez le token d'accès pour accéder à l'API Spotify
                String accessToken = response.getAccessToken();

                // Vous pouvez maintenant lancer votre activité principale et utiliser le token d'accès
                Intent intent = new Intent(this, MainActivity.class);
                intent.putExtra("accessToken", accessToken);
                startActivity(intent);
                finish();
            }
        }
    }
}
