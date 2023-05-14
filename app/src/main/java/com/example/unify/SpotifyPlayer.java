package com.example.unify;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class SpotifyPlayer extends AppCompatActivity {

    private static final String CLIENT_ID = "9ef8387d89894e118397248505847c47";
    private static final String REDIRECT_URI = "my-app://callback";
    private static final String API_BASE_URL = "https://api.spotify.com/v1/";
    private static final String PLAYLIST_ID = "37i9dQZF1DWZeAduKwuwrr";

    private OkHttpClient mOkHttpClient;
    private String mAccessToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAccessToken = getIntent().getStringExtra("access_token");

        mOkHttpClient = new OkHttpClient();

        fetchPlaylist(PLAYLIST_ID);
    }

    private void fetchPlaylist(String playlistId) {
        HttpUrl url = HttpUrl.parse(API_BASE_URL + "playlists/" + playlistId + "/tracks")
                .newBuilder()
                .build();

        Request request = new Request.Builder()
                .url(url)
                .addHeader("Authorization", "Bearer " + mAccessToken)
                .build();

        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Log.e("SpotifyPlayer", "Failed to fetch playlist: " + e.getMessage());
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String responseBody = response.body().string();
                Log.d("SpotifyPlayer", "Playlist fetched: " + responseBody);

                // Parse response and extract first track ID
                String trackId = ""; // Replace with actual track ID

                playTrack(trackId);
            }
        });
    }

    private void playTrack(String trackId) {
        HttpUrl url = HttpUrl.parse(API_BASE_URL + "me/player/play")
                .newBuilder()
                .build();

        String requestBodyJson = "{"
                + "\"uris\": [\"spotify:track:" + trackId + "\"]"
                + "}";

        Request request = new Request.Builder()
                .url(url)
                .addHeader("Authorization", "Bearer " + mAccessToken)
                .post(RequestBody.create(requestBodyJson, MediaType.get("application/json")))
                .build();

        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Log.e("SpotifyPlayer", "Failed to play track: " + e.getMessage());
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                Log.d("SpotifyPlayer", "Track played: " + trackId);
            }
        });
    }
}
