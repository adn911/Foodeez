package org.foodeezz.persistance.dao;


import org.foodeezz.persistance.entity.MenuItem;
import org.foodeezz.persistance.entity.Restaurant;
import org.foodeezz.persistance.entity.User;
import org.foodeezz.web.formbeans.MenuItemSearchCriteria;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;


/**
 * Created by bakhtiar.galib on 2/8/15.
 */


@Repository
@Transactional
public class MenuItemDaoImpl implements MenuItemDao {

    @PersistenceContext
    private EntityManager entityManager;

    public MenuItemDaoImpl() {

    }

    @Override
    public void addMenuItem(MenuItem menuItem) {

        entityManager.persist(menuItem);
    }

    @Override
    public void updateMenuItem(MenuItem updatedMenuItemInfo) {
        MenuItem menuItem = entityManager.find(MenuItem.class, updatedMenuItemInfo.getId());
        menuItem.update(updatedMenuItemInfo);
    }

    @Override
    public List<MenuItem> getAllMenuItems(int pageNo, int numberOfResultsPerPage) {

        TypedQuery<MenuItem> query = entityManager.createQuery("SELECT item FROM MenuItem AS item ORDER BY item.rating.overall DESC ", MenuItem.class);

        query.setFirstResult((pageNo - 1) * numberOfResultsPerPage);
        query.setMaxResults(numberOfResultsPerPage);

        return query.getResultList();
    }

    @Override
    public List<MenuItem> getRestaurantMenuItems(int id) {
        return entityManager.find(Restaurant.class, id).getMenuItems();
    }

    @Override
    public MenuItem getMenuItem(int menuItemId) {
        return entityManager.find(MenuItem.class, menuItemId);
    }

    @Override
    public MenuItem getMenuItemWithAssociations(int menuItemId) {
        MenuItem menuItem = entityManager.find(MenuItem.class, menuItemId);
        Hibernate.initialize(menuItem.getReviews());
        return menuItem;
    }

    @Override
    public int getNumberOfSearchResultPages(MenuItemSearchCriteria searchCritiria, int numberOfResultsPerPage) {

        Query query = entityManager.createQuery(
                "SELECT COUNT(DISTINCT item) " +
                        "FROM MenuItem AS item " +
                        "WHERE item.name LIKE :itemName " +
                        "AND item.price BETWEEN :minPrice AND :maxPrice"
        );

        query.setParameter("itemName", "%" + searchCritiria.getItem() + "%");
        query.setParameter("minPrice", searchCritiria.getMinPrice());
        query.setParameter("maxPrice", searchCritiria.getMaxPrice());

        return (int) Math.ceil(((Long) query.getSingleResult() / (double) numberOfResultsPerPage));
    }

    @Override
    public int getNumberOfAllResultPages(int numberOfResultsPerPage) {

        Query query = entityManager.createQuery(" SELECT COUNT(DISTINCT item) FROM MenuItem AS item");

        return (int) Math.ceil(((Long) query.getSingleResult() / (double) numberOfResultsPerPage));
    }

    @Override
    public List<MenuItem> getMenuItemsSearchResult(MenuItemSearchCriteria searchCritiria, int pageNo, int numberOfResultsPerPage) {

        TypedQuery<MenuItem> query = entityManager.createQuery(
                "SELECT item FROM MenuItem AS item " +
                        "WHERE item.name LIKE :itemName " +
                        "AND item.price BETWEEN :min AND :max " +
                        "ORDER BY item.rating.overall DESC", MenuItem.class);

        query.setParameter("itemName", "%" + searchCritiria.getItem() + "%");
        query.setParameter("min", searchCritiria.getMinPrice());
        query.setParameter("max", searchCritiria.getMaxPrice());

        query.setFirstResult((pageNo - 1) * numberOfResultsPerPage);
        query.setMaxResults(numberOfResultsPerPage);

        return query.getResultList();
    }

    @Override
    public void removeMenuItem(int menuItemId) {

        entityManager.remove(entityManager.getReference(MenuItem.class, menuItemId));
    }

    private User getSingleResultOrNull(TypedQuery<User> query) {
        query.setMaxResults(1);
        List<User> list = query.getResultList();

        if (list.isEmpty()) {
            return null;
        }

        return list.get(0);
    }
}