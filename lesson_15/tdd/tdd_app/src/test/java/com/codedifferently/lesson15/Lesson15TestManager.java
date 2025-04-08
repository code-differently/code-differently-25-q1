package com.codedifferently.lesson15;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Lesson15TestManager {

  EmployeeManager manager;

  @BeforeEach
  void setUp() {
    manager = new EmployeeManager();
  }

  @Test
  void addEmployee_addsEmployeeToMap() {
    Employee newEmployee = new Employee(1, "K", "Tech", 1);
    manager.addEmployee(newEmployee);
    assertThat(manager.getEmployee(1)).isEqualTo(newEmployee);
  }
}
