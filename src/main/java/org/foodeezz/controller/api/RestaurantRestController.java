package org.foodeezz.controller.api;

import org.foodeezz.persistance.entity.*;
import org.foodeezz.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by bakhtiar.galib on 4/12/15.
 */
@RestController
@RequestMapping("/api/restaurants")
public class RestaurantRestController {

    private static final Logger log = LoggerFactory.getLogger(RestaurantRestController.class);

    @Autowired
    private RestaurantService restaurantService;

    private static final int DEFAULT_LIST_PAGE_PARAM = 1;

    private static final int DEFAULT_LIST_ITEMS_PER_PAGE_PARAM = 3;

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public List<Restaurant> list(@RequestParam(value = "page", required = false, defaultValue = DEFAULT_LIST_PAGE_PARAM + "") Integer pageNo,
                       @RequestParam(value = "numberOfItems", required = false, defaultValue = DEFAULT_LIST_ITEMS_PER_PAGE_PARAM + "") Integer numberOfItems) {

        return restaurantService.getPaginatedList(pageNo, numberOfItems);
    }

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.GET)
    public Restaurant get(@PathVariable(value = "id") int id) {

        return restaurantService.getRestaurantWithAssociations(id);
    }
}
