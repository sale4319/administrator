package com.aleks.administrator.employees.controllers;

import com.aleks.administrator.employees.models.Employee;
import com.aleks.administrator.employees.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public String getEmployees(Model model){
        model.addAttribute("employees", employeeService.getEmployees());
        return "employees";
    }


    @GetMapping("/oneemployee")
    @ResponseBody
    public Optional<Employee> getEmployeeById(Long Id, Model model) {
        return employeeService.getEmployeeById(Id);
    }


    @PostMapping(value="/addNew")
    public String addEmployee(@Valid Employee employee, Model model, BindingResult result) {
        if(result.hasErrors()) {
            return "redirect:/index";
        }
        employeeService.addEmployee(employee);
        return "redirect:/index";
    }

    @RequestMapping(value="/save", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateEmployee(Employee employee) {
        employeeService.updateEmployee(employee);
        return "redirect:/index";
    }

    @RequestMapping(value="/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteEmployee(Long Id) {
        employeeService.deleteEmployee(Id);
        return "redirect:/index";
    }
}
