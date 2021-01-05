package com.aleks.administrator.postgreDB.controllers;

import com.aleks.administrator.cockroachDB.models.Cockroach;
import com.aleks.administrator.postgreDB.models.Employee;
import com.aleks.administrator.postgreDB.services.EmployeeService;
import com.aleks.administrator.cockroachDB.services.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ApplicationController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private WorkerService workerService;

    @RequestMapping(value={"/","/index","/home"})
    public String getEmployees(Model model){
        model.addAttribute("showPostgres", employeeService.getEmployees());
        model.addAttribute("showCockroach", workerService.getWorkers());
        return "index";

    }

    @PostMapping(value="/both/addNew")
    public String addEmployee(Employee employee, Cockroach cockroach, Model model) {
        workerService.addWorker(cockroach);
        employeeService.addEmployee(employee);
        return "redirect:/index";
    }

}
