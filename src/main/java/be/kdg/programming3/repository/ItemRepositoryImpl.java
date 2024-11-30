package be.kdg.programming3.repository;

import be.kdg.programming3.domain.Item;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemRepositoryImpl implements ItemRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Item> findByCategory(String category) {
        return List.of();
    }

    @Override
    public List<Item> findByNameContaining(String name) {
        return List.of();
    }

    @Override
    public List<String> getCategories() {
        return em.createQuery("SELECT i.category FROM Item i GROUP BY i.category", String.class).getResultList();
    }
}
