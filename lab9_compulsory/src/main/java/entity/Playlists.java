package entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Playlists {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "created_at")
    private Date createdAt;
    @Basic
    @Column(name = "album")
    private Integer album;

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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getAlbum() {
        return album;
    }

    public void setAlbum(Integer album) {
        this.album = album;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Playlists playlists = (Playlists) o;
        return id == playlists.id && Objects.equals(name, playlists.name) && Objects.equals(createdAt, playlists.createdAt) && Objects.equals(album, playlists.album);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, createdAt, album);
    }
}
