package com.website.qlts.controller;

import com.website.qlts.entity.Assets;
import com.website.qlts.entity.RepairsHistory;
import com.website.qlts.service.*;
import com.website.qlts.view.AssetsView;
import com.website.qlts.view.RepairsView;
import com.website.qlts.view.TransferView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/repairsHistory")
public class RepairsHistoryController {
    @Autowired
    private AssetsService assetsService;

    @Autowired
    CategoryAssetsService categoryAssetsService;


    @Autowired
    DepartmentsService departmentsService;

    @Autowired
    SuppliersService suppliersService;

    @Autowired
    GroupAssetsService groupAssetsService;

    @RequestMapping("")
    public String transferDepart(Model model){
        model.addAttribute("model", assetsService.getAllWithDepart());
        return "pages/repairsHistory/index";
    }

    @RequestMapping("/action/{id}")
    public String action(Model model, @PathVariable("id") long id){
        RepairsView repairsView = new RepairsView();
        repairsView.setAssets(assetsService.findById(id));
        model.addAttribute("model",repairsView);
        return "pages/repairsHistory/create";
    }

    public AssetsView setAssetView(Assets assets) {
        AssetsView assetsView = new AssetsView();
        if (assets != null) {
            assetsView.setAssets(assets);
        } else {
            assetsView.setAssets(new Assets());
        }
        assetsView.setAssetsList(assetsService.getAll());
        assetsView.setCategoryAssetsList(categoryAssetsService.getAll());
        assetsView.setDepartmentsList(departmentsService.getAll());
        assetsView.setSuppliersList(suppliersService.getAll());
        assetsView.setGroupAssetsList(groupAssetsService.getAll());
        return assetsView;
    }
    @RequestMapping(value = "/create")
    public String createRepairsHistory(Model model, String keyWord) {
        com.website.qlts.entity.RepairsHistory repairsHistory = new com.website.qlts.entity.RepairsHistory();
        AssetsView assets = new AssetsView();
        if(keyWord != null){

            assets.setAssetsList(assetsService.getByName(keyWord));
            model.addAttribute("model",assets);
        }
        return "pages/assets/createRepairsHistory";
    }

}
