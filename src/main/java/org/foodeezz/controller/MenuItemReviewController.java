package org.foodeezz.controller;

import org.foodeezz.persistance.entity.MenuItemReview;
import org.foodeezz.service.MenuItemReviewService;
import org.foodeezz.service.MenuItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;

/**
 * Created by bakhtiar.galib on 4/12/15.
 */
@Controller
@RequestMapping("/menuItemReviews")
public class MenuItemReviewController {

    private static final Logger log = LoggerFactory.getLogger(MenuItemReviewController.class);

    @Autowired
    HttpSession httpSession;

    @Autowired
    MenuItemService menuItemService;

    @Autowired
    MenuItemReviewService menuItemReviewService;

    @RequestMapping(value = {"/add"}, method = RequestMethod.POST)
    public String addReview(@Valid @ModelAttribute("newMenuItemReview") MenuItemReview review, BindingResult result, RedirectAttributes redirectAttributes) throws IOException {
        log.debug("Adding MenuItem Review");

        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.newMenuItemReview", review);
            redirectAttributes.addFlashAttribute("newMenuItemReview", review);
        } else {
            menuItemReviewService.addReview(review);
            redirectAttributes.addAttribute("success", 1);
        }

        return "redirect:/menuItems/"
                + review.getMenuItem().getId() + "#reviews";
    }

    @RequestMapping(value = {"/remove"}, method = RequestMethod.POST)
    public String removeReview(@RequestParam(value = "reviewId") int reviewId) {
        log.debug("Removing MenuItem Review");

        MenuItemReview review = menuItemReviewService.getReview(reviewId);
        menuItemReviewService.removeReview(reviewId);

        return "redirect:/menuItems/"
                + review.getMenuItem().getId() + "#reviews";
    }

}
