package org.foodeezz.persistance.dao;

import org.foodeezz.persistance.entity.MenuItemReview;

/**
 * Created by bakhtiar.galib on 2/8/15.
 */
public interface MenuItemReviewDao {

    void addReview(MenuItemReview menuItemReview);

    MenuItemReview getReview(int id);

    void removeReview(int reviewId);

}
