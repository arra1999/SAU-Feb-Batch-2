package com.AuProject.EmployeeManager.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.AuProject.EmployeeManager.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long>{
	void deleteEmployeeById(Long id);  // SPRING UNDERSTANDS THE FUNCTION NAME, AND CREATES A QUERY FOR THE SAME(because of the naming convention)
	Optional<Employee> findEmployeeById(Long id); //Optional --> might not have an employee with that id
}
