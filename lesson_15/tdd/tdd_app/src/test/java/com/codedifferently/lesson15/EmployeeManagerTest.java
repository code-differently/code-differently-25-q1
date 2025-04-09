package com.codedifferently.lesson15;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class EmployeeManagerTest {
  @Test
  public void testAddEmployee() {
    EmployeeManager employeeManager = new EmployeeManager();
    Employee employee = new Employee(1, "Rasheed Miller", "IT", 50000);
    employeeManager.addEmployee(employee);
    assertThat(employeeManager.getEmployeeCount()).isEqualTo(1);
  }

  @Test
  public void testGetEmployee() {
    EmployeeManager employeeManager = new EmployeeManager();
    Employee employee = new Employee(1, "Rasheed Miller", "IT", 50000);
    employeeManager.addEmployee(employee);
    Employee result = employeeManager.getEmployee(1);
    assertThat(result).isEqualTo(employee);
  }

  @Test
  public void testUpdateEmployee() {
    EmployeeManager employeeManager = new EmployeeManager();
    Employee employee = new Employee(1, "Rasheed Miller", "IT", 50000);
    employeeManager.addEmployee(employee);
    employee.setName("John Doe");
    employeeManager.updateEmployee(employee);
    Employee result = employeeManager.getEmployee(1);
    assertThat(result.getName()).isEqualTo("John Doe");
  }

  @Test
  public void testRemoveEmployee() {
    EmployeeManager employeeManager = new EmployeeManager();
    Employee employee = new Employee(1, "Rasheed Miller", "IT", 50000);
    employeeManager.addEmployee(employee);
    employeeManager.removeEmployee(1);
    assertThat(employeeManager.getEmployeeCount()).isEqualTo(0);
  }
}
