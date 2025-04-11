package com.codedifferently.lesson15;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class EmployeeTest {
  private Employee employee;

  @Test
  public void testGetId() {
    employee = new Employee(1, "John Doe", "Engineering", 60000);
    assertEquals(1, employee.getId());
  }

  @Test
  public void testSetId() {
    employee = new Employee(1, "John Doe", "Engineering", 60000);
    employee.setId(2);
    assertEquals(2, employee.getId());
  }

  @Test
  public void testGetName() {
    employee = new Employee(1, "John Doe", "Engineering", 60000);
    assertEquals("John Doe", employee.getName());
  }

  @Test
  public void testSetName() {
    employee = new Employee(1, "John Doe", "Engineering", 60000);
    employee.setName("Jane Doe");
    assertEquals("Jane Doe", employee.getName());
  }

  @Test
  public void testGetDepartment() {
    employee = new Employee(1, "John Doe", "Engineering", 60000);
    assertEquals("Engineering", employee.getDepartment());
  }

  @Test
  public void testGetSalary() {
    employee = new Employee(1, "John Doe", "Engineering", 60000);
    assertEquals(60000, employee.getSalary(), 0.01);
  }

  @Test
  public void testSetSalary() {
    employee = new Employee(1, "John Doe", "Engineering", 60000);
    employee.setSalary(70000);
    assertEquals(70000, employee.getSalary(), 0.01);
  }
}
