package com.website.qlts.controller;

import com.website.qlts.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
    @RequestMapping(value = "/")
    public String home() {
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model) {
        model.addAttribute("user", new User());
        return "pages/user/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPage(@ModelAttribute User user, Model model) {
        model.addAttribute("user", new User());
        return "pages/user/login";
    }

    @RequestMapping(value = "/logout")
    public String logoutPage() {
        return "pages/user/logout";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerPage(Model model) {
        model.addAttribute("user", new User());
        return "pages/user/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerPage(@ModelAttribute User user, Model model) {
        model.addAttribute("user", new User());
        return "pages/user/register";
    }


}