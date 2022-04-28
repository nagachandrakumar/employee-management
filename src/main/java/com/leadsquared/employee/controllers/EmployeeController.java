package com.leadsquared.employee.controllers;

import com.leadsquared.employee.dao.EmployeeDAO;
import com.leadsquared.employee.exception.EmployeeNotFoundError;
import com.leadsquared.employee.model.Employee;
import com.leadsquared.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getEmployees(){
        List<Employee> empList = null;
        try{
            empList = employeeService.getAllEmployees();
        }catch (Exception e){
            throw new EmployeeNotFoundError("server error occurred");
        }
        return new ResponseEntity<List<Employee>>(empList, HttpStatus.OK);
    }

    @GetMapping(value="/employees/{empCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("empCode") String empCode){
        Employee emp = null;
        try{
            emp = employeeService.getEmployeeById(empCode);
        } catch (Exception e){
            throw new EmployeeNotFoundError("Requested employee is not found");
        }
        return new ResponseEntity<Employee>(emp, HttpStatus.OK);
    }

    @GetMapping(value="employees/project/{projCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Employee>> getEmployeesByProjectId(@PathVariable("projCode") String projCode){
        List<Employee> empList = new ArrayList<>();
        try{
            empList = employeeService.getEmployeesByProjectId(projCode);
        } catch (Exception e){
            throw new EmployeeNotFoundError("Requested employees are not found for mentioned project");
        }
        return new ResponseEntity<List<Employee>>(empList, HttpStatus.OK);
    }
}
