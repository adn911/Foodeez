package org.foodeezz.controller;

import org.foodeezz.service.RestaurantCategoryService;
import org.foodeezz.service.RestaurantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by bakhtiar.galib on 4/12/15.
 */
@Controller
public class IndexController {

    private static final Logger log = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    HttpSession httpSession;

    @Autowired
    RestaurantCategoryService restaurantCategoryService;

    @Autowired
    RestaurantService restaurantService;

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String show(ModelMap model) {
        log.debug("At Index page");

        model.addAttribute("categories", restaurantCategoryService.getAllCategories());
        model.addAttribute("areas", restaurantService.getAllAreaNames());

        return "index";
    }

}
