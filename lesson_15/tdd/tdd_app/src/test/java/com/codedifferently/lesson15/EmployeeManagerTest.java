package com.codedifferently.lesson15;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class EmployeeManagerTest {
  @Test
  public void test_EmployeeManager() {
    // Arrange
    EmployeeManager employeeManager = new EmployeeManager();
    Employee employee = new Employee(1, "John Doe", "Engineering", 60000);

    // Act
    employeeManager.addEmployee(employee);
    Employee retrievedEmployee = employeeManager.getEmployee(1);

    // Assert
    assertNotNull(retrievedEmployee);
    assertEquals("John Doe", retrievedEmployee.getName());
  }

  @Test
  public void test_addEmployee() {
    // Arrange
    EmployeeManager employeeManager = new EmployeeManager();
    Employee employee = new Employee(2, "Jane Smith", "Marketing", 50000);

    // Act
    employeeManager.addEmployee(employee);

    // Assert
    assertEquals(1, employeeManager.getEmployeeCount());
    assertEquals("Jane Smith", employeeManager.getEmployee(2).getName());
  }

  @Test
  public void test_getEmployee() {
    // Arrange
    EmployeeManager employeeManager = new EmployeeManager();
    Employee employee = new Employee(3, "Alice Johnson", "HR", 55000);
    employeeManager.addEmployee(employee);

    // Act
    Employee retrievedEmployee = employeeManager.getEmployee(3);

    // Assert
    assertNotNull(retrievedEmployee);
    assertEquals("Alice Johnson", retrievedEmployee.getName());
  }

  @Test
  public void test_updateEmployee() {
    // Arrange
    EmployeeManager employeeManager = new EmployeeManager();
    Employee employee = new Employee(4, "Bob Brown", "Finance", 70000);
    employeeManager.addEmployee(employee);

    // Act
    Employee updatedEmployee = new Employee(4, "Bob Brown", "Finance", 75000);
    employeeManager.updateEmployee(updatedEmployee);

    // Assert
    assertEquals(75000, employeeManager.getEmployee(4).getSalary());
  }

  @Test
  public void test_removeEmployee() {
    // Arrange
    EmployeeManager employeeManager = new EmployeeManager();
    Employee employee = new Employee(5, "Charlie White", "IT", 65000);
    employeeManager.addEmployee(employee);

    // Act
    employeeManager.removeEmployee(5);

    // Assert
    assertEquals(0, employeeManager.getEmployeeCount());
  }

  @Test
  public void test_getEmployeeCount() {
    // Arrange
    EmployeeManager employeeManager = new EmployeeManager();
    Employee employee1 = new Employee(7, "Eve Black", "Sales", 50000);
    Employee employee2 = new Employee(8, "Frank Blue", "Support", 52000);
    employeeManager.addEmployee(employee1);
    employeeManager.addEmployee(employee2);

    // Act
    int count = employeeManager.getEmployeeCount();
ß
    // Assert
    assertEquals(2, count);
  }
}
