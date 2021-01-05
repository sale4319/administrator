package com.aleks.administrator.postgredb.services;

import com.aleks.administrator.postgredb.models.Postgre;
import com.aleks.administrator.postgredb.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    public EmployeeRepository employeeRepository;

    public List<Postgre> getEmployees() {
        return (List<Postgre>) employeeRepository.findAll();
    }

    public Optional<Postgre> getEmployeeById(Long Id) {
        return employeeRepository.findById(Id);
    }


    public void addEmployee(Postgre postgre) {
        employeeRepository.save(postgre);
    }

    public void updateEmployee(Postgre postgre) {
        employeeRepository.save(postgre);
    }

    public void deleteEmployee(Long Id) {
        employeeRepository.deleteById(Id);
    }

}
