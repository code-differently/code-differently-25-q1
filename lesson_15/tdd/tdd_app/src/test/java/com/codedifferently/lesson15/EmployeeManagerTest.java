package com.codedifferently.lesson15;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class EmployeeManagerTest {
  @Test
  public void testAddEmployee() {
    // Arrange
    var employee = new Employee(1, "Karen", "Technical", 150000);
    var employeeManager = new EmployeeManager();

    // Act
    employeeManager.addEmployee(employee);

    // Assert
    assertEquals(employee, employeeManager.getEmployee(1));
  }

  @Test
  public void testGetEmployee() {
    // Arrange - creating new employee and new employee manager
    var employee = new Employee(1, "Karen", "Technical", 150000);
    var employeeManager = new EmployeeManager();

    // Act - test that manager gets employee by its id
    //adds employee to manager hashmap
    employeeManager.addEmployee(employee);
    Employee actualEmployee = employeeManager.getEmployee(1);

    // Assert
    assertEquals(actualEmployee, employee);
  }
}
