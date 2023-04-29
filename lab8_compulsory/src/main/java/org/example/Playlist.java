package org.example;

import java.util.Set;

public class Playlist {
    private int id;
    private String name;
    private Integer creationTime;
    private  String albums;

    public Playlist(int id, String name, Integer creationTime, String albums) {
        this.id = id;
        this.name = name;
        this.creationTime = creationTime;
        this.albums = albums;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public  Integer getCreationTime() {
        return creationTime;
    }

    public void setCreationTime( Integer creationTime) {
        this.creationTime = creationTime;
    }

    public  String getAlbums() {
        return albums;
    }

    public void setAlbums(String albums) {
        this.albums = albums;
    }
}
