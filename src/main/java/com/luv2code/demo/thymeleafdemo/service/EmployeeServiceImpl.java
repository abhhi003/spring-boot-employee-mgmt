/**
 * 
 */
package com.luv2code.demo.thymeleafdemo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.demo.thymeleafdemo.dao.EmployeeRepository;
import com.luv2code.demo.thymeleafdemo.entity.Employee;

/**
 * @author Abhishek
 *
 */
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired	
	EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAllByOrderByLastNameAsc();
	}

	@Override
	public Employee findById(int id) {
		Optional<Employee> result = employeeRepository.findById(id);
		
		Employee employee = null;
		if(result.isPresent()) {
			employee = result.get();
		}else {
			throw new RuntimeException("Do not find employee id : "+id);
		}
		
		return employee;
	}

	@Override
	public void save(Employee employee) {
		employeeRepository.save(employee);

	}

	@Override
	public void deleteById(int id) {
		employeeRepository.deleteById(id);

	}

}
