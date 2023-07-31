package com.example.cruddemo.dao;

import com.example.cruddemo.oems.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void saveStudent(Student student) {
        entityManager.persist(student);
    }

    @Override
    @Transactional
    public void deleteStudent(Student student){
        // the "contains" section is used because the student has been passed in from outside the transaction
        entityManager.remove(entityManager.contains(student) ? student : entityManager.merge(student));

        // if the delete method instead was passed an id and then retreieved the student to be deleted
        // the following line would work.
        //entityManager.remove(student);
    }

    @Override
    @Transactional
    public int deleteAll() {

        int numRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();

        return numRowsDeleted;
    }

    @Override
    @Transactional
    public void updateStudent(Student student){
        entityManager.merge(student);
    }

    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> query = entityManager.createQuery("FROM Student order by lastName", Student.class);

        return query.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        TypedQuery<Student> query = entityManager.createQuery(
                "FROM Student where lastName=:lastName order by lastName", Student.class);
        query.setParameter("lastName", lastName);

        return query.getResultList();
    }

}
