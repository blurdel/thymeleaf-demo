package com.blurdel.web.thymeleaf.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blurdel.web.thymeleaf.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
