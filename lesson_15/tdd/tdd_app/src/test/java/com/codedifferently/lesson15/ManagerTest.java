package com.codedifferently.lesson15;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test; // got this from chatGpt

public class ManagerTest {

  EmployeeManager manager;

  @BeforeEach
  void setUp() {
    manager = new EmployeeManager();
  }

  @Test
  void addsEmployeeToMap() {
    Employee newEmployee = new Employee(1, "K", "Tech", 1);
    manager.addEmployee(newEmployee);
    assertThat(manager.getEmployee(1)).isEqualTo(newEmployee);
  }

  @Test
  void nullDepartment() {
    Employee employeeA = new Employee(1, "Keynon", null, 50000);
    manager.addEmployee(employeeA);
    Employee fetched = manager.getEmployee(1);
    assertThat(fetched.getDepartment()).isNull();
  }

  @Test
  void getEmployeeId() {
    Employee employee1 = new Employee(1, "K", "Tech", 0);
    manager.addEmployee(employee1);
    assertThat(manager.getEmployee(1)).isEqualTo(employee1);
  }

  @Test
  void updateEmployee() {
    Employee original = new Employee(1, "John", "Apple", 1);
    manager.addEmployee(original);
    Employee updated = new Employee(1, "K", "Google", 1);
    manager.updateEmployee(updated);
    assertThat(manager.getEmployee(1)).isEqualTo(updated);
  }

  @Test
  void removeEmployee() {
    Employee employee3 = new Employee(5, "Kaci", "nullhora", 50000);
    manager.addEmployee(employee3);
    assertThat(manager.getEmployee(5)).isEqualTo(employee3);
    manager.removeEmployee(5);
    assertThrows(IllegalArgumentException.class, () -> manager.getEmployee(5));
  }

  @Test
  void assertEmployeeInCollection() {
    int id = 1;
    // I used chatgpt to try this method & explain the errors for me
    manager.addEmployee(new Employee(5, null, null, 0));
    assertThatThrownBy(
            () -> {
              manager.getEmployee(id);
            })
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("Employee does not in collection with id " + id);
  }

  @Test
  void getEmployeeCount() {
    manager.addEmployee(new Employee(0, null, null, 0));
    manager.addEmployee(new Employee(2, null, null, 0));
    int employeeCount = manager.getEmployeeCount();
    assertThat(employeeCount).isEqualTo(2);
  }
}
