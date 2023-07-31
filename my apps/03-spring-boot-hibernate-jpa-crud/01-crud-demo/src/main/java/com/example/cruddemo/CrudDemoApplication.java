package com.example.cruddemo;

import com.example.cruddemo.dao.StudentDAO;
import com.example.cruddemo.oems.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.SQLOutput;
import java.util.List;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner ->{
			System.out.println("App Running!");

			////Create
			createStudent(studentDAO);

			////Read
			//readStudent(studentDAO);

			readAllStudents(studentDAO);
			//System.out.println();
			//readStudentsByLastName(studentDAO);

			////Update
			//updateStudent(studentDAO);

			////Delete
			//deleteStudent(studentDAO);

			//studentDAO.deleteAll();
		};
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating Student...");
		Student student = new Student("Edmond", "Dantes", "SinbadTheSailor@MonteCristo.com");
		System.out.println("Saving :" + student);
		studentDAO.saveStudent(student);
		System.out.println("student saved! id:" + student.getId());

		student = new Student("Abbé", "Farria", "ImprissonedAbbé@MonteCristo.com");
		System.out.println("Saving :" + student);
		studentDAO.saveStudent(student);
		System.out.println("student saved! id:" + student.getId());

		student = new Student("Louis", "Dantes", "FatherDantes@MonteCristo.com");
		System.out.println("Saving :" + student);
		studentDAO.saveStudent(student);
		System.out.println("student saved! id:" + student.getId());

		student = new Student("Haydée", "Pasha", "ThePrincess@MonteCristo.com");
		System.out.println("Saving :" + student);
		studentDAO.saveStudent(student);
		System.out.println("student saved! id:" + student.getId());
	}

	private void readStudent(StudentDAO studentDAO) {
		int id = 2;
		System.out.println("Finding student with id: " + id);

		Student student = studentDAO.findById(id);

		System.out.println("Found " + student);
	}

	private void readAllStudents(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findAll();
		System.out.println("Found Students:");
		for(Student student: students){
			System.out.println(student);
		}
	}

	private void readStudentsByLastName(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findByLastName("Dantes");
		System.out.println("Found Students with lastName = Dantes:");
		for(Student student: students){
			System.out.println(student);
		}
	}

	private void updateStudent(StudentDAO studentDAO){
		int id = 5;
		System.out.println("Finding student with id: " + id);

		Student student = studentDAO.findById(id);
		student.setFirstName("beep");

		studentDAO.updateStudent(student);
	}

	private void deleteStudent(StudentDAO studentDAO){
		int id = 5;
		System.out.println("Deleting student with id: " + id);

		Student student = studentDAO.findById(id);
		studentDAO.deleteStudent(student);
	}

}
