package com.leadsquared.employee.service;

import com.leadsquared.employee.dao.EmployeeDAO;
import com.leadsquared.employee.exception.EmployeeNotFoundError;
import com.leadsquared.employee.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeDAO employeeDAO;

    public List<Employee> getAllEmployees() {
        return employeeDAO.findAll();
    }

    public Employee getEmployeeById(String empCode) {
        Optional<Employee> employee = employeeDAO.findById(empCode);
        if(!employee.isPresent())
            throw new EmployeeNotFoundError("Requested employee is not found");
        return employee.get();
    }

    public List<Employee> getEmployeesByProjectId(String projCode) {
        List<Employee> empList = employeeDAO.findEmployeeByProj(projCode);
        if(empList != null && empList.size() < 1)
            throw new EmployeeNotFoundError("Employees are not found for given project");
        return empList;
    }

}
