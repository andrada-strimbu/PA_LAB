package org.example;

public class AlbumGenres {
    private Integer id;
    private Integer album_id;
    private Integer genre_id;

    public AlbumGenres(Integer id, Integer artist_id, Integer genre_id) {
        this.id = id;
        this.album_id = artist_id;
        this.genre_id = genre_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAlbum_id() {
        return album_id;
    }

    public void setAlbum_id(Integer album_id) {
        this.album_id = album_id;
    }

    public Integer getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(Integer genre_id) {
        this.genre_id = genre_id;
    }
}
