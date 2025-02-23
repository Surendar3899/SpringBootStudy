package com.revotran.employeesystem.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.revotran.employeesystem.entity.Employee;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Page<Employee> findByNameContainingOrPositionContaining(String name, String position, Pageable pageable);
    Optional<Employee> findByIdAndIsDeletedFalse(Long employeeId);
}
