package com.codedifferently.lesson15;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class EmployeeTest {

  @Test
  public void testGetId() {
    // Arrange
    Employee testEmployee = new Employee(123, "Mercedes", "Tech", 1000000);

    // Act
    int actual = testEmployee.getId();

    // Assert
    assertThat(actual).isEqualTo(123);
  }

  @Test
  public void testSetId() {
    // Arrange
    Employee testEmployee = new Employee(123, "Mercedes", "Tech", 1000000);

    // Act
    testEmployee.setId(321);
    int actual = testEmployee.getId();

    // Assert
    assertThat(actual).isEqualTo(321);
  }

  @Test
  public void testGetName() {
    // Arrange
    Employee testEmployee = new Employee(123, "Mercedes", "Tech", 1000000);

    // Act
    String actual = testEmployee.getName();

    // Assert
    assertThat(actual).isEqualTo("Mercedes");
  }

  @Test
  public void testSetName() {
    // Arrange
    Employee testEmployee = new Employee(123, "Mercedes", "Tech", 1000000);

    // Act
    testEmployee.setName("Anthony");
    String actual = testEmployee.getName();

    // Assert
    assertThat(actual).isEqualTo("Anthony");
  }

  @Test
  public void testGetDepartment() {
    // Arrange
    Employee testEmployee = new Employee(123, "Mercedes", "Tech", 1000000);

    // Act
    String actual = testEmployee.getDepartment();

    // Assert
    assertThat(actual).isEqualTo("Tech");
  }

  @Test
  public void testSetDepartment() {
    // Arrange
    Employee testEmployee = new Employee(123, "Mercedes", "Tech", 1000000);

    // Act
    testEmployee.setDepartment("Marketing");
    String actual = testEmployee.getDepartment();

    // Assert
    assertThat(actual).isEqualTo("Marketing");
  }

  @Test
  public void testGetSalary() {
    // Arrange
    Employee testEmployee = new Employee(123, "Mercedes", "Tech", 1000000);

    // Act
    double actual = testEmployee.getSalary();

    // Assert
    assertThat(actual).isEqualTo(1000000);
  }

  @Test
  public void testSetSalary() {
    // Arrange
    Employee testEmployee = new Employee(123, "Mercedes", "Tech", 1000000);

    // Act
    testEmployee.setSalary(5000000);
    double actual = testEmployee.getSalary();

    // Assert
    assertThat(actual).isEqualTo(5000000);
  }

  @Test
  public void testGetDetails() {
    // Arrange
    Employee testEmployee = new Employee(123, "Mercedes", "Tech", 1000000);

    // Act
    String actual = testEmployee.getDetails();

    // Assert
    assertThat(actual)
        .isEqualTo(
            "Employee ID: 123\nEmployee Name: Mercedes\nDepartment: Tech\nSalary: 1000000.0");
  }
}
