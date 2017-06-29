package org.foodeezz.service;

import org.foodeezz.persistance.dao.RestaurantReviewDao;
import org.foodeezz.persistance.entity.RestaurantReview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by GALIB on 4/24/2015.
 */
@Service
@Transactional
public class RestaurantReviewService {

    @Autowired
    private RestaurantReviewDao restaurantReviewDao;

    public void addReview(RestaurantReview restaurantReview){
         restaurantReviewDao.addReview(restaurantReview);
    }

    public void removeReview(int restaurantReviewId){
        restaurantReviewDao.removeReview(restaurantReviewId);
    }

    public RestaurantReview getReview(int id){
        return restaurantReviewDao.getReview(id);
    }
}
