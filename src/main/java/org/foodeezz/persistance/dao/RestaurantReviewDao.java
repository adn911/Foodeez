package org.foodeezz.persistance.dao;

import org.foodeezz.persistance.entity.RestaurantReview;

/**
 * Created by bakhtiar.galib on 2/8/15.
 */
public interface RestaurantReviewDao {

    void addReview(RestaurantReview restaurantReview);

    RestaurantReview getReview(int id);

    void removeReview(int reviewId);
}
