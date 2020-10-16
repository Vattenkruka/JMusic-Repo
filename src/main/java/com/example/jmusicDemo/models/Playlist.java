package com.example.jmusicDemo.models;

public class Playlist {

    private int playlistId;
    private int name;

    public int getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(int playlistId) {
        this.playlistId = playlistId;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public Playlist(int playlistId, int name) {
        this.playlistId = playlistId;
        this.name = name;
    }
}
