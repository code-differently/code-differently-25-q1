package com.codedifferently.lesson15;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class EmployeeManagerTest {
  @Test
  public void employeeManagerTest() {
    // Arrange
    EmployeeManager employeeManager = new EmployeeManager();
    Employee employee = new Employee(1, "Justin Eklund", "Software Engineer", 0);
    // Act
    employeeManager.addEmployee(employee);
    // Assert
    assertThat(employeeManager.getEmployeeCount()).isEqualTo(1);
  }

  @Test
  public void testAddEmployee() {
    // Arrange
    EmployeeManager employeeManager = new EmployeeManager();
    Employee employee = new Employee(1, "Justin Eklund", "Software Engineer", 0);
    // Act
    employeeManager.addEmployee(employee);
    // Assert
    assertThat(employeeManager.getEmployeeCount()).isEqualTo(1);
  }

  @Test
  public void testGetEmployee() {
    // Arrange
    EmployeeManager employeeManager = new EmployeeManager();
    Employee employee = new Employee(1, "Justin Eklund", "Software Engineer", 0);
    employeeManager.addEmployee(employee);
    // Act
    Employee retrievedEmployee = employeeManager.getEmployee(1);
    // Assert
    assertThat(retrievedEmployee).isEqualTo(employee);
  }

  @Test
  public void testUpdateEmployee() {
    // Arrange
    EmployeeManager employeeManager = new EmployeeManager();
    Employee employee = new Employee(1, "Justin Eklund", "Software Engineer", 500000);
    employeeManager.addEmployee(employee);
    // Act
    employee.setName("Justin Eklund Updated");
    employeeManager.updateEmployee(employee);
    // Assert
    assertThat(employeeManager.getEmployee(1).getName()).isEqualTo("Justin Eklund Updated");
  }

  @Test
  public void testRemoveEmployee() {
    // Arrange
    EmployeeManager employeeManager = new EmployeeManager();
    Employee employee = new Employee(1, "Justin Eklund", "Software Engineer", 0);
    employeeManager.addEmployee(employee);
    // Act
    employeeManager.removeEmployee(1);
    // Assert
    assertThat(employeeManager.getEmployeeCount()).isEqualTo(0);
  }

  @Test
  public void testAssertEmployeeInCollection() {
    // Arrange
    EmployeeManager employeeManager = new EmployeeManager();
    Employee employee = new Employee(1, "Justin Eklund", "Software Engineer", 0);
    employeeManager.addEmployee(employee);
    // Act & Assert
    assertThat(employeeManager.getEmployee(1)).isEqualTo(employee);
  }
}
