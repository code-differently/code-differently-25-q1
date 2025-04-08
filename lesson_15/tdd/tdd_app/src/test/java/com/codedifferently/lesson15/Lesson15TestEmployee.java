package com.codedifferently.lesson15;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Lesson15TestEmployee {

  @Test
  public void getEmployeeId() {
    // Arrange
    var employeeId = 4;

    // Act
    Employee myEmployee = new Employee(employeeId, "", "", 0);

    // Assert
    assertEquals(4, myEmployee.getId());
  }

  @Test
  public void setEmployeeId() {
    // Arrange
    var expectedId = 5;

    // Act
    Employee setEmployee = new Employee(5, "", "", 0);

    // Assert
    assertEquals(expectedId, setEmployee.getId());
  }

  @Test
  public void getName() {
    // Arrange
    var expectedName = "Khai";

    // Act
    Employee nameEmployee = new Employee(0, "Khai", "", 0);

    // Assert
    assertEquals(expectedName, nameEmployee.getName());
  }

  @Test
  public void setName() {
    // Arrange
    var getName = "Khai";

    // Act
    Employee setEmployeeName = new Employee(0, "Khai", "", 0);

    // Assert
    assertEquals(getName, setEmployeeName.getName());
  }

  @Test
  public void getDepartment() {
    // Arrange
    var myDepartment = "Tech";

    // Act
    Employee employeeDepartment = new Employee(0, "", "Tech", 0);

    // Assert
    assertEquals(myDepartment, employeeDepartment.getDepartment());
  }

  @Test
  public void setDepartment() {
    // Arrange
    var expectedDepartment = "Software";

    // Act
    Employee placeDepartment = new Employee(0, "", "Software", 0);

    // Assert
    assertEquals(expectedDepartment, placeDepartment.getDepartment());
  }

  @Test
  public void getSalary() {
    // Arrange
    var mySalary = 1111;

    // Act
    Employee expectedSalary = new Employee(0, "", "", 1111);

    // Assert
    assertEquals(mySalary, expectedSalary.getSalary());
  }

  @Test
  public void setSalary() {
    // Arrange
    var getSalary = 1111;

    // Act
    Employee employeeSalary = new Employee(0, "", "", 1111);

    // Assert
    assertEquals(getSalary, employeeSalary.getSalary());
  }
}
