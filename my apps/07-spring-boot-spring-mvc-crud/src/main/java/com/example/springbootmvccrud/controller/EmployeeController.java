package com.example.springbootmvccrud.controller;

import com.example.springbootmvccrud.dao.EmployeeDAO;
import com.example.springbootmvccrud.entity.Employee;
import com.example.springbootmvccrud.service.EmployeeService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService employeeService){
		this.employeeService = employeeService;
	}

	@GetMapping("/list")
	public String listEmployees(Model theModel) {

		// add to the spring model
		List<Employee> employees = employeeService.findAll();
		theModel.addAttribute("employees", employees);

		return "list-employees";
	}
}
