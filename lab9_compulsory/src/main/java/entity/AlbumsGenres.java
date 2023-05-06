package entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "albums_genres")
public class AlbumsGenres implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="artist_id")
    private Integer artist_id;

    @Column(name="genre_id")
    private Integer genre_id;

    public AlbumsGenres() {
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



}
