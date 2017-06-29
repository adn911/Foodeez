package org.foodeezz.service;

import org.foodeezz.persistance.dao.MenuItemDao;
import org.foodeezz.persistance.entity.MenuItem;
import org.foodeezz.web.formbeans.MenuItemSearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by GALIB on 4/24/2015.
 */
@Service
@Transactional
public class MenuItemService {

    @Autowired
    private MenuItemDao menuItemDao;

    public MenuItemService(){

    }

    public void addMenuItem(MenuItem menuItem){
        menuItemDao.addMenuItem(menuItem);
    }

    public List<MenuItem> getAllMenuItems(int pageNo, int numberOfResultsPerPage){

        return menuItemDao.getAllMenuItems(pageNo, numberOfResultsPerPage);
    }


    public MenuItem getMenuItem(int menuItemId){

        return menuItemDao.getMenuItem(menuItemId);
    }

    public MenuItem getMenuItemWithAssociations(int menuItemId){

        return menuItemDao.getMenuItemWithAssociations(menuItemId);
    }

    public void removeMenuItem(int menuItemId){
        menuItemDao.removeMenuItem(menuItemId);
    }

    public void updateMenuItem(MenuItem updatedMenuItemInfo) {
        menuItemDao.updateMenuItem(updatedMenuItemInfo);
    }

    public List<MenuItem> getMenuItemsSearchResult(MenuItemSearchCriteria menuItemSearchCriteria,int pageNo, int numberOfResultsPerPage) {

        return menuItemDao.getMenuItemsSearchResult(menuItemSearchCriteria, pageNo,numberOfResultsPerPage);
    }

    public int getNumberOfSearchResultPages(MenuItemSearchCriteria menuItemSearchCriteria,int numberOfResultsPerPage) {

        return menuItemDao.getNumberOfSearchResultPages(menuItemSearchCriteria,numberOfResultsPerPage);
    }

    public int getNumberOfAllResultPages(int numberOfResultsPerPage){

        return menuItemDao.getNumberOfAllResultPages(numberOfResultsPerPage);
    }


}
