package com.codedifferently.lesson15;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class EmployeeTest {

  @Test
  public void testSetId() {
    // Arrange - create a new employee with initial id
    Employee employee = new Employee(1, "Karen", "Technical", 300000);

    // Act - get initial expected employee id
    int expected = 1;
    int employeeId = employee.getId();

    // Assert - return expected id
    assertEquals(expected, employeeId);
  }

  @Test
  public void testGetId() {
    // Arrange - create a new employee with initial id
    Employee employee = new Employee(1, "Karen", "Technical", 300000);

    // Act - set a new employee id
    employee.setId(4);

    // Assert - returns new employee id
    assertEquals(4, employee.getId());
  }

  @Test
  public void testGetName() {
    // Arrange - creates a new employee with initial name
    Employee employee = new Employee(1, "Karen", "Technical", 300000);

    // Act - gets initial expected name of employee
    String expected = "Karen";
    String employeeName = employee.getName();

    // Assert - returns employee name
    assertEquals(expected, employeeName);
  }

  @Test
  public void testSetName() {
    // Arrange - creates a new employee with initial name
    Employee employee = new Employee(1, "Karen", "Technical", 300000);

    // Act - sets employee name to a new employee
    employee.setName("Kaleb");

    // Assert - checks new employee name is updated
    assertEquals("Kaleb", employee.getName());
  }

  @Test
  public void testGetDepartment() {
    // Arrange - creates a new employee under initial department
    Employee employee = new Employee(1, "Karen", "Technical", 300000);

    // Act - retrieves employee department using getter method
    String expected = "Technical";
    String employeeName = employee.getDepartment();

    // Assert - checks employee department is correct; returns expected employee department
    assertEquals(expected, employeeName);
  }

  @Test
  public void testSetDepartment() {
    // Arrange - creates new employee under initial department
    Employee employee = new Employee(1, "Karen", "Technical", 300000);

    // Act - updates department employee is under with setter method
    employee.setDepartment("Fashion");

    // Assert - returns updated department of employee
    assertEquals("Fashion", employee.getDepartment());
  }

  @Test
  public void testGetSalary() {
    // Arrange - creates new employee with initial salary
    Employee employee = new Employee(1, "Karen", "Technical", 300000);

    // Act - retrieves new employee salary with getter method
    int expected = 300000;
    Double employeeSalary = employee.getSalary();

    // Assert - verifys employee salary is correct; returns expected employee salary
    assertEquals(expected, employeeSalary);
  }

  @Test
  public void testSetSalary() {
    // Arrange - creates new employee with inital salary
    Employee employee = new Employee(1, "Karen", "Technical", 300000);

    // Act - updates new employees salary with setter method
    employee.setSalary(350000);

    // Assert - ensures new salary is
    assertEquals(350000, employee.getSalary());
  }
}
