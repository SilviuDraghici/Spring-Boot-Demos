package com.example.springbootmvccrud.rest;

import com.example.springbootmvccrud.dao.StudentDAO;
import com.example.springbootmvccrud.entity.Student;

import com.example.springbootmvccrud.rest.errors.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private StudentDAO studentDAO;

    @Autowired
    public StudentRestController(StudentDAO studentDao){
        this.studentDAO = studentDao;
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return studentDAO.findAll();
    }

    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable int id){
        Student student = studentDAO.findById(id);

        if (student == null){
            throw new EntityNotFoundException("No Student found with id: " + id);
        }
        return student;
    }

}
