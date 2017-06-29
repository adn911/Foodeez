package org.foodeezz.controller;


import org.foodeezz.persistance.entity.User;
import org.foodeezz.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.IOException;

/**
 * Created by bakhtiar.galib on 4/12/15.
 */
@Controller
public class SignupController {

    private static final Logger log = LoggerFactory.getLogger(SignupController.class);

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/signup"}, method = RequestMethod.GET)
    public String show(Model model) {

        model.addAttribute("newUser", new User());

        return "signup";
    }

    @RequestMapping(value = {"/signup"}, method = RequestMethod.POST)
    public String process(@Valid @ModelAttribute("newUser") User newUser,
                          BindingResult result,
                          @RequestParam(value = "picture", required = false) MultipartFile image,
                          RedirectAttributes redirectAttributes,
                          Model model) throws IOException {

        if (result.hasErrors()) {

            return "signup";
        }

        if (userService.usernameExists(newUser.getUserId())) {
            redirectAttributes.addAttribute("error", 1);
        } else if (userService.emailExists(newUser.getEmail())) {
            redirectAttributes.addAttribute("error", 2);
        } else {

            userService.addUser(newUser);
            redirectAttributes.addAttribute("success", 1);
        }

        return "redirect:/signup";
    }

}
