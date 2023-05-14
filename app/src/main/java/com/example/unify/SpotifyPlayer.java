package com.example.unify;

import android.content.Context;
import android.util.Log;

import com.spotify.android.appremote.api.ConnectionParams;
import com.spotify.android.appremote.api.Connector;
import com.spotify.android.appremote.api.SpotifyAppRemote;
import com.spotify.android.appremote.api.error.AuthenticationFailedException;
import com.spotify.android.appremote.api.error.CouldNotFindSpotifyApp;
import com.spotify.android.appremote.api.error.NotLoggedInException;
import com.spotify.android.appremote.api.error.SpotifyConnectionTerminatedException;
import com.spotify.protocol.client.Subscription;
import com.spotify.protocol.types.PlayerState;
import com.spotify.protocol.types.Track;

public class SpotifyPlayer {

    private static final String CLIENT_ID = "your_client_id";
    private static final String REDIRECT_URI = "your_redirect_uri";
    private static final String TAG = "SpotifyPlayer";
    private static final String SPOTIFY_PACKAGE_NAME = "com.spotify.music";

    private SpotifyAppRemote mSpotifyAppRemote;

    public void connectToSpotify(Context context, String accessToken) {
        ConnectionParams connectionParams = new ConnectionParams.Builder(CLIENT_ID)
                .setRedirectUri(REDIRECT_URI)
                .setAccessToken(accessToken)
                .build();

        SpotifyAppRemote.connect(context, connectionParams, new Connector.ConnectionListener() {
            @Override
            public void onConnected(SpotifyAppRemote spotifyAppRemote) {
                mSpotifyAppRemote = spotifyAppRemote;
                Log.d(TAG, "Connected to Spotify");

                // Start playing a playlist
                mSpotifyAppRemote.getPlayerApi().play("spotify:playlist:37i9dQZF1DWZeAduKwuwrr");

                // Subscribe to player state changes
                Subscription<PlayerState> playerStateSubscription =
                        mSpotifyAppRemote.getPlayerApi().subscribeToPlayerState().setEventCallback(playerState -> {
                            final Track track = playerState.track;
                            if (track != null) {
                                Log.d(TAG, track.name + " by " + track.artist.name);
                            }
                        });
            }

            @Override
            public void onFailure(Throwable throwable) {
                Log.e(TAG, "Error connecting to Spotify: " + throwable.getMessage());
                if (throwable instanceof AuthenticationFailedException) {
                    // Authentication failed!
                } else if (throwable instanceof CouldNotFindSpotifyApp) {
                    // Spotify app not installed or not launched
                } else if (throwable instanceof Exception) {
                    // User logged out of Spotify
                } else if (throwable instanceof NotLoggedInException) {
                    // User not logged in to Spotify
                } else if (throwable instanceof SpotifyConnectionTerminatedException) {
                    // Connection to Spotify app was terminated
                }
            }
        });
    }

    public void disconnectFromSpotify() {
        SpotifyAppRemote.disconnect(mSpotifyAppRemote);
    }

}