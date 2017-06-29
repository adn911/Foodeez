package org.foodeezz.persistance.dao;


import org.foodeezz.persistance.entity.Restaurant;
import org.foodeezz.persistance.entity.RestaurantReview;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 * Created by bakhtiar.galib on 2/8/15.
 */


@Repository
@Transactional
public class RestaurantReviewDaoImpl implements RestaurantReviewDao {

    private static final Logger log = LoggerFactory.getLogger(RestaurantReviewDaoImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    public RestaurantReviewDaoImpl() {

    }

    @Override
    public void addReview(RestaurantReview restaurantReview) {
        entityManager.persist(restaurantReview);
        entityManager.getReference(Restaurant.class, restaurantReview.getRestaurant().getId()).updateRating(restaurantReview.getRating());
    }

    @Override
    public RestaurantReview getReview(int id) {
        return entityManager.find(RestaurantReview.class, id);
    }

    @Override
    public void removeReview(int reviewId) {
        entityManager.remove(entityManager.getReference(RestaurantReview.class, reviewId));
    }
}