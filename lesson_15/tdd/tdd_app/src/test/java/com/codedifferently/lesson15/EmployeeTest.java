package com.codedifferently.lesson15;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class EmployeeTest {

  @Test
  public void test_getId() {

    // Arrange
    int expectedId = 1;
    Employee employee = new Employee(expectedId, null, null, 0);

    // Act
    int actualId = employee.getId();
    // Assert
    assertEquals(expectedId, actualId);
  }

  @Test
  public void test_setId() {
    // Arrange
    Employee employee = new Employee(0, null, null, 0);

    // Act
    int expectedId = 1;
    employee.setId(expectedId);
    // Assert
    assertEquals(expectedId, employee.getId(), "Id should be set to expected value");
  }

  @Test
  public void test_getName() {

    // Arrange
    String expectedName = "John Doe";
    Employee employee = new Employee(1, expectedName, "Engineering", 50000.0);
    // Act
    String actualName = employee.getName();
    // Assert
    assertEquals(expectedName, actualName, "Name should match the expected value");
  }

  @Test
  public void test_setName() {

    // Arrange
    Employee employee = new Employee(1, "Jane Doe", "Engineering", 50000.0);
    // Act
    String expectedName = "John Doe";
    employee.setName(expectedName);
    // Assert
    assertEquals(expectedName, employee.getName(), "Name should be set to expected value");
  }

  @Test
  public void test_getDepartment() {

    // Arrange
    String expectedDepartment = "Engineering";
    Employee employee = new Employee(1, "John Doe", expectedDepartment, 50000.0);
    // Act
    String actualDepartment = employee.getDepartment();
    // Assert
    assertEquals(
        expectedDepartment, actualDepartment, "Department should match the expected value");
  }

  @Test
  public void test_setDepartment() {
    // Arrange
    Employee employee = new Employee(1, "John Doe", "Engineering", 50000.0);
    String expectedDepartment = "Marketing";

    // Act
    employee.setDepartment(expectedDepartment);

    // Assert
    assertEquals(
        expectedDepartment, employee.getDepartment(), "Department should be set to expected value");
  }

  @Test
  public void test_getSalary() {
    // Arrange
    double expectedSalary = 50000.0;
    Employee employee = new Employee(1, "John Doe", "Engineering", expectedSalary);

    // Act
    double actualSalary = employee.getSalary();

    // Assert
    assertEquals(expectedSalary, actualSalary, "Salary should match the expected value");
  }

  @Test
  public void test_setSalary() {
    // Arrange
    Employee employee = new Employee(1, "John Doe", "Engineering", 50000.0);
    double expectedSalary = 60000.0;

    // Act
    employee.setSalary(expectedSalary);

    // Assert
    assertEquals(expectedSalary, employee.getSalary(), "Salary should be set to expected value");
  }

  @Test
  public void test_getDetails() {
    // Arrange
    Employee employee = new Employee(1, "John Doe", "Engineering", 50000.0);
    String expectedDetails =
        "Employee's ID: 1 Name: John Doe Department: Engineering Salary: 50000.0";

    // Act
    String actualDetails = employee.getDetails();

    // Assert
    assertEquals(expectedDetails, actualDetails, "Details should match the expected format");
  }
}
