package org.foodeezz.controller;

import org.foodeezz.persistance.entity.User;
import org.foodeezz.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Locale;

/**
 * Created by bakhtiar.galib on 4/12/15.
 */
@Controller
public class AuthenticationController {

    private static final Logger log = LoggerFactory.getLogger(AuthenticationController.class);

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private HttpSession httpSession;

    @Autowired
    private UserService userService;


    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String showLogin(Model model) {
        log.debug("At Login page");

        return "login";
    }

    @RequestMapping(value = {"/", "/login"}, method = RequestMethod.POST)
    public String processLogin(@RequestParam("email") String email, @RequestParam("password") String password, Model model) {
        User user = userService.loginUser(email, password);

        if (user != null) {
            httpSession.setAttribute("user", user);

            return "redirect:/home";
        }

        model.addAttribute("error", messageSource.getMessage("error.incorrect.credential", null, Locale.getDefault()));

        return "login";
    }

    @RequestMapping(value = {"/logout"}, method = RequestMethod.GET)
    public String logout(Model model) {
        log.debug("Loggin out User With Session Id: " + httpSession.getId());

        httpSession.invalidate();

        return "redirect:/";
    }


}
