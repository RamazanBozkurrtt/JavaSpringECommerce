package com.Ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Ecommerce.entitites.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
