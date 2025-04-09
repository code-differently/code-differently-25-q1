package com.codedifferently.lesson15;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class EmployeeManagerTest {

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
    Employee employee = new Employee(1, "John Doe", "Engineering", 50000);
    employeeManager.addEmployee(employee);
    employeeManager.removeEmployee(1);
    assertThat(employeeManager.getEmployeeCount()).isEqualTo(0);
  }

  @Test
  public void testEmployeeCount() {
    EmployeeManager employeeManager = new EmployeeManager();
    Employee employee1 = new Employee(1, "John Doe", "Engineering", 50000);
    Employee employee2 = new Employee(2, "Jane Doe", "Marketing", 60000);
    employeeManager.addEmployee(employee1);
    employeeManager.addEmployee(employee2);
    int result = employeeManager.getEmployeeCount();
    assertThat(result).isEqualTo(2);
  }

  @Test
  public void assertEmployeeInCollection() {
    EmployeeManager employeeManager = new EmployeeManager();
    Employee employee = new Employee(1, "John Doe", "Engineering", 50000);
    employeeManager.addEmployee(employee);
    try {
      employeeManager.getEmployee(1);
    } catch (IllegalArgumentException e) {
      // This should not happen
      assertThat(e.getMessage()).isEqualTo("Employee does not exist in collection with id 1");
    }
  }
}
