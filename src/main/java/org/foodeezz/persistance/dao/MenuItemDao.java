package org.foodeezz.persistance.dao;

import org.foodeezz.persistance.entity.MenuItem;
import org.foodeezz.web.formbeans.MenuItemSearchCriteria;

import java.util.List;

/**
 * Created by bakhtiar.galib on 2/8/15.
 */
public interface MenuItemDao {

    void addMenuItem(MenuItem menuItem);

    void updateMenuItem(MenuItem updatedMenuItemInfo);

    List<MenuItem> getAllMenuItems(int pageNo, int numberOfResultsPerPage);

    List<MenuItem> getRestaurantMenuItems(int id);

    MenuItem getMenuItem(int menuItemId);

    MenuItem getMenuItemWithAssociations(int menuItemId);

    List<MenuItem> getMenuItemsSearchResult(MenuItemSearchCriteria searchCritiria, int pageNo, int numberOfResultsPerPage);

    void removeMenuItem(int menuItemId);

    int getNumberOfSearchResultPages(MenuItemSearchCriteria searchCritiria, int numberOfResultsPerPage);

    int getNumberOfAllResultPages(int numberOfResultsPerPage);
}
