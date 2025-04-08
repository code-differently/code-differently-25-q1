package com.codedifferently.lesson15;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class EmployeeManagerTest {

  @Test
  public void testAddEmployee() {
    // Arrange
    EmployeeManager employees = new EmployeeManager();
    Employee testEmployee = new Employee(123, "Mercedes", "Tech", 1000000);

    // Act
    employees.addEmployee(testEmployee);
    int actual = employees.getEmployeeCount();

    // Assert
    assertThat(actual).isEqualTo(1);
  }

  @Test
  public void testGetEmployee() {
    // Arrange
    EmployeeManager employees = new EmployeeManager();
    Employee testEmployee = new Employee(123, "Mercedes", "Tech", 1000000);

    // Act
    employees.addEmployee(testEmployee);
    Employee actualEmployee = employees.getEmployee(123);

    // Assert
    assertThat(actualEmployee).isNotNull();
    assertThat(actualEmployee.getName()).isEqualTo("Mercedes");
  }

  @Test
  public void testRemoveEmployee() {
    // Arrange
    EmployeeManager employees = new EmployeeManager();
    Employee testEmployee = new Employee(123, "Mercedes", "Tech", 1000000);

    // Act
    employees.addEmployee(testEmployee);
    employees.removeEmployee(123);
    int actual = employees.getEmployeeCount();

    // Assert
    assertThat(actual).isEqualTo(0);
  }

  @Test
  public void testGetEmployeeCount() {
    // Arrange
    EmployeeManager employees = new EmployeeManager();
    Employee testEmployee = new Employee(123, "Mercedes", "Tech", 1000000);
    Employee testEmployee2 = new Employee(456, "Anthony", "Tech", 1000000);

    // Act
    employees.addEmployee(testEmployee);
    employees.addEmployee(testEmployee2);
    int actual = employees.getEmployeeCount();

    // Assert
    assertThat(actual).isEqualTo(2);
  }
}
