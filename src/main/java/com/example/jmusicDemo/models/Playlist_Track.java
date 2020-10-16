package com.example.jmusicDemo.models;

public class Playlist_Track {
    private int trackId;
    private int playlistId;

    public int getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(int playlistId) {
        this.playlistId = playlistId;
    }

    public int getTrackId() {
        return trackId;
    }

    public void setTrackId(int trackId) {
        this.trackId = trackId;
    }

    public Playlist_Track(int playlistId, int trackId) {
        this.playlistId = playlistId;
        this.trackId = trackId;
    }

}
