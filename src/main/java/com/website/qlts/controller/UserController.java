package com.website.qlts.controller;

import com.website.qlts.config.MyUserDetails;
import com.website.qlts.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    @RequestMapping(value = "/")
    public String home() {
        return "pages/user/index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model) {
        model.addAttribute("user", new User());
        return "pages/user/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPage(@ModelAttribute User user, Model model, @RequestParam("userName") String userName) {
        model.addAttribute("user", user);
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
    public String registerPage(@ModelAttribute("user") User user, Model model, BindingResult result) {
        if(result.hasErrors()){
            return "pages/user/register";
        }
        model.addAttribute("user", new User());
        return "pages/user/login";
    }


}
