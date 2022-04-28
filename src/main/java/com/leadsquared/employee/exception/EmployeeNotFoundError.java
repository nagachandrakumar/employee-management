package com.leadsquared.employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeNotFoundError extends RuntimeException {

  public EmployeeNotFoundError(final String message) {
    super(message);
  }
}
