package com.website.qlts.controller;

import com.website.qlts.models.Staffs;
import com.website.qlts.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/staffs")
public class StaffController {
    @Autowired
    private StaffService staffService;

    @RequestMapping("")
    public String indexPage(Model model, String keyWord) {
        List<Staffs> staffsList;
        if (keyWord != null) {
            staffsList = staffService.getByName(keyWord);
        } else {
            staffsList = staffService.getAll();
        }

        model.addAttribute("staffs", staffsList);
        return "pages/staffs/index";
    }

    @RequestMapping("/create")
    public String createPage(Model model) {
        model.addAttribute("staffs", new Staffs());
        return "pages/staffs/create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createPage(@ModelAttribute Staffs staffs, Model model) {
        model.addAttribute("staffs", staffs);
        staffService.create(staffs);
        return "redirect:/staffs/";
    }


    @RequestMapping("/delete/{id}")
    public String deletePage(@PathVariable("id") long id, Model model) {
        staffService.delete(id);
        return "redirect:/category-assets/";
    }

    @RequestMapping("/search")
    public String search(@RequestParam String name, Model model){
        List<Staffs> staffsList = staffService.getByName(name);
        model.addAttribute("staffs",staffsList);
        return "redirect:/staffs/";
    }
}
