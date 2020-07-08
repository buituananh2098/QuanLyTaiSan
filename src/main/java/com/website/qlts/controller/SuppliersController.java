package com.website.qlts.controller;

import com.website.qlts.entity.CategoriesSupplier;
import com.website.qlts.entity.Suppliers;
import com.website.qlts.view.SuppliersCate;
import com.website.qlts.service.CategorySuppliersService;
import com.website.qlts.service.SuppliersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("/suppliers")
public class SuppliersController {
    @Autowired
    SuppliersService suppliersService;
    @Autowired
    CategorySuppliersService categorySuppliersService;

    @RequestMapping("")
    public String indexPage(Model model, String keyWord) {
        List<Suppliers> list;
        if (keyWord != null) {
            list = suppliersService.getByName(keyWord);
        } else {
            list = suppliersService.getAll();
        }
        model.addAttribute("sups", list);
        return "pages/suppliers/index";
    }

    @RequestMapping("/create")
    public String createPage(Model model) {
        List<CategoriesSupplier> listAssets;
        listAssets = categorySuppliersService.getAll();
        SuppliersCate suppliersCate = new SuppliersCate();
        suppliersCate.setList(listAssets);
        suppliersCate.setSuppliers(new Suppliers());
        model.addAttribute("listCate", suppliersCate);
        return "pages/suppliers/create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createPage(@ModelAttribute SuppliersCate suppliers ,@RequestParam("supCateId") String supCateId) {
        suppliersService.create(suppliers.getSuppliers().getName(), suppliers.getSuppliers().getAddress(),
                suppliers.getSuppliers().getPhoneNumber(), Long.parseLong(supCateId));
        return "redirect:/suppliers";
    }

    @RequestMapping(value = "/edit/{id}")
    public String editPage(@PathVariable("id") long id, Model model) {
        Suppliers suppliers = suppliersService.getById(id);
        List<CategoriesSupplier> listAssets;
        listAssets = categorySuppliersService.getAll();
        SuppliersCate suppliersCate = new SuppliersCate();
        suppliersCate.setList(listAssets);
        suppliersCate.setSuppliers(suppliers);
        model.addAttribute("model", suppliersCate);
        return "pages/suppliers/edit";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String update(@ModelAttribute SuppliersCate suppliersCate, @PathVariable("id") long id, Model model) {
        model.addAttribute("model", suppliersCate);
        suppliersService.update(id, suppliersCate.getSuppliers());
        return "redirect:/suppliers/";
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") long id) {
        suppliersService.delete(id);
        return "redirect:/suppliers/";
    }
}
