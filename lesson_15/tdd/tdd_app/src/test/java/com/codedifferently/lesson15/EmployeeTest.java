package com.codedifferently.lesson15;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmployeeTest {

  Employee employee;

  @BeforeEach
  void setUp() {
    employee = new Employee(2, "Zoro", "Swordsman", 900000);
  }

  @Test
  void testGetId() {
    int actual = employee.getId();

    assertThat(actual).isEqualTo(2);
  }

  @Test
  void testSetId() {
    employee.setId(3);
    int actual = employee.getId();

    assertThat(actual).isEqualTo(3);
  }

  @Test
  void testGetName() {
    String actual = employee.getName();

    assertThat(actual).isEqualTo("Zoro");
  }

  @Test
  void testSetName() {
    employee.setName("Sanji");
    String actual = employee.getName();

    assertThat(actual).isEqualTo("Sanji");
  }

  @Test
  void testGetDepartment() {
    String actual = employee.getDepartment();

    assertThat(actual).isEqualTo("Swordsman");
  }

  @Test
  void testSetDepartment() {
    employee.setDepartment("Cook");
    String actual = employee.getDepartment();

    assertThat(actual).isEqualTo("Cook");
  }

  @Test
  void testGetSalary() {
    double actual = employee.getSalary();

    assertThat(actual).isEqualTo(900000);
  }

  @Test
  void testSetSalary() {
    employee.setSalary(850000);
    double actual = employee.getSalary();

    assertThat(actual).isEqualTo(850000);
  }

  @Test
  void testGetDetails() {
    String actual = employee.getDetails();

    assertThat(actual).isEqualTo("2 Zoro Swordsman 900000.0");
  }
}
