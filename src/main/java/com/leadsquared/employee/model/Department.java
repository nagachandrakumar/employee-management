package com.leadsquared.employee.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "department")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Department {

    @Id
    @Column(name = "dept_code")
    private String deptCode;

    @Column(name = "dept_name")
    private String deptName;

    @ManyToOne
    @JoinColumn(name ="emp_code", insertable=false, updatable=false, nullable=false)
    @NotFound(action=NotFoundAction.IGNORE)
    private Employee employee;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "proj_dept",
            joinColumns = { @JoinColumn(name = "dept_code") },
            inverseJoinColumns = { @JoinColumn(name = "proj_code") }
    )
    private Set<Project> projects = new HashSet<>();

    public Department(){}

    public Department(String deptCode, String deptName) {
        this.deptCode = deptCode;
        this.deptName = deptName;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

}
