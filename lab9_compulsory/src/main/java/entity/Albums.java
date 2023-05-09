package entity;

import javax.persistence.*;
import java.util.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "Album.findAll",
                query = "select e from Albums e order by e.title"),
        @NamedQuery(name = "Album.findByArtist",
                query = "select e from Albums e where e.artist = ?1"),
        @NamedQuery(name = "Albums.findByTitle",
                query = "select a from Albums a where a.title = :title")
})

@Table(name = "albums", schema = "public", catalog = "lab8")
public class Albums {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "release_year")
    private Integer releaseYear;

    @Column(name = "title")
    private String title;
    @ManyToOne
    @JoinColumn(name = "artist")
    private Artists artist;

    @ManyToOne
    @JoinColumn(name = "genre")
    private Genres genre;


    public Albums(Integer id, Integer releaseYear,Artists artist, String title, Genres genre) {
        this.id = id;
        this.releaseYear = releaseYear;
        this.title = title;
        this.artist=artist;
        this.genre = genre;
    }

    public Albums() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public Artists getArtist() {
        return artist;
    }

    public void setArtist(Artists artist) {
        this.artist = artist;
    }

    public Genres getGenre() {
        return genre;
    }

    public void setGenre(Genres genre) {
        this.genre = genre;
    }
}