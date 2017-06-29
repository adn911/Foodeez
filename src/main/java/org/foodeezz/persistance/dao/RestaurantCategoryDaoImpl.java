package org.foodeezz.persistance.dao;

import org.foodeezz.persistance.entity.RestaurantCategory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by GALIB on 4/25/2015.
 */
@Repository
@Transactional
public class RestaurantCategoryDaoImpl implements RestaurantCategoryDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void addCategory(RestaurantCategory restaurantCategory) {
        em.persist(restaurantCategory);
    }

    @Override
    public void removeCategory(RestaurantCategory restaurantCategory) {
        em.remove(restaurantCategory);
    }

    @Override
    public List<RestaurantCategory> getAllCategories() {
        return em.createQuery("SELECT c FROM RestaurantCategory AS c", RestaurantCategory.class).getResultList();
    }

    @Override
    public RestaurantCategory getCategory(int id) {
        return em.find(RestaurantCategory.class, id);
    }
}
