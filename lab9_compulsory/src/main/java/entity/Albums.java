package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Album.findAll",
                query = "select e from Albums e order by e.title"),
        @NamedQuery(name = "Album.findByArtist",
                query = "select e from Albums e where e.artist = ?1"),
        @NamedQuery(name = "Albums.findByTitle",
                query = "select a from Albums a where a.title = :title")
})
public class Albums {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "release_year")
    private Integer releaseYear;
    @Basic
    @Column(name = "title")
    private String title;
    @Basic
    @Column(name = "artist")
    private String artist;
    @Basic
    @Column(name = "genre")
    private String genre;

    public Albums(int id,Integer releaseYear, String title, String artist, String genre) {
        this.id=id;
        this.releaseYear = releaseYear;
        this.title = title;
        this.artist = artist;
        this.genre = genre;
    }

    public Albums() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Albums albums = (Albums) o;
        return id == albums.id && Objects.equals(releaseYear, albums.releaseYear) && Objects.equals(title, albums.title) && Objects.equals(artist, albums.artist) && Objects.equals(genre, albums.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, releaseYear, title, artist, genre);
    }
}
