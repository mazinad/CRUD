package com.demo.demo.repository;

import com.demo.demo.model.Employee;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
public interface employeeRepository extends JpaRepository<Employee,Long> {
    Optional<Employee> findById(Long id);
    void deleteById(Long id);

}
