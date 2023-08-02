package com.example.springbootmvccrud.dao;
import com.example.springbootmvccrud.entity.Student;

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
