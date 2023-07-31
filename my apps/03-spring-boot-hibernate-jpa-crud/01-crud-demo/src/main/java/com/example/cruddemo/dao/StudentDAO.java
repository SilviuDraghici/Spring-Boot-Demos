package com.example.cruddemo.dao;

import com.example.cruddemo.oems.Student;

import java.util.List;

public interface StudentDAO {
    public void saveStudent(Student student);

    public void updateStudent(Student student);

    public void deleteStudent(Student student);

    public int deleteAll();

    public Student findById(int id);

    public List<Student> findAll();

    public List<Student> findByLastName(String lastName);
}
