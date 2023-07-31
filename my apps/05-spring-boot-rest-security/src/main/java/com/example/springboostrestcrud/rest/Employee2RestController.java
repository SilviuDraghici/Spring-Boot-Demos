package com.example.springboostrestcrud.rest;

import com.example.springboostrestcrud.entity.Employee;
import com.example.springboostrestcrud.entity.Employee2;
import com.example.springboostrestcrud.rest.errors.EntityNotFoundException;
import com.example.springboostrestcrud.service.Employee2Service;
import com.example.springboostrestcrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee2s")
public class Employee2RestController {
    Employee2Service employee2Service;

    @Autowired
    public Employee2RestController(Employee2Service employee2Service){
        this.employee2Service = employee2Service;
    }

    @GetMapping("")
    public List<Employee2> getEmployees(){
        return employee2Service.findAll();
    }

    @GetMapping("/{id}")
    public Employee2 getEmployeeById(@PathVariable int id){
        Employee2 employee2 = employee2Service.findById(id);
        if(employee2 == null){
            throw new EntityNotFoundException("No Employee2 found with id: " + id);
        }
        return employee2;
    }

    @PostMapping("")
    public void createEmployee(@RequestBody Employee2 employee2){
        employee2.setId(0);
        employee2Service.upsertEmployee(employee2);
    }

    @PutMapping("/{id}")
    public void updateEmployee(@RequestBody Employee2 employee2, @PathVariable int id){
        employee2.setId(id);
        employee2Service.upsertEmployee(employee2);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable int id){
        Employee2 employee2 = employee2Service.findById(id);
        if(employee2 == null){
            throw new EntityNotFoundException("No Employee2 found with id: " + id);
        }
        employee2Service.deleteEmployee(id);
    }
}
