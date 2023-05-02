package repository;

import entity.Albums;
import entity.EntityManagerFactorySingleton;

import javax.persistence.*;
import java.util.List;

public class AlbumsRepository {

    private EntityManager entityManager;

    public AlbumsRepository() {

    }

    public void create(Albums album) {
        EntityManagerFactory entityManagerFactory = EntityManagerFactorySingleton.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(album);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    public Albums findById(Long id) {
        EntityManagerFactory entityManagerFactory = EntityManagerFactorySingleton.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Albums albums = entityManager.find(Albums.class, id);
        entityManager.close();
        return albums;
    }
    public List<Albums> findByName(String title) {
        Query query = entityManager.createNamedQuery("Album.findByName", Albums.class);
        query.setParameter("title", "%" + title + "%");
        return query.getResultList();
    }
}
