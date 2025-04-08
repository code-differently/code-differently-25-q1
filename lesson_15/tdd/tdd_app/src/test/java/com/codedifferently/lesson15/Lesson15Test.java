package com.codedifferently.lesson15;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lesson15Test {

  @Test
  public void testLesson15() {
    assertThat(new Lesson15()).isNotNull();
  }

  @Test
  public void testGetGreeting() {
    // Act
    String greeting = new Lesson15().getGreeting("World");
    // Assert
    assertThat(greeting).isEqualTo("Hello, World!");
  }

  @Test
  public void employeeManagerTest() {
    // Arrange
    EmployeeManager employeeManager = new EmployeeManager();
    Employee employee = new Employee(1, "Ezra Nyabuti", "Software Engineer", 0);
    // Act
    employeeManager.addEmployee(employee);
    // Assert
    assertThat(employeeManager.getEmployeeCount()).isEqualTo(1);
  }

  @Test
  public void testAddEmployee() {
    // Arrange
    EmployeeManager employeeManager = new EmployeeManager();
    Employee employee = new Employee(1, "Ezra Nyabuti", "Software Engineer", 0);
    // Act
    employeeManager.addEmployee(employee);
    // Assert
    assertThat(employeeManager.getEmployeeCount()).isEqualTo(1);
  }

  @Test
  public void testGetEmployee() {
    // Arrange
    EmployeeManager employeeManager = new EmployeeManager();
    Employee employee = new Employee(1, "Ezra Nyabuti", "Software Engineer", 0);
    employeeManager.addEmployee(employee);
    // Act
    Employee retrievedEmployee = employeeManager.getEmployee(1);
    // Assert
    assertThat(retrievedEmployee).isEqualTo(employee);
  }

  @Test
  public void testRemoveEmployee() {
    // Arrange
    EmployeeManager employeeManager = new EmployeeManager();
    Employee employee = new Employee(1, "Ezra Nyabuti", "Software Engineer", 0);
    employeeManager.addEmployee(employee);
    // Act
    employeeManager.removeEmployee(1);
    // Assert
    assertThat(employeeManager.getEmployeeCount()).isEqualTo(0);
  }

  @Test
  public void testGetid() {
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
    employee.setId(2);
    // Assert
    assertThat(employee.getId()).isEqualTo(2);
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
