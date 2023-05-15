package repository;

import entity.Albums;
import org.junit.jupiter.api.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AlbumRepositoryTest {
    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;
    private AlbumsRepository albumsRepository;

    @BeforeAll
    public static void setUp() {
        entityManagerFactory = Persistence.createEntityManagerFactory("lab9_compulsory2");
        entityManager = entityManagerFactory.createEntityManager();
    }

    @BeforeEach
    public void init() {
        albumsRepository = new AlbumsRepository();
    }

    @AfterAll
    public static void tearDown() {
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    public void testCreateAlbum() {
        // Create a test album
        Albums album = new Albums();
        album.setTitle("Test Album");
        album.setReleaseYear(2023);

        // Create the album using the repository
        Albums createdAlbum = albumsRepository.createAlbum(album);

        // Verify that the album is created and has a valid ID
        assertNotNull(createdAlbum.getId());

        // Retrieve the album from the database using the EntityManager
        Albums retrievedAlbum = entityManager.find(Albums.class, createdAlbum.getId());

        // Verify that the retrieved album matches the created album
        assertEquals(createdAlbum.getTitle(), retrievedAlbum.getTitle());
        assertEquals(createdAlbum.getReleaseYear(), retrievedAlbum.getReleaseYear());
    }


    @Test
    public void testSave() {
        // Create a test album
        Albums album = new Albums();
        album.setTitle("Test Album");
        album.setReleaseYear(2023);

        // Save the album using the repository
        albumsRepository.save(album);

        // Retrieve the album from the database using the EntityManager
        Albums retrievedAlbum = entityManager.find(Albums.class, album.getId());

        // Verify that the retrieved album is not null and matches the saved album
        assertNotNull(retrievedAlbum);
        assertEquals(album.getTitle(), retrievedAlbum.getTitle());
        assertEquals(album.getReleaseYear(), retrievedAlbum.getReleaseYear());
    }

}
