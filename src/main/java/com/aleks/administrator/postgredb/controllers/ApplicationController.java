package com.aleks.administrator.postgredb.controllers;

import com.aleks.administrator.cockroachdb.models.Cockroach;
import com.aleks.administrator.cockroachdb.services.CockroachService;
import com.aleks.administrator.postgredb.models.Postgre;
import com.aleks.administrator.postgredb.services.PostgreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ApplicationController {

    @Autowired
    private PostgreService postgreService;
    @Autowired
    private CockroachService cockroachService;

    @RequestMapping(value={"/","/index","/home"})
    public String getBoth(Model model){
        model.addAttribute("showPostgres", postgreService.getPostgres());
        model.addAttribute("showCockroach", cockroachService.getCockroaches());
        return "index";

    }

    @PostMapping(value="/both/addNew")
    public String addBoth(Postgre postgre, Cockroach cockroach, Model model) {
        cockroachService.addCockroach(cockroach);
        postgreService.addPostgre(postgre);
        return "redirect:/index";
    }

}
