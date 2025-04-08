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
    Lesson15 lesson15 = new Lesson15();
    String result = lesson15.getGreeting();
    String expected = "Hello, World!";
    assertThat(result).isEqualTo(expected);
  }

  @Test
  public void testGetDetails() {
    Employee employee = new Employee(1, "John Doe", "Engineering", 50000);

    String result = employee.getDetails();
    String expected = "The Employee's ID: 1 Name: John Doe Department: Engineering Salary: 50000.0";
    assertThat(result).isEqualTo(expected);
  }

  @Test
  public void testSetDetails() {
    Employee employee = new Employee(1, "John Doe", "Engineering", 50000);
    employee.setDetails("Jane Doe", "Marketing", 60000);

    String result = employee.getDetails();
    String expected = "The Employee's ID: 1 Name: Jane Doe Department: Marketing Salary: 60000.0";
    assertThat(result).isEqualTo(expected);
  }

  @Test
  public void testGetId() {
    Employee employee = new Employee(1, "John Doe", "Engineering", 50000);
    int result = employee.getId();
    assertThat(result).isEqualTo(1);
  }

  @Test
  public void testSetId() {
    Employee employee = new Employee(1, "John Doe", "Engineering", 50000);
    employee.setId(2);
    int result = employee.getId();
    assertThat(result).isEqualTo(2);
  }

  @Test  
  public void testGetName() {
    Employee employee = new Employee(1, "John Doe", "Engineering", 50000);
    String result = employee.getName();
    assertThat(result).isEqualTo("John Doe");
  }
  @Test
  public void testSetName() {
    Employee employee = new Employee(1, "John Doe", "Engineering", 50000);
    employee.setName("Jane Doe");
    String result = employee.getName();
    assertThat(result).isEqualTo("Jane Doe");
  }

  @Test
  public void testGetDepartment() {
    Employee employee = new Employee(1, "John Doe", "Engineering", 50000);
    String result = employee.getDepartment();
    assertThat(result).isEqualTo("Engineering");
  }

  @Test
  public void testSetDepartment() {
    Employee employee = new Employee(1, "John Doe", "Engineering", 50000);
    employee.setDepartment("Marketing");
    String result = employee.getDepartment();
    assertThat(result).isEqualTo("Marketing");
  }
  @Test
  public void testGetSalary() {
    Employee employee = new Employee(1, "John Doe", "Engineering", 50000);
    double result = employee.getSalary();
    assertThat(result).isEqualTo(50000);
  }
  @Test
  public void testSetSalary() {
    Employee employee = new Employee(1, "John Doe", "Engineering", 50000);
    employee.setSalary(60000);
    double result = employee.getSalary();
    assertThat(result).isEqualTo(60000);
  }
  @Test
  public void testAddEmployee() {
    EmployeeManager employeeManager = new EmployeeManager();
    Employee employee = new Employee(1, "John Doe", "Engineering", 50000);
    employeeManager.addEmployee(employee);
    assertThat(employeeManager.getEmployeeCount()).isEqualTo(1);
  }
  @Test
  public void testGetEmployee() {
    EmployeeManager employeeManager = new EmployeeManager();
    Employee employee = new Employee(1, "John Doe", "Engineering", 50000);
    employeeManager.addEmployee(employee);
    Employee result = employeeManager.getEmployee(1);
    assertThat(result).isEqualTo(employee);
  }
  @Test
  public void testUpdateEmployee() {
    EmployeeManager employeeManager = new EmployeeManager();
    Employee employee = new Employee(1, "John Doe", "Engineering", 50000);
    employeeManager.addEmployee(employee);
    employee.setName("Jane Doe");
    employeeManager.updateEmployee(employee);
    Employee result = employeeManager.getEmployee(1);
    assertThat(result.getName()).isEqualTo("Jane Doe");
  }

  @Test
  public void testRemoveEmployee() {
    EmployeeManager employeeManager = new EmployeeManager();
    Employee employee = new  Employee(1, "John Doe", "Engineering", 50000);
    employeeManager.addEmployee(employee);
    employeeManager.removeEmployee(1);
    assertThat(employeeManager.getEmployeeCount()).isEqualTo(0);
  }

  @Test
  public void test
}
