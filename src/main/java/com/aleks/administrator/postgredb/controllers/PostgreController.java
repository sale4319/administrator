package com.aleks.administrator.postgredb.controllers;

import com.aleks.administrator.postgredb.models.Postgre;
import com.aleks.administrator.postgredb.services.PostgreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class PostgreController {

    @Autowired
    private PostgreService postgreService;

    @GetMapping("/postgres")
    public String getPostgres(Model model){
        model.addAttribute("postgres", postgreService.getPostgres());
        return "postgres";
    }


    @GetMapping("/onepostgre")
    @ResponseBody
    public Optional<Postgre> getPostgreById(Long Id, Model model) {
        return postgreService.getPostgreById(Id);
    }


    @PostMapping(value="/addNew")
    public String addPostgre(@Valid Postgre postgre, Model model, BindingResult result) {
        if(result.hasErrors()) {
            return "redirect:/index";
        }
        postgreService.addPostgre(postgre);
        return "redirect:/index";
    }

    @RequestMapping(value="/save", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updatePostgre(Postgre postgre) {
        postgreService.updatePostgre(postgre);
        return "redirect:/index";
    }

    @RequestMapping(value="/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deletePostgre(Long Id) {
        postgreService.deletePostgre(Id);
        return "redirect:/index";
    }
}
