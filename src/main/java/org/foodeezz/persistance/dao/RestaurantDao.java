package org.foodeezz.persistance.dao;

import org.foodeezz.persistance.entity.*;
import org.foodeezz.web.formbeans.RestaurantSearchCriteria;

import java.util.List;

/**
 * Created by bakhtiar.galib on 2/8/15.
 */
public interface RestaurantDao {

    void saveOrUpdate(Restaurant restaurant);

    void updateRestaurant(Restaurant updatedRestaurantInfo);

    Restaurant getRestaurant(int restaurantId);

    Restaurant getRestaurantWithAssociations(int restaurantId);

    void removeRestaurant(int restaurantId);

    List<Restaurant> getPaginatedList(int pageNo, int numberOfResultsPerPage);

    List<Restaurant> getPaginatedSearchResult(RestaurantSearchCriteria searchCritiria, int pageNo, int numberOfResultsPerPage);

    List<String> getAreaNames();

    List<LatLong> getRestaurantLatLongs(int restaurantId);

    int getPaginationCount(int numberOfResultsPerPage);

    int getPaginatedSearchCount(RestaurantSearchCriteria searchCritiria, int numberOfResultsPerPage);
}
