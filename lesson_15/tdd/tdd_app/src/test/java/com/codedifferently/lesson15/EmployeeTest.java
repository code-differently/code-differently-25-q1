package com.codedifferently.lesson15;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class EmployeeTest {

  @Test
  void getIdTest() {
    Employee employee1 = new Employee(1, "John", "Marketing", 50000.0); // Arrange

    int expected = 1;

    int actual = employee1.getId(); // Act

    assertEquals(expected, actual); // Assert
  }

  @Test
  void setIdTest() { // Arrange
    Employee employee1 = new Employee(2, "Gabrielle", "Payroll", 75000.0);

    int expected = 5;

    employee1.setId(5); // Act
    int actual = employee1.getId();

    assertEquals(expected, actual); // Assert
  }

  @Test
  void getNameTest() {
    Employee employee1 = new Employee(1, "Franklin", "Shipping", 45000.0); // Arrange

    String expected = "Franklin";

    String actual = employee1.getName(); // Act

    assertEquals(expected, actual); // Assert
  }

  @Test
  void setNameTest() {
    Employee employee1 = new Employee(2, "Diana", "Human Resource", 95000.0);
    // Arrange
    employee1.setName("Dianna");

    String actual = employee1.getName();

    // Act

    assertEquals("Dianna", actual); // Assert
  }

  @Test
  void getDepartmentTest() {
    Employee employee1 = new Employee(1, "Franklin", "Shipping", 45000.0); // Arrange

    String expected = "Shipping";

    String actual = employee1.getDepartment(); // Act

    assertEquals(expected, actual); // Assert
  }

  @Test
  void setDepartmentTest() { // Arrange
    Employee employee1 = new Employee(2, "Diana", "Human Resource", 95000.0);
    // Act
    employee1.setDepartment("Executive Director");

    String actual = employee1.getDepartment();

    assertEquals("Executive Director", actual); // Assert
  }

  @Test
  void getSalaryTest() {
    Employee employee1 = new Employee(1, "Franklin", "Shipping", 45000.0); // Arrange

    double expected = 45000.0;
    // Act
    double actual = employee1.getSalary();

    assertEquals(expected, actual); // Assert
  }

  @Test
  void setSalaryTest() { // Arrange
    Employee employee1 = new Employee(2, "Gabrielle", "Payroll", 75000.0);
    employee1.setSalary(91000.0);
    // Act
    double actual = employee1.getSalary();

    assertEquals(91000.0, actual); // Assert
  }

  @Test
  public void getDetailsTest() {
    Employee employees = new Employee(12, "Valerie Cooper", "Executive Offices", 250000.0);
    assertThat(employees.getDetails()).isEqualTo("12 Valerie Cooper Executive Offices 250000.0");
  }
}
