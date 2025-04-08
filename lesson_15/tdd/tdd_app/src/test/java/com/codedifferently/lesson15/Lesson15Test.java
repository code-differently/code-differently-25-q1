package com.codedifferently.lesson15;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lesson15Test {

  @Test
  public void testLesson15() {
    assertThat(new Lesson15()).isNotNull();
  }

  @Test
  public void testGetGreeting() {
    Lesson15.main(null);
  }

  @Test
  public void getId() {
    // Arrange. This initializes an Employee object with an id value, name value, department value,
    // and salary value.
    Employee employee = new Employee(5, "John Bey", "Software Engineering", 200000.0);

    // Act. This retrieves the id value from the Employee object and stores it inside the id
    // variable.
    int id = employee.getId();

    // Assert. This checks if the id value that we retrieved from Employee is equal to 1.
    assertThat(id).isEqualTo(5);
  }

  @Test
  public void setId() {
    // Arrange.
    Employee employee = new Employee(5, "John Bey", "Software Engineering", 200000.0);

    // Act.
    employee.setId(5);

    // Assert.
    assertThat(employee.getId()).isEqualTo(5);
  }

  @Test
  public void getName() {
    // Arrange.
    Employee employee = new Employee(5, "John Bey", "Software Engineering", 200000.0);

    // Act.
    String name = employee.getName();

    // Assert.
    assertThat(name).isEqualTo("John Bey");
  }

  @Test
  public void setName() {
    // Arrange.
    Employee employee = new Employee(5, "John Bey", "Software Engineering", 200000.0);

    // Act.
    employee.setName("John Bey");

    // Assert.
    assertThat(employee.getName()).isEqualTo("John Bey");
  }

  @Test
  public void getDepartment() {
    // Arrange.
    Employee employee = new Employee(5, "John Bey", "Software Engineering", 200000.0);

    // Act.
    String department = employee.getDepartment();

    // Assert.
    assertThat(department).isEqualTo("Software Engineering");
  }

  @Test
  public void setDepartment() {
    // Arrange.
    Employee employee = new Employee(5, "John Bey", "Software Engineering", 200000.0);

    // Act.
    employee.setDepartment("Software Engineering");

    // Assert.
    assertThat(employee.getDepartment()).isEqualTo("Software Engineering");
  }

  @Test
  public void getSalary() {
    // Arrange.
    Employee employee = new Employee(5, "John Bey", "Software Engineering", 200000.0);

    // Act.
    double salary = employee.getSalary();

    // Assert.
    assertThat(salary).isEqualTo(200000.0);
  }

  @Test
  public void setSalary() {
    // Arrange.
    Employee employee = new Employee(5, "John Bey", "Software Engineering", 200000.0);

    // Act.
    employee.setSalary(200000.0);

    // Assert.
    assertThat(employee.getSalary()).isEqualTo(200000.0);
  }

  @Test
  public void testGetDetails() {
    // Arrange.
    Employee employee = new Employee(1, "John Bey", "Software Engineering", 200000.0);

    // Act.
    String result = employee.getDetails();

    // Assert.
    String expected =
        "The Employee's ID: 1 Name: John Bey Department: Software Engineering Salary: 200000.0";
    assertThat(result).isEqualTo(expected);
  }

  @Test
  public void testSetDetails() {
    // Arrange.
    Employee employee = new Employee(1, "John Bey", "Software Engineering", 200000.0);

    // Act.
    employee.setId(1);
    employee.setName("John Bey");
    employee.setDepartment("Software Engineering");
    employee.setSalary(200000.0);

    // Assert.
    String expected =
        "The Employee's ID: 1 Name: John Bey Department: Software Engineering Salary: 200000.0";
    assertThat(employee.getDetails()).isEqualTo(expected);
  }

  // Now it's time for us to test the EmployeeManager class. We will be testing the addEmployee,
  // getEmployee, updateEmployee, removeEmployee, and getEmployeeCount methods.

  @Test
  public void testAddEmployee() {
    // Arrange.
    EmployeeManager employeeManager = new EmployeeManager();
    Employee employee = new Employee(1, "John Bey", "Software Engineering", 200000.0);

    // Act. Puts the employee object into the employeeManager.
    employeeManager.addEmployee(employee);

    // Assert.
    assertThat(employeeManager.getEmployeeCount()).isEqualTo(1);
  }

  @Test
  public void testGetEmployee() {
    // Arrange.
    EmployeeManager employeeManager = new EmployeeManager();
    Employee employee = new Employee(1, "John Bey", "Software Engineering", 200000.0);
    employeeManager.addEmployee(employee);

    // Act.
    Employee retrievedEmployee = employeeManager.getEmployee(1);

    // Assert.
    assertThat(retrievedEmployee).isEqualTo(employee);
  }

  @Test
  public void testUpdateEmployee() {
    // Arrange.
    EmployeeManager employeeManager = new EmployeeManager();
    Employee employee = new Employee(1, "John Bey", "Software Engineering", 200000.0);
    employeeManager.addEmployee(employee);
    Employee updatedEmployee = new Employee(1, "John Doe", "Software Engineering", 250000.0);

    // Act.
    employeeManager.updateEmployee(updatedEmployee);

    // Assert.
    assertThat(employeeManager.getEmployee(1).getName()).isEqualTo("John Doe");
  }

  @Test
  public void testRemoveEmployee() {
    // Arrange.
    EmployeeManager employeeManager = new EmployeeManager();
    Employee employee = new Employee(1, "John Bey", "Software Engineering", 200000.0);
    employeeManager.addEmployee(employee);

    // Act.
    employeeManager.removeEmployee(1);

    // Assert.
    assertThat(employeeManager.getEmployeeCount()).isEqualTo(0);
  }

  @Test
  public void testGetEmployeeCount() {
    // Arrange.
    EmployeeManager employeeManager = new EmployeeManager();
    Employee employee1 = new Employee(1, "John Bey", "Software Engineering", 200000.0);
    Employee employee2 = new Employee(2, "Jane Doe", "Marketing", 150000.0);
    employeeManager.addEmployee(employee1);
    employeeManager.addEmployee(employee2);

    // Act.
    int count = employeeManager.getEmployeeCount();

    // Assert.
    assertThat(count).isEqualTo(2);
  }

  @Test
  public void testAssertEmployeeInCollection() {
    // Arrange.
    EmployeeManager employeeManager = new EmployeeManager();
    Employee employee = new Employee(1, "John Bey", "Software Engineering", 200000.0);
    employeeManager.addEmployee(employee);

    // Act & Assert.
    assertThat(employeeManager.getEmployee(1)).isEqualTo(employee);
  }
}
