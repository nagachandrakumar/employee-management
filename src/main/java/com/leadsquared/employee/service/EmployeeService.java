package com.leadsquared.employee.service;

import com.leadsquared.employee.model.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee>  getAllEmployees();

    public Employee getEmployeeById(String empCode);

    public List<Employee> getEmployeesByProjectId(String projCode);
}
