package com.aleks.administrator.employees.controllers;

import com.aleks.administrator.employees.models.Employee;
import com.aleks.administrator.employees.services.EmployeeService;
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
public class ApplicationController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private WorkerService workerService;

    @GetMapping("/index")
    public String getEmployees(Model model){
        model.addAttribute("showPostgres", employeeService.getEmployees());
        model.addAttribute("showCockroach", workerService.getWorkers());
        return "index";

    }

    @RequestMapping(value="/both/addNew", method = {RequestMethod.POST, RequestMethod.PUT, RequestMethod.GET})
    public String addEmployee(Employee employee, Worker worker, Model model) {
        workerService.addWorker(worker);
        employeeService.addEmployee(employee);
        return "redirect:/index";
    }

}
