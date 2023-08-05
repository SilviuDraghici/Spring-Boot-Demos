package com.example.springbootmvccrud.rest;

import com.example.springbootmvccrud.entity.Employee;
import com.example.springbootmvccrud.rest.errors.EntityNotFoundException;
import com.example.springbootmvccrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {
    EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("")
    public List<Employee> getEmployees(){
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id){
        Employee employee = employeeService.findById(id);
        if(employee == null){
            throw new EntityNotFoundException("No Employee found with id: " + id);
        }
        return employee;
    }

    @PostMapping("")
    public void createEmployee(@RequestBody Employee employee){
        employee.setId(0);
        employeeService.upsertEmployee(employee);
    }

    @PutMapping("/{id}")
    public void updateEmployee(@RequestBody Employee employee, @PathVariable int id){
        employee.setId(id);
        employeeService.upsertEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable int id){
        Employee employee = employeeService.findById(id);
        if(employee == null){
            throw new EntityNotFoundException("No Employee found with id: " + id);
        }
        employeeService.deleteEmployee(id);
    }
}
