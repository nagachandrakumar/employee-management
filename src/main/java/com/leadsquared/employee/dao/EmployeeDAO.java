package com.leadsquared.employee.dao;

import com.leadsquared.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDAO extends JpaRepository<Employee, String> {

    @Query("select DISTINCT e from Department d JOIN d.employee e JOIN d.projects dp WHERE dp.projCode=?1")
    public List<Employee> findEmployeeByProj(String projCode);
}
