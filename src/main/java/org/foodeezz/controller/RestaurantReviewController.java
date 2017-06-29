package org.foodeezz.controller;

import org.foodeezz.persistance.entity.RestaurantReview;
import org.foodeezz.persistance.entity.Review;
import org.foodeezz.service.RestaurantReviewService;
import org.foodeezz.service.RestaurantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;

/**
 * Created by bakhtiar.galib on 4/12/15.
 */
@Controller
@RequestMapping("/restaurantReviews")
public class RestaurantReviewController {

    private static final Logger log = LoggerFactory.getLogger(RestaurantReviewController.class);

    @Autowired
    HttpSession httpSession;

    @Autowired
    RestaurantService restaurantService;

    @Autowired
    RestaurantReviewService restaurantReviewService;

    @RequestMapping(value = {"/add"}, method = RequestMethod.POST)
    public String addReview(@Valid @ModelAttribute("newRestaurantReview") RestaurantReview review, BindingResult result, RedirectAttributes redirectAttributes) throws IOException {
        log.debug("Adding Restaurant Review");

        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.newRestaurantReview", review);
            redirectAttributes.addFlashAttribute("newRestaurantReview", review);
        } else {
            restaurantReviewService.addReview(review);
            redirectAttributes.addAttribute("addReviewSuccess", 1);
        }

        return "redirect:/restaurants/"
                + review.getRestaurant().getId() + "#reviews";
    }

    @RequestMapping(value = {"/remove"}, method = RequestMethod.POST)
    public String removeReview(@RequestParam(value = "reviewId") int reviewId) {
        log.debug("Removing Restaurant Review");

        RestaurantReview review = restaurantReviewService.getReview(reviewId);
        restaurantReviewService.removeReview(reviewId);

        return "redirect:/restaurants/"
                + review.getRestaurant().getId() + "#reviews";
    }

}
