package com.springBootDemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springBootDemo.model.Employee;

@Repository
public class EmployeeDaoImp implements EmployeeDao{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public int save(Employee employee) {
		return jdbcTemplate.update("INSERT INTO tbl_user (name,email,position) VALUES(?,?,?)", new Object[] {employee.getName(),employee.getEmail(),employee.getPosition()});
	}

	@Override
	public int update(Employee employee, int id) {
		// (if want to edit multiple filed) return jdbcTemplate.update("UPDATE tbl_user SET name=? , email=?, position=? WHERE id=?", new Object[] {employee.getName(),employee.getEmail(),employee.getPosition(), id});
		return jdbcTemplate.update("UPDATE tbl_user SET position=? WHERE id=?", new Object[] {employee.getPosition(), id});
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update("DELETE FROM tbl_user WHERE id=?",id);
	}

	@Override
	public List<Employee> getAll() {
		return jdbcTemplate.query("SELECT * FROM tbl_user", new BeanPropertyRowMapper<Employee>(Employee.class));
	}

	@Override
	public Employee getById(int id) {
		return jdbcTemplate.queryForObject("SELECT * FROM tbl_user where id=?", new BeanPropertyRowMapper<Employee>(Employee.class), id);
	}
	
}
