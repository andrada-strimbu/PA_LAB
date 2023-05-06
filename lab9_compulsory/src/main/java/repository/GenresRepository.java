package repository;

import entity.Genres;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class GenresRepository implements AbstractRepository<Genres> {
    private final EntityManagerFactory entityManagerFactory;
    private final EntityManager entityManager;

    public GenresRepository() {
        entityManagerFactory = Persistence.createEntityManagerFactory("lab9_compulsory2");
        entityManager = entityManagerFactory.createEntityManager();
    }


    @Override
    public Genres findById(Integer id) {
        return entityManager.find(Genres.class, id);
    }

    @Override
    public List<Genres> findAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Genres> cq = cb.createQuery(Genres.class);
        Root<Genres> rootEntry = cq.from(Genres.class);
        CriteriaQuery<Genres> all = cq.select(rootEntry);
        return entityManager.createQuery(all).getResultList();
    }

    @Override
    public void save(Genres genres) {
        entityManager.getTransaction().begin();
        entityManager.persist(genres);
        entityManager.getTransaction().commit();
    }

    @Override
    public void update(Genres genres) {
        entityManager.getTransaction().begin();
        entityManager.merge(genres);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(Genres genres) {
        entityManager.getTransaction().begin();
        entityManager.remove(genres);
        entityManager.getTransaction().commit();
    }
}
