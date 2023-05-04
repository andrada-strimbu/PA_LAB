package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "artists", schema = "public", catalog = "lab8")
public class Artists {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Id
    @Column(name = "name")
    private String name;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artists artists = (Artists) o;
        return id == artists.id && Objects.equals(name, artists.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
