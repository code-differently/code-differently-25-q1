package com.codedifferently.lesson15;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lesson15Test {

  @Test
  public void testLesson15() {
    assertThat(new Lesson15()).isNotNull();
  }

  @Test
  public void testGetGreeting() {}

  // Tests for Employee class

  @Test
  public void testGetId() {
    Employee employee = new Employee(1, "Meiko Stephens", "IT", 50000);
    int id = employee.getId();
    assertThat(id).isEqualTo(1);
  }

  @Test
  public void testSetId() {
    Employee employee = new Employee(1, "Meiko Stephens", "IT", 50000);
    employee.setId(2);
    assertThat(employee.getId()).isEqualTo(2);
  }

  @Test
  public void testGetName() {
    Employee employee = new Employee(1, "Meiko Stephens", "IT", 50000);
    String name = employee.getName();
    assertThat(name).isEqualTo("Meiko Stephens");
  }

  @Test
  public void testSetName() {
    Employee employee = new Employee(2, "Meiko Stephens", "IT", 50000);
    employee.setName("John Smith");
    assertThat(employee.getName()).isEqualTo("John Smith");
  }

  @Test
  public void testGetDepartment() {
    Employee employee = new Employee(1, "Meiko Stephens", "IT", 50000);
    String department = employee.getDepartment();
    assertThat(department).isEqualTo("IT");
  }

  @Test
  public void testSetDepartment() {
    Employee employee = new Employee(2, "Meiko Stephens", "IT", 50000);
    employee.setDepartment("HR");
    assertThat(employee.getDepartment()).isEqualTo("HR");
  }

  @Test
  public void testGetSalary() {
    Employee employee = new Employee(1, "Meiko Stephens", "IT", 50000);
    double salary = employee.getSalary();
    assertThat(salary).isEqualTo(50000);
  }

  @Test
  public void testSetSalary() {
    Employee employee = new Employee(1, "Meiko Stephens", "IT", 50000);
    employee.setSalary(40000);
    assertThat(employee.getSalary()).isEqualTo(40000);
  }

  @Test
  public void testGetDetails(){
    Employee employee = new Employee(1,"Meiko Stephens","IT", 50000);
    String details = employee.getDetails();
    assertThat(details).isEqualTo("Employee's ID: 1 Name: Meiko Stephens Department: IT Salary: 50000.0");
  }

  @Test
  public void testSetDetails(){
    Employee employee = new Employee(1,"Meiko Stephens","IT", 50000);
    employee.setDetails(2,"John Smith","HR",40000);
    String result = employee.getDetails();
    String expected = "Employee's ID: 2 Name: John Smith Department: HR Salary: 40000.0";
    assertThat(result).isEqualTo(expected);
  }

  // Tests for Employer class
  @Test
  public void testAddEmployee() {
    EmployeeManager employeeManager = new EmployeeManager();
    Employee employee = new Employee(1, "Meiko Stephens", "IT", 50000);
    employeeManager.addEmployee(employee);
    assertThat(employeeManager.getEmployeeCount()).isEqualTo(1);
  }

  @Test
  public void testGetEmployee() {
    EmployeeManager employeeManager = new EmployeeManager();
    Employee employee = new Employee(1, "Meiko Stephens", "IT", 50000);
    employeeManager.addEmployee(employee);
    Employee result = employeeManager.getEmployee(1);
    assertThat(result).isEqualTo(employee);
  }

  @Test
  public void testUpdateEmployee() {
    EmployeeManager employeeManager = new EmployeeManager();
    Employee employee = new Employee(1, "Meiko Stephens", "IT", 50000);
    employeeManager.addEmployee(employee);
    employee.setName("John Smith");
    employeeManager.updateEmployee(employee);
    Employee result = employeeManager.getEmployee(1);
    assertThat(result.getName()).isEqualTo("John Smith");
  }

  @Test
  public void testRemoveEmployee() {
    EmployeeManager employeeManager = new EmployeeManager();
    Employee employee = new Employee(1, "Meiko Stephens", "IT", 50000);
    employeeManager.addEmployee(employee);
    employeeManager.removeEmployee(1);
    assertThat(employeeManager.getEmployeeCount()).isEqualTo(0);
  }
}
