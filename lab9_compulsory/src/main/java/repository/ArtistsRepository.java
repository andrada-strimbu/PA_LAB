package repository;

import entity.Artists;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class ArtistsRepository implements AbstractRepository<Artists> {
    private final EntityManagerFactory entityManagerFactory;
    private final EntityManager entityManager;

    public ArtistsRepository() {
        entityManagerFactory = Persistence.createEntityManagerFactory("MyPersistenceUnit");
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public Artists findById(Integer id) {
        return entityManager.find(Artists.class, id);
    }

    @Override
    public List<Artists> findAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Artists> cq = cb.createQuery(Artists.class);
        Root<Artists> rootEntry = cq.from(Artists.class);
        CriteriaQuery<Artists> all = cq.select(rootEntry);
        return entityManager.createQuery(all).getResultList();
    }

    @Override
    public void save(Artists artists) {
        entityManager.getTransaction().begin();
        entityManager.persist(artists);
        entityManager.getTransaction().commit();
    }

    @Override
    public void update(Artists artists) {
        entityManager.getTransaction().begin();
        entityManager.merge(artists);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(Artists artists) {
        entityManager.getTransaction().begin();
        entityManager.remove(artists);
        entityManager.getTransaction().commit();
    }
}
