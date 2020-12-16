package com.aleks.administrator.workers.controllers;


import com.aleks.administrator.workers.models.Worker;
import com.aleks.administrator.workers.services.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
public class WorkerController {

    @Autowired
    private WorkerService workerService;

    @GetMapping("/workers")
    public String getEmployees(Model model){
        model.addAttribute("workers", workerService.getWorkers());
        return "workers";
    }


    @GetMapping("/oneworker")
    @ResponseBody
    public Optional<Worker> getWorkerById(Long Id, Model model) {
        return workerService.getWorkerById(Id);
    }

    @RequestMapping(value="/worker/save", method = {RequestMethod.POST, RequestMethod.PUT, RequestMethod.GET})
    public String updateWorker(Worker worker) {
        workerService.updateWorker(worker);
        return "redirect:/index";
    }

    @RequestMapping(value="/worker/addNew", method = {RequestMethod.POST, RequestMethod.PUT, RequestMethod.GET})
    public String addWorker(Worker worker, Model model) {
        workerService.addWorker(worker);
        return "redirect:/index";
    }

    @RequestMapping(value="/worker/delete", method = {RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.GET})
    public String deleteWorker(Long Id) {
        workerService.deleteWorker(Id);
        return "redirect:/index";
    }
}
