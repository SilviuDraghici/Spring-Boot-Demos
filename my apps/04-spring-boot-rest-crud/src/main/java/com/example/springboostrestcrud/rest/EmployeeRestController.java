package com.example.springboostrestcrud.rest;

import com.example.springboostrestcrud.entity.Employee;
import com.example.springboostrestcrud.rest.errors.EntityNotFoundException;
import com.example.springboostrestcrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable int id){
        Employee employee = employeeService.findById(id);
        if(employee == null){
            throw new EntityNotFoundException("No Employee found with id: " + id);
        }
        return employee;
    }

    @PostMapping("employees")
    public void createEmployee(@RequestBody Employee employee){
        employee.setId(0);
        employeeService.upsertEmployee(employee);
    }

    @PutMapping("employees/{id}")
    public void updateEmployee(@RequestBody Employee employee, @PathVariable int id){
        employee.setId(id);
        employeeService.upsertEmployee(employee);
    }

    @DeleteMapping("employees/{id}")
    public void deleteEmployee(@PathVariable int id){
        Employee employee = employeeService.findById(id);
        if(employee == null){
            throw new EntityNotFoundException("No Employee found with id: " + id);
        }
        employeeService.deleteEmployee(id);
    }
}
