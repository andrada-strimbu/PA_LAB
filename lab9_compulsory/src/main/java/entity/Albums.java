package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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
    @JoinColumn(name = "artist_id")
    private Artists artist;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "album_genres",
            joinColumns = @JoinColumn(name = "album_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private Set<Genres> genresSet = new HashSet<>();

    public Albums() {
    }

    public Albums(Integer releaseYear, String title, Artists artist) {
        this.releaseYear = releaseYear;
        this.title = title;
        this.artist = artist;
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

    public Set<Genres> getGenresSet() {
        return genresSet;
    }

    public void setGenresSet(Set<Genres> genresSet) {
        this.genresSet = genresSet;
    }

    public void addGenre(Genres genre) {
        this.genresSet.add(genre);
        genre.getAlbumsSet().add(this);
    }
}


