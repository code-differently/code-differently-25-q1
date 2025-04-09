package com.codedifferently.lesson15;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class EmployeeTest {
  @Test
  public void testGetId() {
    Employee employee = new Employee(202, "Scarlett Johansson", "HR", 63278.94);
    int id = employee.getId();
    assertThat(id).isEqualTo(202);
  }

  @Test
  public void testSetId() {
    Employee employee = new Employee(202, "Scarlett Johansson", "HR", 63278.94);
    employee.setId(202);
    assertThat(employee.getId()).isEqualTo(202);
  }

  @Test
  public void testGetName() {
    Employee employee = new Employee(202, "Scarlett Johansson", "HR", 63278.94);
    String name = employee.getName();
    assertThat(name).isEqualTo("Scarlett Johansson");
  }

  @Test
  public void testSetName() {
    Employee employee = new Employee(202, "Scarlett Johansson", "HR", 63278.94);
    employee.setName("Scarlett Johanson");
    assertThat(employee.getName()).isEqualTo("Scarlett Johanson");
  }

  @Test
  public void testGetDepartment() {
    Employee employee = new Employee(202, "Scarlett Johansson", "HR", 63278.94);
    String department = employee.getDepartment();
    assertThat(department).isEqualTo("HR");
  }

  @Test
  public void testSetDepartment() {
    Employee employee = new Employee(202, "Scarlett Johansson", "HR", 63278.94);
    employee.setDepartment("Accounting");
    assertThat(employee.getDepartment()).isEqualTo("Accounting");
  }

  @Test
  public void testGetSalary() {
    Employee employee = new Employee(202, "Scarlett Johansson", "HR", 63278.94);
    double salary = employee.getSalary();
    assertThat(salary).isEqualTo(63278.94);
  }

  @Test
  public void testSetSalary() {
    Employee employee = new Employee(202, "Scarlett Johansson", "HR", 63278.94);
    employee.setSalary(63278.94);
    assertThat(employee.getSalary()).isEqualTo(63278.94);
  }

  @Test
  public void testGetDetails() {
    Employee employee = new Employee(202, "Scarlett Johansson", "HR", 63278.94);
    String details = employee.getDetails();
    assertThat(details)
        .isEqualTo("Employee's ID: 202 Name: Scarlett Johansson Department: HR Salary: 63278.94");
  }

  @Test
  public void testSetDetails() {
    Employee employee = new Employee(202, "Scarlett Johansson", "HR", 63278.94);
    employee.setDetails(202, "Scarlett Johansson", "HR", 63278.94);
    String result = employee.getDetails();
    String expected = "Employee's ID: 202 Name: Scarlett Johansson Department: HR Salary: 63278.94";
    assertThat(result).isEqualTo(expected);
  }
}
