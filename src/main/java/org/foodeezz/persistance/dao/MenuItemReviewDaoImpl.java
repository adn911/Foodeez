package org.foodeezz.persistance.dao;


import org.foodeezz.persistance.entity.*;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 * Created by bakhtiar.galib on 2/8/15.
 */


@Repository
@Transactional
public class MenuItemReviewDaoImpl implements MenuItemReviewDao {

    @PersistenceContext
    private EntityManager entityManager;

    public MenuItemReviewDaoImpl() {

    }

    @Override
    public void addReview(MenuItemReview menuItemReview) {
        entityManager.persist(menuItemReview);
        entityManager.getReference(MenuItem.class, menuItemReview.getMenuItem().getId()).updateRating(menuItemReview.getRating());
    }

    @Override
    public MenuItemReview getReview(int id) {
        return entityManager.find(MenuItemReview.class, id);
    }


    @Override
    public void removeReview(int reviewId) {
        entityManager.remove(entityManager.getReference(MenuItemReview.class, reviewId));
    }

}