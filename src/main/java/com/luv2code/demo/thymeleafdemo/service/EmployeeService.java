/**
 * 
 */
package com.luv2code.demo.thymeleafdemo.service;

import java.util.List;

import com.luv2code.demo.thymeleafdemo.entity.Employee;

/**
 * @author Abhishek
 *
 */
public interface EmployeeService {

	public List<Employee> findAll();
	
	public Employee findById(int id);
	
	public void save(Employee employee);
	
	public void deleteById(int id);
	
}
