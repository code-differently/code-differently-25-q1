package com.codedifferently.lesson15;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Lesson15Test {

  @Test
  public void testLesson15() {
    assertThat(new Lesson15()).isNotNull();
  }

  @Test
  public void testGetGreeting() {
    // Act
    Lesson15.main(null);
  }

  @Test
  public void testGetId() {
    Employee employee1 = new Employee(1999, "SpongeBob", "Krusty Krab", 100.0);

    assertEquals(1999, employee1.getId());
  }

  @Test
  public void testSetId() {
    Employee employee1 = new Employee(1999, "Bob", "Builder", 500.0);
    employee1.setId(2015);

    assertEquals(2015, employee1.getId());
  }

  @Test
  public void testGetName() {
    Employee employee1 = new Employee(1985, "Mario", "Plumber", 999.0);

    assertEquals("Mario", employee1.getName());
  }

  @Test
  public void testSetName() {
    Employee employee1 = new Employee(1965, "Tony", "Chef", 3000.0);
    employee1.setName("Touk");

    assertEquals("Touk", employee1.getName());
  }

  @Test
  public void testGetDepartment() {
    Employee employee1 = new Employee(2007, "Remy", "Chef", 1000.0);

    assertEquals("Chef", employee1.getDepartment());
  }

  @Test
  public void testSetDepartment() {
    Employee employee1 = new Employee(2000, "Yuki Tsunoda", "VCarb", 2200.0);
    employee1.setDepartment("Redbull");

    assertEquals("Redbull", employee1.getDepartment());
  }

  @Test
  public void testGetSalary() {
    Employee employee1 = new Employee(0104, "Krispy", "Computer Engineer", 4000.0);

    assertEquals(4000.0, employee1.getSalary());
  }

  @Test
  public void testSetSalary() {
    Employee employee1 = new Employee(1986, "Takumi", "Delivery", 50.0);
    employee1.setSalary(100.0);

    assertEquals(100.0, employee1.getSalary());
  }

  @Test
  public void testAddEmployee() {
    EmployeeManager manager = new EmployeeManager();
    Employee employee1 = new Employee(1942, "Bob", "Artist", 1.0);

    assertEquals(0, manager.getEmployeeCount());

    manager.addEmployee(employee1);
    assertEquals(1, manager.getEmployeeCount());
  }

  @Test
  public void testGetEmployee() {
    EmployeeManager manager = new EmployeeManager();
    Employee employee1 = new Employee(1985, "Lewis", "Ferrari", 80000000.0);
    manager.addEmployee(employee1);

    assertEquals(employee1, manager.getEmployee(1985));
  }

  @Test
  public void testRemoveEmployee() {
    EmployeeManager manager = new EmployeeManager();
    Employee employee1 = new Employee(1981, "Fernando", "Aston Martin", 1000000.0);
    Employee employee2 = new Employee(1998, "Lance", "Aston Martin", 1.0);
    manager.addEmployee(employee1);
    manager.addEmployee(employee2);

    assertEquals(2, manager.getEmployeeCount());
    manager.removeEmployee(1998);
    assertEquals(1, manager.getEmployeeCount());
  }

  @Test
  public void testGetEmplopyeeCount() {
    EmployeeManager manager = new EmployeeManager();
    Employee employee1 = new Employee(2004, "Evan", "Tech", 8000.0);
    manager.addEmployee(employee1);

    assertEquals(1, manager.getEmployeeCount());
  }
}
