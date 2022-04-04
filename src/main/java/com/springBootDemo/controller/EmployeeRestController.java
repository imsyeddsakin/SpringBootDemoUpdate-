package com.springBootDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.springBootDemo.dao.EmployeeDao;
import com.springBootDemo.model.Employee;

@RestController
public class EmployeeRestController {
	@Autowired
	private EmployeeDao eDao;
	
	@GetMapping("/users")
	public List<Employee> getEmployee(){
		return eDao.getAll();
	}
	
	@GetMapping("/user/{id}")
	public Employee getEmployeeById(@PathVariable int id) {
		return eDao.getById(id);
	}
	
	@PutMapping("/updateuserinfo/{id}")
	public String updateEmployee(@RequestBody Employee employee, @PathVariable int id) {
		return eDao.update(employee, id)+" number of row updated";
	}

	@DeleteMapping("/deleteuser/{id}")
	public String deleteEmployee(@PathVariable int id) {
		return eDao.delete(id)+" number of row deleted";
	}
}
