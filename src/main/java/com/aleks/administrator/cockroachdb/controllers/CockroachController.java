package com.aleks.administrator.cockroachdb.controllers;


import com.aleks.administrator.cockroachdb.models.Cockroach;
import com.aleks.administrator.cockroachdb.services.CockroachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class CockroachController {

    @Autowired
    private CockroachService cockroachService;

    @GetMapping("/cockroaches")
    public String getCockroaches(Model model){
        model.addAttribute("cockroaches", cockroachService.getCockroaches());
        return "cockroaches";
    }


    @GetMapping("/onecockroach")
    @ResponseBody
    public Optional<Cockroach> getCockroachById(Long Id, Model model) {
        return cockroachService.getCockroachById(Id);
    }


    @PostMapping(value="/cockroach/addNew")
    public String addCockroach(@Valid Cockroach cockroach, Model model, BindingResult result) {
        if(result.hasErrors()) {
            return "redirect:/index";
        }
        cockroachService.addCockroach(cockroach);
        return "redirect:/index";
    }

    @RequestMapping(value="/cockroach/save", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateCockroach(Cockroach cockroach) {
        cockroachService.updateCockroach(cockroach);
        return "redirect:/index";
    }

    @RequestMapping(value="/cockroach/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteCockroach(Long Id) {
        cockroachService.deleteCockroach(Id);
        return "redirect:/index";
    }
}
