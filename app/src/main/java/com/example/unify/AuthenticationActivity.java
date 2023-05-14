package com.example.unify;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.spotify.android.appremote.api.ConnectionParams;
import com.spotify.android.appremote.api.Connector;
import com.spotify.android.appremote.api.SpotifyAppRemote;
import com.spotify.sdk.android.auth.AuthorizationClient;
import com.spotify.sdk.android.auth.AuthorizationRequest;
import com.spotify.sdk.android.auth.AuthorizationResponse;

public class AuthenticationActivity extends AppCompatActivity {
    private static final String CLIENT_ID = "9ef8387d89894e118397248505847c47";
    private static final String REDIRECT_URI = "my-app://callback";
    private static final int REQUEST_CODE = 1337;
    private SpotifyAppRemote mSpotifyAppRemote;

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
        //Log.e("SpotifyAuth", "Auth");
        AuthorizationClient.openLoginActivity(this, REQUEST_CODE, request);
        //Log.e("SpotifyAuth", "Auth");
        onStart();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //Log.e("SpotifyAuth", "Auth");
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE) {
            AuthorizationResponse response = AuthorizationClient.getResponse(resultCode, data);

            switch (response.getType()) {
                // La réponse a été transformée en token
                case TOKEN:
                    // Utilisez le token d'accès pour accéder à l'API Spotify
                    String accessToken = response.getAccessToken();

                    // Vous pouvez maintenant lancer votre activité principale et utiliser le token d'accès
                    Intent intent = new Intent(this, MainActivity.class);
                    intent.putExtra("accessToken", accessToken);
                    startActivity(intent);
                    finish();
                    break;

                // Auth flow returned an error
                case ERROR:
                    Log.e("SpotifyAuth", "Auth error: " + response.getError());
                    break;

                // Most likely auth flow was cancelled
                default:
                    Log.e("SpotifyAuth", "Auth result: " + response.getType());
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        ConnectionParams connectionParams =
                new ConnectionParams.Builder(CLIENT_ID)
                        .setRedirectUri(REDIRECT_URI)
                        .showAuthView(true)
                        .build();

        SpotifyAppRemote.connect(this, connectionParams,
                new Connector.ConnectionListener() {

                    public void onConnected(SpotifyAppRemote spotifyAppRemote) {
                        mSpotifyAppRemote = spotifyAppRemote;
                        Log.d("MainActivity", "Connected! Yay!");

                        // Now you can start interacting with App Remote
                    }

                    public void onFailure(Throwable throwable) {
                        Log.e("MainActivity", throwable.getMessage(), throwable);

                        // Something went wrong when attempting to connect! Handle errors here
                    }
                });
    }

    @Override
    protected void onStop() {
        super.onStop();
        SpotifyAppRemote.disconnect(mSpotifyAppRemote);
    }

}
