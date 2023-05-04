package entity;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "genres", schema = "public", catalog = "lab8")
public class Genres {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "genresSet", fetch = FetchType.LAZY)
    private Set<Albums> albumsSet = new HashSet<>();

    public Genres() {
    }

    public Genres(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Albums> getAlbumsSet() {
        return albumsSet;
    }

    public void setAlbumsSet(Set<Albums> albumsSet) {
        this.albumsSet = albumsSet;
    }


}
