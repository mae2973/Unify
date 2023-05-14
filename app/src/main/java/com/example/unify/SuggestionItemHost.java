package com.example.unify;

public class SuggestionItemHost {
    private final int icon;
    private User user ;
    private Song song ;

    public SuggestionItemHost(int icon, User user, Song song) {
        this.icon = icon;
        this.user = user;
        this.song = song;
    }

    public int getIcon() {
        return icon;
    }

    public User getUser() {
        return user;
    }

    public Song getSong() {
        return song;
    }
}
