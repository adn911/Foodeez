package org.foodeezz.service;

import org.foodeezz.persistance.dao.MenuItemReviewDao;
import org.foodeezz.persistance.entity.MenuItemReview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by GALIB on 4/24/2015.
 */
@Service
@Transactional
public class MenuItemReviewService {

    @Autowired
    private MenuItemReviewDao menuItemReviewDao;

    public void addReview(MenuItemReview menuItemReview){
         menuItemReviewDao.addReview(menuItemReview);
    }

    public void removeReview(int menuItemReviewId){
        menuItemReviewDao.removeReview(menuItemReviewId);
    }

    public MenuItemReview getReview(int id){
        return menuItemReviewDao.getReview(id);
    }

}
