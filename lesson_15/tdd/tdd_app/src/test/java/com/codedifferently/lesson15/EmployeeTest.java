package com.codedifferently.lesson15;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class EmployeeTest {

  @Test
  public void getEmployeeId() {
    // given
    Employee employee = new Employee(1, "Ken", "Tech", 80);
    // when
    int expected = 1;
    int actual = employee.getId();
    // then
    assertEquals(expected, actual);
  }

  @Test
  public void setEmployeeId() {
    // given
    Employee employee = new Employee(1, "Kushmir", "Tech", 80);
    // when
    employee.setId(1);
    // then
    int expected = 1;
    int actual = employee.getId();

    assertEquals(expected, actual);
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
    // given
    Employee employee = new Employee(2, "jamie", "2k", 600);

    // when
    employee.setName("Kody");
    String actual = employee.getName();
    // then
    assertEquals("Kody", actual);
    ;
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
    Employee employee = new Employee(2, "jamie", "hacker", 600);

    // when
    employee.setDepartment("hacker");
    String actual = employee.getDepartment();
    // then
    assertEquals("hacker", actual);
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

  @Test
  public void getDetails() {
    Employee employee1 = new Employee(1, "Karsen", "Football", 25);
    String details = employee1.getDetails();

    assertThat(details).isEqualTo("Employee ID: 1, Name: Karsen, Department: Football, Salary: 25");
  }

  @Test
  public void testZeroSalary() {
    Employee employee2 = new Employee(1, "Khayla", "Engineering", 50000);
    employee2.setSalary(0);
    assertThat(employee2.getSalary()).isEqualTo(0);
  }

  @Test
  public void negativeSalary() {
    Employee employee3 = new Employee(2, "Sonya", null, 9999);
    employee3.setSalary(-800);
    assertThat(employee3.getSalary()).isEqualTo(-800);
  }
}
