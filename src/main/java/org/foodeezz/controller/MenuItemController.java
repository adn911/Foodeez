package org.foodeezz.controller;

import org.foodeezz.persistance.entity.MenuItem;
import org.foodeezz.service.MenuItemService;
import org.foodeezz.service.RestaurantService;
import org.foodeezz.util.ImageUploadHelper;
import org.foodeezz.web.formbeans.MenuItemSearchCriteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;

/**
 * Created by bakhtiar.galib on 4/12/15.
 */
@Controller
@RequestMapping("/menuItems")
public class MenuItemController {

    private static final Logger log = LoggerFactory.getLogger(MenuItemController.class);

    private int numberOfResultsPerPage = 3;

    @Autowired
    HttpSession httpSession;

    @Autowired
    private MenuItemService menuItemService;

    @Autowired
    private RestaurantService restaurantService;


    @ModelAttribute("menuItemSearchCriteria")
    public MenuItemSearchCriteria getMenuItemSearchCriteria() {
        return new MenuItemSearchCriteria();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String browseItems(@RequestParam(value = "page") int pageNo, Model model) {
        log.debug("At Browse Items Page");

        model.addAttribute("numberOfPages", menuItemService.getNumberOfAllResultPages(numberOfResultsPerPage));
        model.addAttribute("items", menuItemService.getAllMenuItems(pageNo, numberOfResultsPerPage));

        return "menuItemsList";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchItem(MenuItemSearchCriteria menuItemSearchCriteria,
                             @RequestParam("page") Integer pageNo, Model model) {
        log.debug("At Menu Items Search Page");

        model.addAttribute("numberOfPages", menuItemService.getNumberOfSearchResultPages(menuItemSearchCriteria, numberOfResultsPerPage));
        model.addAttribute("items", menuItemService.getMenuItemsSearchResult(menuItemSearchCriteria, pageNo, numberOfResultsPerPage));

        return "menuItemsList";
    }

    @RequestMapping("/{id}")
    public String showMenuItemDetails(@PathVariable(value = "id") int itemId, Model model) {
        log.debug("At MenuItem Details Page");

        model.addAttribute("item", menuItemService.getMenuItemWithAssociations(itemId));

        return "menuItemDetails";
    }

    @RequestMapping(value = {"/add/{restaurantId}"}, method = RequestMethod.GET)
    public String addMenuItem(@PathVariable(value = "restaurantId") int restaurantId, Model model) throws IOException {
        log.debug("At Add MenuItem Page");

        model.addAttribute("restaurant", restaurantService.getRestaurant(restaurantId));
        model.addAttribute("newMenuItem", new MenuItem());

        return "addMenuItem";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addMenuItem(@Valid @ModelAttribute("newMenuItem") MenuItem newMenuItem, BindingResult result,
                              @RequestParam(value = "picture", required = false) MultipartFile image,
                              RedirectAttributes redirectAttributes, Model model) throws IOException {
        log.debug("Adding New MenuItem");

        if (result.hasErrors()) {
            model.addAttribute("restaurant", newMenuItem.getRestaurant());

            return "addMenuItem";
        } else {

            if (!ImageUploadHelper.isValidImage(image)) {
                redirectAttributes.addAttribute("error", 1);

            } else {

                if (!image.isEmpty())
                    newMenuItem.setPhoto(image.getBytes());

                menuItemService.addMenuItem(newMenuItem);

                redirectAttributes.addAttribute("success", 1);
            }

        }

        return "redirect:/menuItems/add/" + newMenuItem.getRestaurant().getId();
    }

    @RequestMapping(value = {"/update/{menuItemId}"}, method = RequestMethod.GET)
    public String updateMenuItem(@PathVariable(value = "menuItemId") int menuItemId, Model model) throws IOException {
        log.debug("At Update MenuItem Page");

        model.addAttribute("menuItem", menuItemService.getMenuItem(menuItemId));

        return "updateMenuItem";
    }

    @RequestMapping(value = {"/update/{menuItemId}"}, method = RequestMethod.POST)
    public String updateMenuItem(@Valid @ModelAttribute("menuItem") MenuItem updatedMenuItem, BindingResult result,
                                 @RequestParam(value = "picture", required = false) MultipartFile image,
                                 RedirectAttributes redirectAttributes) throws IOException {
        log.debug("Updating MenuItem Page");

        if (result.hasErrors()) {

            return "updateMenuItem";
        } else {

            if (!ImageUploadHelper.isValidImage(image)) {
                redirectAttributes.addAttribute("error", 1);

            } else {

                if (!image.isEmpty())
                    updatedMenuItem.setPhoto(image.getBytes());

                menuItemService.updateMenuItem(updatedMenuItem);

                redirectAttributes.addAttribute("success", 1);
            }
        }

        return "redirect:/menuItems/update/" + updatedMenuItem.getId();
    }


    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public String removeMenuItem(@RequestParam(value = "menuItemId") int menuItemId, Model model) {
        log.debug("removing MenuItem");

        MenuItem menuItem = menuItemService.getMenuItem(menuItemId);
        menuItemService.removeMenuItem(menuItemId);

        return "redirect:/restaurants/"
                + menuItem.getRestaurant().getId() + "#menuitems";
    }

}
