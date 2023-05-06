import entity.Albums;
import entity.AlbumsGenres;
import entity.Artists;
import entity.Genres;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // create an EntityManagerFactory
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("lab9_compulsory2");

        // create an EntityManager
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // create an instance of the Artists entity and set its properties
        Artists artist1 = new Artists();
        artist1.setName("The Beatles");

        Artists artist2 = new Artists();
        artist2.setName("Queen");

        // create an instance of the Genres entity and set its properties
        Genres genre1 = new Genres();
        genre1.setName("Rock");

        Genres genre2 = new Genres();
        genre2.setName("Pop");

        // create an instance of the Albums entity and set its properties
        Albums album1 = new Albums();
        album1.setReleaseYear(1967);
        album1.setTitle("Sgt. Pepper's Lonely Hearts Club Band");
        album1.setArtist(artist2);
        album1.setGenre(genre1);

        Albums album2 = new Albums();
        album2.setReleaseYear(1975);
        album2.setTitle("A Night at the Opera");
        album2.setArtist(artist1);
        album2.setGenre(genre2);


        // persist the entities to the database
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(artist1);
        entityManager.persist(artist2);
        entityManager.persist(genre1);
        entityManager.persist(genre2);
        entityManager.persist(album1);
        entityManager.persist(album2);
        transaction.commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
