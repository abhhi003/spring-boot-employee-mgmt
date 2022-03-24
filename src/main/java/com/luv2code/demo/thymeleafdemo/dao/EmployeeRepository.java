/**
 * 
 */
package com.luv2code.demo.thymeleafdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.demo.thymeleafdemo.entity.Employee;

/**
 * @author Abhishek
 *
 */
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	//Basic CRUD methods are provided by JpaRepository
	//So, no need to write any code just extend JpaRepository Interface
	//and provide entity class and datatype of primary key
	
	public List<Employee> findAllByOrderByLastNameAsc();

}
