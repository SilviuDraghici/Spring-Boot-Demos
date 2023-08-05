package com.example.springbootmvccrud.controller;

import com.example.springbootmvccrud.entity.Employee;
import com.example.springbootmvccrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
		List<Employee> employees = employeeService.findAllByOrderByIdDesc();
		theModel.addAttribute("employees", employees);

		return "employees/list-employees";
	}

	@GetMapping("/add-employee")
	public String addEmployee(Model model){
		Employee newEmployee = new Employee();
		model.addAttribute("employee", newEmployee);

		return "employees/employee-form";
	}

	@PostMapping("/save")
	public String addEmployee(@ModelAttribute("employee") Employee employee){
		employeeService.upsertEmployee(employee);

		return "redirect:/employees/list";
	}

}
