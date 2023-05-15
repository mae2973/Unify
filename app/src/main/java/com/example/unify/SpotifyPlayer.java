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

    //https://accounts.google.com/o/oauth2/v2/auth?response_type=code&access_type=offline&client_id=1046568431490-ij1gi5shcp2gtorls09frkc56d4mjbe2.apps.googleusercontent.com&state=AQBLzLVGLSjhnkWts6gFwtVoAemlboyUQdxL5cS%2F7tMFQ%2BgNlvPxLh4wqXF%2FDpxRk3RilwXmVk59fMjDvusrtq4uSmZ%2BRT8fHezYtFISrqxwvMorNoH6SUk5HEiEz4jRegXL%2BlTDssxYVfbeK%2FKzWql8ccr03TuS0QpifKY7L4FbPBa18jhjagAHQACwsRo5cBamBYwkKcGZq8NT0c1hh8O5%2BVvAE%2BaYTTxIWmNoT8pq%2BuHPLQ7OfKrwoJPiYp1j1euEIJHuW1RWWBN9NnKi4ATyprhawiMOOnw2HmFZtWLHEcvkLt04ozBQd%2Fhhmll7%2Fr8%2FeHYu3IMNtLns%2BAPaP8u9wambMFoKJKJjkHt3%2BoqxxtfWKR9r6YiC1%2FDaSnT9HAS2mJ1pOOqHlDK3a91iiALUcsmuwfpmZAJt5c7U36tcJ93AszEKr3CnRu3wzbkfs6hUtOu%2FBT3KCMKyHtVnaxH4eI9zYkg0uXxdGhHapPpkBmVoQtXMRUuAio%2F%2FBTTj1jnMN4vFVjPe6eJqBnTPd%2Bf01AS6ukt5RmQ8Gz8mo8SvwsACdPyFWtxbQpiuevPOgTiAqsSRo2rzNJbSG4JKi3vrV625yxhtJJMYJkrhU9Domy2%2BIScI81NjHWvBaPt5i5%2FbgxhFffiGwhwBoXDWLpwCm36Vc7eRiiQMsg27GY2%2BX1NYVj%2BQtLDQQJ95HHMyrew9m79shGuqY4gQyQQc%2BIPIxtGuZHIk0lTVPVcsFpS2GaZUMAVIlU2V%2B8DRnfEurtld%2Fil2WKniSZfgW9Rtzpxc7oMQ2NQslqzwpTXUqrcb4sMbeBfStTqLb%2FOWM1wYqM29O%2BL7YvMBkRocInpxJIBK5RDQBXyCAOboZywZ%2BBPH%2FPzPUTWZOev6XwskhYRa9eUP9YkVMJ2vvDD2BfWcamDiOziZa7I%2BKPI3UMfS5GDiSiJJmdbP%2BhrTVWI61PonD7KNeHVbXhVCVMa1G5eeUk7K%2B6U%2BbEEVc%2BIe6ccSUU2ftlm9SthDW5od5IrZml3e2lSBfb8rKlfha4qF5m1qJQ%3D%3D&scope=profile+email+openid&redirect_uri=https%3A%2F%2Faccounts.spotify.com%2Flogin%2Fgoogle%2Fredirect

    private static final String AUTHORIZE = "https://accounts.spotify.com/authorize";
    private static final String TOKEN = "https://accounts.spotify.com/api/token";
    private static final String PLAYLISTS = "https://api.spotify.com/v1/me/playlists";
    private static final String DEVICES = "https://api.spotify.com/v1/me/player/devices";
    private static final String PLAY = "https://api.spotify.com/v1/me/player/play";
    private static final String PAUSE = "https://api.spotify.com/v1/me/player/pause";
    private static final String NEXT = "https://api.spotify.com/v1/me/player/next";
    private static final String PREVIOUS = "https://api.spotify.com/v1/me/player/previous";
    private static final String PLAYER = "https://api.spotify.com/v1/me/player";
    private static final String TRACKS = "https://api.spotify.com/v1/playlists/{{PlaylistId}}/tracks";
    private static final String CURRENTLYPLAYING = "https://api.spotify.com/v1/me/player/currently-playing";
    private static final String SHUFFLE = "https://api.spotify.com/v1/me/player/shuffle";

    private static final String CLIENT_ID = "9ef8387d89894e118397248505847c47";
    private static final String REDIRECT_URI = "my-app://callback";
    private static final String API_BASE_URL = "https://api.spotify.com/v1/";
    private static final String PLAYLIST_ID = "37i9dQZF1DWZ3ZJIiIfKXn?si=65a9869f88da4f40";

    private OkHttpClient mOkHttpClient;
    private String mAccessToken;

    private String okaze = null;
    private String deviceId = "ef83a9c20792c8d97a210b9f7e7b8f349acd9d2e";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAccessToken = getIntent().getStringExtra("accessToken");
        Log.e("lol", mAccessToken);
        mOkHttpClient = new OkHttpClient();

        searchTrack("CARNIVORE");
        while(okaze == null) {};

        //playTrack("6MtW3gaINk8l0AKTVTR0Rg?si=c9ee6b1112be4034");
        //getAvailableDevices();
        //playTrackOnDevice("6MtW3gaINk8l0AKTVTR0Rg?si=c9ee6b1112be4034","ef83a9c20792c8d97a210b9f7e7b8f349acd9d2e");
        addToQueue("6MtW3gaINk8l0AKTVTR0Rg?si=c9ee6b1112be4034");
        pause();
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
                .addHeader("device_id", "ef83a9c20792c8d97a210b9f7e7b8f349acd9d2e")
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

    private void searchTrack(String query) {
        HttpUrl url = HttpUrl.parse(API_BASE_URL + "search")
                .newBuilder()
                .addQueryParameter("q", query)
                .addQueryParameter("type", "track")
                .build();

        Request request = new Request.Builder()
                .url(url)
                .addHeader("Authorization", "Bearer " + mAccessToken)
                .build();

        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Log.e("SpotifyPlayer", "Failed to search track: " + e.getMessage());
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String responseBody = response.body().string();
                Log.d("SpotifyPlayer", "Track search results: " + responseBody);

                // Parse response and extract first track ID
                String trackId = ""; // Replace with actual track ID

                playTrack(trackId);
            }
        });
    }
    private void getAvailableDevices() {
        HttpUrl url = HttpUrl.parse(API_BASE_URL + "me/player/devices")
                .newBuilder()
                .build();

        Request request = new Request.Builder()
                .url(url)
                .addHeader("Authorization", "Bearer " + mAccessToken)
                .build();

        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Log.e("SpotifyPlayer", "Failed to get available devices: " + e.getMessage());
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String responseBody = response.body().string();
                Log.d("SpotifyPlayer", "Available devices: " + responseBody);

                // Parse response and extract available devices
                // ...
            }
        });
    }

    private void playTrackOnDevice(String trackId, String deviceId) {
        HttpUrl url = HttpUrl.parse(API_BASE_URL + "me/player/play")
                .newBuilder()
                .build();

        String requestBodyJson = "{"
                + "\"uris\": [\"spotify:track:" + trackId + "\"],"
                + "\"device_id\": \"" + deviceId + "\""
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
                Log.d("SpotifyPlayer", "Track played on device: " + deviceId + ", track ID: " + trackId);
            }
        });
    }

    private void addToQueue(String trackId) {
        HttpUrl url = HttpUrl.parse(API_BASE_URL + "me/player/queue")
                .newBuilder()
                .addQueryParameter("uri", "spotify:track:" + trackId)
                .build();

        Request request = new Request.Builder()
                .url(url)
                .addHeader("Authorization", "Bearer " + mAccessToken)
                .post(RequestBody.create(new byte[0]))
                .build();

        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Log.e("SpotifyPlayer", "Failed to add track to queue: " + e.getMessage());
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                Log.d("SpotifyPlayer", "Track added to queue: " + trackId);
            }
        });
    }

    private void callApi(String method, String url, String body, Callback callback) {
        Request request = new Request.Builder()
                .url(url)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer " + mAccessToken)
                .method(method, body != null ? RequestBody.create(body, MediaType.get("application/json")) : null)
                .build();

        mOkHttpClient.newCall(request).enqueue(callback);
    }

    private void pause() {
        callApi("PUT", PLAY + "?device_id=" + deviceId, null, new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Log.e("SpotifyPlayer", "Failed to pause: " + e.getMessage());
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                Log.d("SpotifyPlayer", "Paused playback");
            }
        });
    }
    /*public void callApi(String method, String urlStr, String body, final Runnable callback) {
        String access_token = mAccessToken;
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(urlStr);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod(method);
                    conn.setRequestProperty("Content-Type", "application/json");
                    conn.setRequestProperty("Authorization", "Bearer " + access_token);

                    if (body != null && !body.isEmpty()) {
                        conn.setDoOutput(true);
                        OutputStream os = conn.getOutputStream();
                        byte[] input = body.getBytes("utf-8");
                        os.write(input, 0, input.length);
                    }

                    conn.connect();

                    if (conn.getResponseCode() != 200) {
                        throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
                    }

                    callback.run();

                    conn.disconnect();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }*/

    /*public void handleApiResponse(int responseCode, String responseText) {
        switch (responseCode) {
            case 200:
                Log.d("Response", responseText);
                // Vous pouvez remplacer ceci avec votre méthode pour récupérer l'état de lecture en cours
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        currentlyPlaying();
                    }
                }, 2000);
                break;
            case 204:
                // Vous pouvez remplacer ceci avec votre méthode pour récupérer l'état de lecture en cours
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        currentlyPlaying();
                    }
                }, 2000);
                break;
            case 401:
                refreshAccessToken();
                break;
            default:
                Log.d("Response", responseText);
                //Toast.makeText(context, responseText, Toast.LENGTH_LONG).show();
                break;
        }
    }*/

    /*public void currentlyPlaying() {
        String market = "US";
        String url = PLAYER + "?market=" + market;
        callApi("GET", url, null, new Callback() {
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                handleApiResponse(response.code(), response.body().string());
            }

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }
        });
    }*/

    /*//private static final String CLIENT_ID = "your_client_id";
    private static final String REFRESH_TOKEN_KEY = "refresh_token";

    public void refreshAccessToken(Context context) {
        SharedPreferences sharedPref = context.getSharedPreferences(
                "app_preferences", Context.MODE_PRIVATE);
        String refreshToken = sharedPref.getString(REFRESH_TOKEN_KEY, null);

        if (refreshToken != null) {
            String body = "grant_type=refresh_token"
                    + "&refresh_token=" + refreshToken
                    + "&client_id=" + CLIENT_ID;
            callAuthorizationApi(body);
        } else {
            // Handle error: No refresh token found
        }
    }*/


}
