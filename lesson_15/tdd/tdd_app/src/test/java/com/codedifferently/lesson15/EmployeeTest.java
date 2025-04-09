package com.codedifferently.lesson15;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class EmployeeTest {
  @Test
  public void testGetDetails() {
    // Arrange
    Employee employee = new Employee(1, "Ezra Nyabuti", "Software Engineer", 100000);
    // Act
    String details = employee.getDetails();
    // Assert
    assertThat(details).isEqualTo("1, Ezra Nyabuti, Software Engineer,100000.0");
  }

  @Test
  public void testGetId() {
    // Arrange
    Employee employee = new Employee(1, "Ezra Nyabuti", "Software Engineer", 0);
    // Act
    int id = employee.getId();
    // Assert
    assertThat(id).isEqualTo(1);
  }

  @Test
  public void testSetId() {
    // Arrange
    Employee employee = new Employee(1, "Ezra Nyabuti", "Software Engineer", 0);
    // Act
    employee.setId(1);
    // Assert
    assertThat(employee.getId()).isEqualTo(1);
  }

  @Test
  public void testGetName() {
    // Arrange
    Employee employee = new Employee(1, "Ezra Nyabuti", "Software Engineer", 0);
    // Act
    String name = employee.getName();
    // Assert
    assertThat(name).isEqualTo("Ezra Nyabuti");
  }

  @Test
  public void testSetName() {
    // Arrange
    Employee employee = new Employee(1, "Ezra Nyabuti", "Software Engineer", 0);
    // Act
    employee.setName("Ezra Nyabuti");
    // Assert
    assertThat(employee.getName()).isEqualTo("Ezra Nyabuti");
  }

  @Test
  public void testGetDepartment() {
    // Arrange
    Employee employee = new Employee(1, "Ezra Nyabuti", "Software Engineer", 0);
    // Act
    String department = employee.getDepartment();
    // Assert
    assertThat(department).isEqualTo("Software Engineer");
  }

  @Test
  public void testSetDepartment() {
    // Arrange
    Employee employee = new Employee(1, "Ezra Nyabuti", "Software Engineer", 0);
    // Act
    employee.setDepartment("Data Scientist");
    // Assert
    assertThat(employee.getDepartment()).isEqualTo("Data Scientist");
  }

  @Test
  public void testGetSalary() {
    // Arrange
    Employee employee = new Employee(1, "Ezra Nyabuti", "Software Engineer", 100000);
    // Act
    double salary = employee.getSalary();
    // Assert
    assertThat(salary).isEqualTo(100000);
  }

  @Test
  public void testSetSalary() {
    // Arrange
    Employee employee = new Employee(1, "Ezra Nyabuti", "Software Engineer", 100000);
    // Act
    employee.setSalary(120000);
    // Assert
    assertThat(employee.getSalary()).isEqualTo(120000);
  }
}
