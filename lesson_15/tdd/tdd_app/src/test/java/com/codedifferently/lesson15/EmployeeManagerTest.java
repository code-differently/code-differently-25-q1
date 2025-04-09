package com.codedifferently.lesson15;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmployeeManagerTest {

  EmployeeManager employeeManager;
  Employee employee;

  @BeforeEach
  void setUp() {
    employeeManager = new EmployeeManager();
    employee = new Employee(2, "Zoro", "Swordsman", 900000);
  }

  @Test
  void testAddEmployee() {
    employeeManager.addEmployee(employee);
    int actual = employeeManager.getEmployeeCount();
    assertThat(actual).isEqualTo(1);
  }

  @Test
  void testGetEmployee() {
    employeeManager.addEmployee(employee);
    Employee actual = employeeManager.getEmployee(2);
    assertNotNull(actual);
  }

  @Test
  void testRemoveEmployee() {
    employeeManager.addEmployee(employee);
    employeeManager.removeEmployee(2);
    int actual = employeeManager.getEmployeeCount();
    assertThat(actual).isEqualTo(0);
  }

  @Test
  void testGetEmployeeCount() {
    employeeManager.addEmployee(employee);
    int actual = employeeManager.getEmployeeCount();
    assertThat(actual).isEqualTo(1);
  }
}
