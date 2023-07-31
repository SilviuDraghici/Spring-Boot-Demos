package com.example.springboostrestcrud.dao;

import com.example.springboostrestcrud.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void saveEmployee(Employee employee) {
        entityManager.persist(employee);
    }

    @Override
    public void deleteEmployee(int id){
        Employee employee = entityManager.find(Employee.class, id);
        entityManager.remove(employee);
    }

    @Override
    @Transactional
    public int deleteAll() {

        int numRowsDeleted = entityManager.createQuery("DELETE FROM Employee").executeUpdate();

        return numRowsDeleted;
    }

    @Override
    public void upsertEmployee(Employee employee){
        entityManager.merge(employee);
    }

    @Override
    public Employee findById(int id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query = entityManager.createQuery("FROM Employee", Employee.class);

        return query.getResultList();
    }

    @Override
    public List<Employee> findByLastName(String lastName) {
        TypedQuery<Employee> query = entityManager.createQuery(
                "FROM Employee where lastName=:lastName order by lastName", Employee.class);
        query.setParameter("lastName", lastName);

        return query.getResultList();
    }

}
