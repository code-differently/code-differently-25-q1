package com.codedifferently.lesson15;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class EmployeeManagerTest {

  @Test
  public void testAddEmployee() {
    EmployeeManager manager = new EmployeeManager();
    Employee employee = new Employee(1, "John Doe", "Engineering", 60000);
    manager.addEmployee(employee);
    assertEquals(1, manager.getEmployeeCount());
  }

  @Test
  public void testGetEmployee() {
    EmployeeManager manager = new EmployeeManager();
    Employee employee = new Employee(1, "John Doe", "Engineering", 60000);
    manager.addEmployee(employee);
    Employee retrievedEmployee = manager.getEmployee(1);
    assertEquals(employee, retrievedEmployee);
  }

  @Test
  public void testUpdateEmployee() {
    EmployeeManager manager = new EmployeeManager();
    Employee employee = new Employee(1, "John Doe", "Engineering", 60000);
    manager.addEmployee(employee);
    employee.setName("Jane Doe");
    manager.updateEmployee(employee);
    Employee updatedEmployee = manager.getEmployee(1);
    assertEquals("Jane Doe", updatedEmployee.getName());
  }

  @Test
  public void testRemoveEmployee() {
    EmployeeManager manager = new EmployeeManager();
    Employee employee = new Employee(1, "John Doe", "Engineering", 60000);
    manager.addEmployee(employee);
    manager.removeEmployee(1);
    assertEquals(0, manager.getEmployeeCount());
  }

  @Test
  public void testGetEmployeeCount() {
    EmployeeManager manager = new EmployeeManager();
    Employee employee1 = new Employee(1, "John Doe", "Engineering", 60000);
    Employee employee2 = new Employee(2, "Jane Doe", "Marketing", 70000);
    manager.addEmployee(employee1);
    manager.addEmployee(employee2);
    assertEquals(2, manager.getEmployeeCount());
  }
}
