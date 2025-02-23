package com.first.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import com.first.demo.entity.Employee;
import com.first.demo.exception.EmployeeNotFoundException;
import com.first.demo.service.EmployeeService;

import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/register")
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee) {
        System.out.println("register >>>>>>");
        Employee createdEmployee = employeeService.createEmployee(employee);
        return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long employeeId,
                                                   @Valid @RequestBody Employee updatedEmployee) {
        System.out.println("update >>>>>>>>>");                                            
        Employee employee = employeeService.updateEmployee(employeeId, updatedEmployee);
        if (employee == null) {
            throw new EmployeeNotFoundException("Employee with id " + employeeId + " not found");
        }
        return ResponseEntity.ok(employee);
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long employeeId) {
        System.out.println("delete called >>>>>>>>>>>");
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee deleted successfully.");
    }

    @GetMapping
    public Page<Employee> getAllEmployees(
            @RequestParam(value = "search", defaultValue = "") String search,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestParam(value = "sort", defaultValue = "name") String sort
    ) {
        System.out.println("get all emplyees >>>>>>>>>>..");
        Pageable pageable = PageRequest.of(page, size).withSort(Sort.by(sort));
        return employeeService.getAllEmployees(search, pageable);
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long employeeId) {
        System.out.println("getEmployeeById >>>>>>>..");
        Employee employee = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(employee);
    }


    @GetMapping("/test")
    public String test() {
        System.out.println("test >>>>>>> ");
        return "Controller is working!";
    }
}
