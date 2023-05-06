
import entity.Albums;
import entity.AlbumsGenres;
import entity.Artists;
import entity.Genres;
import repository.GenresRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;


        public class Main {
            public static void main(String[] args) {
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("lab9_compulsory2");
                EntityManager em = emf.createEntityManager();

                // create and persist some entities
                Artists artist1 = new Artists();
                artist1.setName("Pink Floyd");

                Artists artist2 = new Artists();
                artist2.setName("Led Zeppelin");

                Genres genre1 = new Genres();
                genre1.setName("Rock");

                Genres genre2 = new Genres();
                genre2.setName("Prog Rock");

                Albums album1 = new Albums();
                album1.setArtist(artist1);
                album1.setTitle("The Dark Side of the Moon");
                album1.setReleaseYear(1973);
                album1.setGenre(genre2);

                Albums album2 = new Albums();
                album2.setArtist(artist1);
                album2.setTitle("Wish You Were Here");
                album2.setReleaseYear(1975);
                album2.setGenre(genre2);

                Albums album3 = new Albums();
                album3.setArtist(artist2);
                album3.setTitle("Led Zeppelin IV");
                album3.setReleaseYear(1971);
                album3.setGenre(genre1);

                em.getTransaction().begin();
                em.persist(artist1);
                em.persist(artist2);
                em.persist(genre1);
                em.persist(genre2);
                em.persist(album1);
                em.persist(album2);
                em.persist(album3);
                em.getTransaction().commit();
    }
}