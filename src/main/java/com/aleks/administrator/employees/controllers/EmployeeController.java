package com.aleks.administrator.employees.controllers;

import com.aleks.administrator.employees.models.Employee;
import com.aleks.administrator.employees.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping(value="/save", method = {RequestMethod.POST, RequestMethod.PUT, RequestMethod.GET})
    public String updateEmployee(Employee employee) {
        employeeService.updateEmployee(employee);
        return "redirect:/index";
    }

    @RequestMapping(value="/addNew", method = {RequestMethod.POST, RequestMethod.PUT, RequestMethod.GET})
    public String addEmployee(Employee employee, Model model) {
		/*if(bindingResult.hasErrors()) {
			return "redirect:/employees";
		}
        if(userService.checkUser(user.getId())){
            model.addAttribute("exist", true);
            return "redirect:/home";
        }*/

        employeeService.addEmployee(employee);
        return "redirect:/index";
    }

    @RequestMapping(value="/delete", method = {RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.GET})
    public String deleteEmployee(Long Id) {
        employeeService.deleteEmployee(Id);
        return "redirect:/index";
    }
}
