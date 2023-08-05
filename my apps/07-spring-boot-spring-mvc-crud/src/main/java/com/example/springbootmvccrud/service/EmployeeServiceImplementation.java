package com.example.springbootmvccrud.service;

import com.example.springbootmvccrud.dao.EmployeeRepository;
import com.example.springbootmvccrud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImplementation implements EmployeeService {
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImplementation(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> findAllByOrderByIdDesc(){
        return employeeRepository.findAllByOrderByIdDesc();
    }

    @Override
    public Employee findById(int id) {
        Employee employee = null;

        Optional<Employee> result = employeeRepository.findById(id);
        if (result.isPresent()){
            employee = result.get();
        }

        return employee;
    }

    @Override
    public void upsertEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }
}
