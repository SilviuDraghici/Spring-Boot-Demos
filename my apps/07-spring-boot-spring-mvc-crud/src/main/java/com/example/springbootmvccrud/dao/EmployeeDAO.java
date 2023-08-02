package com.example.springbootmvccrud.dao;
import com.example.springbootmvccrud.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public void saveEmployee(Employee employee);

    public void upsertEmployee(Employee employee);

    public void deleteEmployee(int id);

    public int deleteAll();

    public Employee findById(int id);

    public List<Employee> findAll();

    public List<Employee> findByLastName(String lastName);
}
