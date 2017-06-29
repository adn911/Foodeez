package org.foodeezz.service;

import org.foodeezz.persistance.dao.RestaurantDao;
import org.foodeezz.persistance.entity.LatLong;
import org.foodeezz.persistance.entity.Restaurant;
import org.foodeezz.web.formbeans.RestaurantSearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by GALIB on 4/24/2015.
 */
@Service
@Transactional
public class RestaurantService {

    @Autowired
    private RestaurantDao restaurantDao;

    public RestaurantService(){

    }

    public void saveOrUpdate(Restaurant restaurant){
        restaurantDao.saveOrUpdate(restaurant);
    }

    public void updateRestaurant(Restaurant updatedRestaurantInfo){
        restaurantDao.updateRestaurant(updatedRestaurantInfo);
    }

    public List<Restaurant> getRestaurantSearchResult(RestaurantSearchCriteria searchCritiria, int pageNo,int numberOfResultsPerPage){
        return restaurantDao.getPaginatedSearchResult(searchCritiria, pageNo,numberOfResultsPerPage);
    }

    public List<Restaurant> getPaginatedList(int pageNo, int numberOfResultsPerPage){
        return restaurantDao.getPaginatedList(pageNo, numberOfResultsPerPage);
    }


    public List<LatLong> getRestaurantLatLongs(int restaurantId) {
        return restaurantDao.getRestaurantLatLongs(restaurantId);
    }

    public Restaurant getRestaurant(int restaurantId){
        return restaurantDao.getRestaurant(restaurantId);
    }

    public Restaurant getRestaurantWithAssociations(int restaurantId){
        return restaurantDao.getRestaurantWithAssociations(restaurantId);
    }

    public void removeRestaurant(int restaurantId){
        restaurantDao.removeRestaurant(restaurantId);
    }

    public List<String> getAllAreaNames() {
        return restaurantDao.getAreaNames();
    }

    public int getNumberOfAllResultPages(int numberOfResultsPerPage) {
        return restaurantDao.getPaginationCount(numberOfResultsPerPage);
    }

    public int getNumberOfSearchResultPages(RestaurantSearchCriteria searchCritiria, int numberOfResultsPerPage) {
        return restaurantDao.getPaginatedSearchCount(searchCritiria, numberOfResultsPerPage);
    }

}
