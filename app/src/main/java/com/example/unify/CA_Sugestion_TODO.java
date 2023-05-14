package com.example.unify;

// Suggestion GUEST !!
public class CA_Sugestion_TODO {
    private final int icon;
    private User user ;
    private Song song ;

    public CA_Sugestion_TODO(User user, int icon, Song song) {
        this.user = user;
        this.icon = icon;
        this.song = song;
    }

    public User getUser() {
        return user;
    }

    public int getIcon() {
        return icon;
    }

    public Song getSong() {
        return song;
    }
}

