package org.foodeezz.persistance.dao;


import org.foodeezz.persistance.entity.*;
import org.foodeezz.web.formbeans.RestaurantSearchCriteria;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.List;

/**
 * Created by bakhtiar.galib on 2/8/15.
 */


@Repository
@Transactional
public class RestaurantDaoImpl implements RestaurantDao {

    @PersistenceContext
    private EntityManager em;

    public RestaurantDaoImpl() {

    }

    @Override
    public void saveOrUpdate(Restaurant restaurant) {

        if (restaurant.isNew()) {
            em.persist(restaurant);
        } else {
            updateRestaurant(restaurant);
        }
    }

    @Override
    public void updateRestaurant(Restaurant updatedRestaurantInfo) {
        Restaurant restaurant = em.find(Restaurant.class, updatedRestaurantInfo.getId());
        restaurant.update(updatedRestaurantInfo);
    }

    @Override
    public int getPaginationCount(int numberOfResultsPerPage) {
        Query query = em.createQuery("SELECT COUNT(DISTINCT R) FROM Restaurant AS R");

        return (int) Math.ceil(((Long) query.getSingleResult() / (double) numberOfResultsPerPage));
    }

    @Override
    public List<Restaurant> getPaginatedList(int pageNo, int numberOfResultsPerPage) {

        TypedQuery<Restaurant> query = em.createQuery("SELECT DISTINCT R FROM Restaurant AS R ORDER BY R.rating.overall DESC", Restaurant.class);

        query.setFirstResult((pageNo - 1) * numberOfResultsPerPage);
        query.setMaxResults(numberOfResultsPerPage);

        return query.getResultList();
    }

    @Override
    public List<String> getAreaNames() {

        Query query = em.createQuery("SELECT DISTINCT b.area FROM Restaurant AS R JOIN R.branches AS b");
        return query.getResultList();
    }


    @Override
    public List<LatLong> getRestaurantLatLongs(int restaurantId) {
        TypedQuery<LatLong> query = em.createQuery("SELECT DISTINCT branch.latLong FROM Restaurant AS R JOIN R.branches AS branch WHERE R.id = :restaurantId", LatLong.class);
        query.setParameter("restaurantId", restaurantId);
        return query.getResultList();
    }


    @Override
    public int getPaginatedSearchCount(RestaurantSearchCriteria searchCritiria,
                                       int numberOfSearchResultsPerPage) {

        Query query = em.createNativeQuery("" +
                "select COUNT(DISTINCT r.id) from restaurant r " +
                "left join branch b on r.id = b.restaurant_id " +
                "left join restaurant_category cat on cat.id = r.category " +
                "where r.name like :keyword  " +
                "AND ( b.area like :area  OR b.area is null ) " +
                "AND cat.name Like :category"
        );

        query.setParameter("keyword", "%" + searchCritiria.getKeyword() + "%");
        query.setParameter("category", "%" + searchCritiria.getCategory() + "%");
        query.setParameter("area", "%" + searchCritiria.getArea() + "%");

        return (int) Math.ceil(((BigInteger) query.getSingleResult()).doubleValue() / (double) numberOfSearchResultsPerPage);
    }

    @Override
    public List<Restaurant> getPaginatedSearchResult(RestaurantSearchCriteria searchCritiria,
                                                     int pageNo,
                                                     int numberOfResultsPerPage) {

        Query query = em.createNativeQuery(" " +
                        "select DISTINCT r.* from restaurant r " +
                        "left join branch b on r.id = b.restaurant_id " +
                        "left join restaurant_category cat on cat.id = r.category " +
                        "where r.name like :keyword  " +
                        "AND ( b.area like :area  OR b.area is null ) " +
                        "AND cat.name Like :category",
                Restaurant.class);

        query.setParameter("keyword", "%" + searchCritiria.getKeyword() + "%");
        query.setParameter("category", "%" + searchCritiria.getCategory() + "%");
        query.setParameter("area", "%" + searchCritiria.getArea() + "%");

        query.setFirstResult((pageNo - 1) * numberOfResultsPerPage);
        query.setMaxResults(numberOfResultsPerPage);

        return query.getResultList();
    }

    @Override
    public Restaurant getRestaurant(int restaurantId) {
        return em.find(Restaurant.class, restaurantId);
    }


    @Override
    public Restaurant getRestaurantWithAssociations(int restaurantId) {
        Restaurant restaurant = getRestaurant(restaurantId);

        Hibernate.initialize(restaurant.getMenuItems());
        Hibernate.initialize(restaurant.getReviews());
        Hibernate.initialize(restaurant.getBranches());

        return restaurant;
    }

    @Override
    public void removeRestaurant(int restaurantId) {
        em.remove(em.getReference(Restaurant.class, restaurantId));
    }

    private Restaurant getSingleResultOrNull(TypedQuery<Restaurant> query) {
        query.setMaxResults(1);
        List<Restaurant> list = query.getResultList();

        if (list.isEmpty()) {
            return null;
        }

        return list.get(0);
    }
}