package com.example.springbootmvccrud.service;

import com.example.springbootmvccrud.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> findAll();

    List<Employee> findAllByOrderByIdDesc();

    public Employee findById(int id);

    public void upsertEmployee(Employee employee);

    public void deleteEmployee(int id);

}
