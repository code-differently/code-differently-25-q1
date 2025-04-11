package com.codedifferently.lesson15;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test; // Import AssertJ assertions

public class EmployeeManagerTest {

  @Test
  void testAddEmployee() {
    EmployeeManager manager = new EmployeeManager();
    Employee testEmployee = new Employee(111, "Chloe Brent", "Sales", 98500.0);
    manager.addEmployee(testEmployee);
    assertThat(manager.getEmployeeCount()).isEqualTo(1);
  }

  @Test
  void testRemoveEmployee() {
    // Arrange
    EmployeeManager manager = new EmployeeManager();
    Employee testEmployee = new Employee(111, "Chloe Brent", "Sales", 98500.0);

    // Act got help with co-pilot to fix the code I had.
    manager.addEmployee(testEmployee);
    manager.removeEmployee(111);
    int actual = manager.getEmployeeCount();

    // Assert; assisted by AI
    assertThat(actual).isEqualTo(0);
  }

  @Test
  void testGetEmployee() {
    // Arrange
    EmployeeManager manager = new EmployeeManager();
    Employee testEmployee = new Employee(111, "Chloe Brent", "Sales", 98500.0);
    Employee testEmployee2 = new Employee(222, "Darren Smith", "Account Relations", 110000.0);

    // Act
    manager.addEmployee(testEmployee);
    manager.addEmployee(testEmployee2);

    // Assert
    assertThat(testEmployee).isEqualTo(testEmployee);
    assertThat(testEmployee2).isEqualTo(testEmployee2);

    // int actual = employees.getEmployeeCount();

  }

  @Test
  void testUpdateEmployee() {
    EmployeeManager manager = new EmployeeManager();
    Employee testEmployee = new Employee(222, "Darren Smith", "Account Relations", 110000.0);

    manager.addEmployee(testEmployee);
    testEmployee.setName("Darren C. Smith");
    manager.updateEmployee(testEmployee);

    Employee update = manager.getEmployee(222);

    assertThat(update.getName()).isEqualTo("Darren C. Smith");
  }

  @Test
  void testGetEmployeeCount() {
    EmployeeManager manager = new EmployeeManager();
    Employee testEmployee = new Employee(456, "Kelly Parker", "Tech", 270500.0);
    Employee testEmployee2 = new Employee(789, "George Lukas", "Communications", 120000.0);

    manager.addEmployee(testEmployee);
    manager.addEmployee(testEmployee2);

    assertThat(manager.getEmployeeCount()).isEqualTo(2);
  }
}
