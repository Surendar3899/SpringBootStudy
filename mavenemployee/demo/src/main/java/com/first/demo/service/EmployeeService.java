package com.first.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.first.demo.entity.Employee;
import com.first.demo.repository.EmployeeRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // 1. Create Employee
    public Employee createEmployee(@Valid Employee employee) {
        return employeeRepository.save(employee);
    }

    // 2. Update Employee
    public Employee updateEmployee(Long employeeId, Employee updatedEmployee) {
        Employee existingEmployee = employeeRepository.findByEmployeeIdAndIsDeletedFalse(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        existingEmployee.setName(updatedEmployee.getName());
        existingEmployee.setAge(updatedEmployee.getAge());
        existingEmployee.setPosition(updatedEmployee.getPosition());
        
        return employeeRepository.save(existingEmployee);
    }

    // 3. Soft Delete Employee
    @Transactional
    public void deleteEmployee(Long employeeId) {
        Employee existingEmployee = employeeRepository.findByEmployeeIdAndIsDeletedFalse(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        existingEmployee.setDeleted(true);
        employeeRepository.save(existingEmployee);
    }

    // 4. Get All Employees with Search and Pagination
    public Page<Employee> getAllEmployees(String search, Pageable pageable) {
        return employeeRepository.findByNameContainingOrPositionContaining(search, search, pageable);
    }

    // 5. Get Employee by ID
    public Employee getEmployeeById(Long employeeId) {
        return employeeRepository.findByEmployeeIdAndIsDeletedFalse(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }
}