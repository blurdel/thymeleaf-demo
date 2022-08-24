package com.blurdel.web.thymeleaf.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository <Employee, Integer> {

}
