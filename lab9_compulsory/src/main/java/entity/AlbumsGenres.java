package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "album_genres")
public class AlbumsGenres {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "album_id")
    private Albums album;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genre_id")
    private Genres genre;

    public AlbumsGenres() {}

    public AlbumsGenres(Albums album, Genres genre) {
        this.album = album;
        this.genre = genre;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Albums getAlbum() {
        return album;
    }

    public void setAlbum(Albums album) {
        this.album = album;
    }

    public Genres getGenre() {
        return genre;
    }

    public void setGenre(Genres genre) {
        this.genre = genre;
    }




}
