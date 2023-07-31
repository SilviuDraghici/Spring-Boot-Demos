package com.example.springboostrestcrud.service;

import com.example.springboostrestcrud.dao.Employee2Repository;
import com.example.springboostrestcrud.dao.EmployeeDAO;
import com.example.springboostrestcrud.entity.Employee2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class Employee2ServiceImplementation implements Employee2Service {
    private Employee2Repository employee2Repository;

    @Autowired
    public Employee2ServiceImplementation(Employee2Repository employee2Repository){
        this.employee2Repository = employee2Repository;
    }

    @Override
    public List<Employee2> findAll(){
        return employee2Repository.findAll();
    }

    @Override
    public Employee2 findById(int id) {
        Employee2 employee2 = null;

        Optional<Employee2> result = employee2Repository.findById(id);
        if (result.isPresent()){
            employee2 = result.get();
        }

        return employee2;
    }

    @Override
    public void upsertEmployee(Employee2 employee) {
        employee2Repository.save(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        employee2Repository.deleteById(id);
    }
}
