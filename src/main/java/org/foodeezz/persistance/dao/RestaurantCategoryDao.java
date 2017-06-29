package org.foodeezz.persistance.dao;

import org.foodeezz.persistance.entity.RestaurantCategory;

import java.util.List;

/**
 * Created by bakhtiar.galib on 2/8/15.
 */
public interface RestaurantCategoryDao {

    void addCategory(RestaurantCategory restaurantCategory);

    void removeCategory(RestaurantCategory restaurantCategory);

    List<RestaurantCategory> getAllCategories();

    RestaurantCategory getCategory(int categoryId);
}
