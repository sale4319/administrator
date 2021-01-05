package com.aleks.administrator.cockroachdb.controllers;


import com.aleks.administrator.cockroachdb.models.Cockroach;
import com.aleks.administrator.cockroachdb.services.WorkerService;
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
    private WorkerService workerService;

    @GetMapping("/workers")
    public String getEmployees(Model model){
        model.addAttribute("workers", workerService.getWorkers());
        return "workers";
    }


    @GetMapping("/oneworker")
    @ResponseBody
    public Optional<Cockroach> getWorkerById(Long Id, Model model) {
        return workerService.getWorkerById(Id);
    }


    @PostMapping(value="/worker/addNew")
    public String addWorker(@Valid Cockroach cockroach, Model model, BindingResult result) {
        if(result.hasErrors()) {
            return "redirect:/index";
        }
        workerService.addWorker(cockroach);
        return "redirect:/index";
    }

    @RequestMapping(value="/worker/save", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateWorker(Cockroach cockroach) {
        workerService.updateWorker(cockroach);
        return "redirect:/index";
    }

    @RequestMapping(value="/worker/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteWorker(Long Id) {
        workerService.deleteWorker(Id);
        return "redirect:/index";
    }
}
