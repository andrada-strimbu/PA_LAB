package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "albums_genres", schema = "public", catalog = "lab8")
public class AlbumsGenres {
    @Basic
    @Column(name = "album_id")
    private int albumId;
    @Basic
    @Column(name = "genre_id")
    private int genreId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlbumsGenres that = (AlbumsGenres) o;
        return albumId == that.albumId && genreId == that.genreId && id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(albumId, genreId, id);
    }
}
