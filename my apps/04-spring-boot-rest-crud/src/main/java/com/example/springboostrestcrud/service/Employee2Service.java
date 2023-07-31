package com.example.springboostrestcrud.service;

import com.example.springboostrestcrud.entity.Employee2;

import java.util.List;

public interface Employee2Service {
    public List<Employee2> findAll();

    public Employee2 findById(int id);

    public void upsertEmployee(Employee2 employee);

    public void deleteEmployee(int id);
}
