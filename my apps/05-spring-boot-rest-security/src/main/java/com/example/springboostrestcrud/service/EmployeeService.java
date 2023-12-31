package com.example.springboostrestcrud.service;

import com.example.springboostrestcrud.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> findAll();

    public Employee findById(int id);

    public void upsertEmployee(Employee employee);

    public void deleteEmployee(int id);
}
