package com.leadsquared.employee.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name="employee")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Employee {

    @Id
    @Column(name = "emp_code")
    private String empCode;

    @Column(name="emp_name")
    private String empName;

    public String getEmpCode() {
        return empCode;
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Employee(String empCode, String empName) {
        this.empCode = empCode;
        this.empName = empName;
    }

    public Employee(){}

    @Override
    public String toString() {
        return "Employee{" +
                "empCode='" + this.empCode + '\'' +
                ", empName='" + this.empName + '\'' +
                '}';
    }
}
