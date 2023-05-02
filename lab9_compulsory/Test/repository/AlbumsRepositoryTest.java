package repository;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entity.Albums;
import repository.AlbumsRepository;

public class AlbumsRepositoryTest {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private AlbumsRepository albumsRepository;
    private Albums album;

    @BeforeEach
    public void setUp() {
        entityManagerFactory = Persistence.createEntityManagerFactory("lab9_compulsory2");
        entityManager = entityManagerFactory.createEntityManager();
        albumsRepository = new AlbumsRepository();
        album = new Albums();
        album.setTitle("Abbey Road");
        album.setArtist("The Beatles");
        album.setReleaseYear(1969);
        albumsRepository.create(album);
    }

    @AfterEach
    public void tearDown() {
        entityManager.getTransaction().begin();
        entityManager.remove(album);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    public void testCreate() {
        assertNotNull(album.getId());
        assertEquals("Abbey Road", album.getTitle());
        assertEquals("The Beatles", album.getArtist());
        assertEquals(1969, album.getReleaseYear());
    }

    @Test
    public void testFindById() {
        Albums result = albumsRepository.findById((long) album.getId());
        assertEquals(album, result);
    }

    @Test
    public void testFindByName() {
        List<Albums> results = albumsRepository.findByName("Abbey");
        assertEquals(1, results.size());
        assertEquals(album, results.get(0));
    }
}

