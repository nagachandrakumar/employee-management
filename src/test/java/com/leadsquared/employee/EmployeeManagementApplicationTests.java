package com.leadsquared.employee;

import com.leadsquared.employee.dao.EmployeeDAO;
import com.leadsquared.employee.model.Employee;
import com.leadsquared.employee.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class EmployeeManagementApplicationTests {

	@Autowired
	private EmployeeService service;

	@MockBean
	private EmployeeDAO repository;

	@Test
	public void getAllEmployeesTest() {
		when(repository.findAll())
				.thenReturn(Stream.of(new Employee("E10001", "Ram"), new Employee("E10002", "Raj")).collect(Collectors.toList()));
		assertEquals(2, service.getAllEmployees().size());
	}

	@Test
	public void getEmployeeByIdTest() {
		when(repository.findById("E10001")).thenReturn(java.util.Optional.of(new Employee("E10001", "Ram")));
		assertEquals("Ram", service.getEmployeeById("E10001").getEmpName());
	}

	@Test
	public void getEmployeesByProjectIdTest() {
		when(repository.findEmployeeByProj("P1001")).thenReturn(Stream.of(new Employee("E10001","Ram")).collect(Collectors.toList()));
		assertEquals(1, service.getEmployeesByProjectId("P1001").size());
	}

}
