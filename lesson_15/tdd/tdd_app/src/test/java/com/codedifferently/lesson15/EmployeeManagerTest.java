package com.codedifferently.lesson15;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmployeeManagerTest {

  private EmployeeManager employeeManager;

  @BeforeEach
  public void setup() {
    // This will run before each test to set up a fresh EmployeeManager
    employeeManager = new EmployeeManager();
  }

  @Test
  public void testLesson15() {
    assertThat(new Lesson15()).isNotNull();
  }

  @Test
  public void testGetGreeting() {
    // Act
    Lesson15.main(null);
  }

  @Test
  public void testAddEmployee() {
    // Arrange
    Employee employee = new Employee(101, "Robert Downey Jr.", "Engineering", 82345.12);

    // Act
    employeeManager.addEmployee(employee);

    // Assert
    assertThat(employeeManager.getEmployeeCount()).isEqualTo(1);
    assertThat(employeeManager.getEmployee(101)).isEqualTo(employee);
  }

  @Test
  public void testGetEmployee() {
    // Arrange
    Employee employee = new Employee(202, "Scarlett Johansson", "HR", 63278.94);
    employeeManager.addEmployee(employee);

    // Act
    Employee fetchedEmployee = employeeManager.getEmployee(202);

    // Assert
    assertThat(fetchedEmployee).isEqualTo(employee);
    assertThat(fetchedEmployee.getName()).isEqualTo("Scarlett Johansson");
    assertThat(fetchedEmployee.getDepartment()).isEqualTo("HR");
  }

  @Test
  public void testUpdateEmployee() {
    // Arrange
    Employee employee = new Employee(303, "Chris Hemsworth", "Engineering", 92000.50);
    employeeManager.addEmployee(employee);
    Employee updatedEmployee = new Employee(303, "Chris Hemsworth", "Marketing", 96542.30);

    // Act
    employeeManager.updateEmployee(updatedEmployee);
    Employee fetchedEmployee = employeeManager.getEmployee(303);

    // Assert
    assertThat(fetchedEmployee.getDepartment()).isEqualTo("Marketing");
    assertThat(fetchedEmployee.getSalary()).isEqualTo(96542.30);
  }

  @Test
  public void testRemoveEmployee() {
    // Arrange
    Employee employee = new Employee(404, "Jennifer Lawrence", "Sales", 70450.77);
    employeeManager.addEmployee(employee);

    // Act
    employeeManager.removeEmployee(404);

    // Assert
    assertThat(employeeManager.getEmployeeCount()).isEqualTo(0);
  }

  @Test
  public void testRemoveEmployeeThrowsExceptionIfNotExist() {
    // Act & Assert
    try {
      employeeManager.removeEmployee(505);
    } catch (IllegalArgumentException e) {
      assertThat(e).hasMessage("Employee does not in collection with id 505");
    }
  }

  @Test
  public void testGetEmployeeThrowsExceptionIfNotExist() {
    // Act & Assert
    try {
      employeeManager.getEmployee(505);
    } catch (IllegalArgumentException e) {
      assertThat(e).hasMessage("Employee does not in collection with id 505");
    }
  }
}
