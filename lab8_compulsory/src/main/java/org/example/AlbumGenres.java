package org.example;

public class AlbumGenres {
    private Integer id;
    private Integer artist_id;
    private Integer genre_id;

    public AlbumGenres(Integer id, Integer artist_id, Integer genre_id) {
        this.id = id;
        this.artist_id = artist_id;
        this.genre_id = genre_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getArtist_id() {
        return artist_id;
    }

    public void setArtist_id(Integer artist_id) {
        this.artist_id = artist_id;
    }

    public Integer getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(Integer genre_id) {
        this.genre_id = genre_id;
    }
}
