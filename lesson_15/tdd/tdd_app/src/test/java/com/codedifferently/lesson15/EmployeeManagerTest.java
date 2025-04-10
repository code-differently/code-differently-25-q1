package com.codedifferently.lesson15;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class EmployeeManagerTest {
    @Test
    public void testAddEmployee() {
    EmployeeManager manager = new EmployeeManager();
    Employee employee = new Employee(1, "Olivia James", "IT", 100000);
    manager.addEmployee(employee);
    assertThat(manager.getEmployee(1)).isEqualTo(employee);
  }

  @Test 
  public void testGetEmployee() {
    EmployeeManager manager = new EmployeeManager();
    Employee employee = new Employee(1, "Olivia James", "IT", 100000);
    manager.addEmployee(employee);
    assertThat(manager.getEmployee(1)).isEqualTo(employee);
  }

  @Test
  public void testRemoveEmployee () {
    //Arrange
    EmployeeManager manager = new EmployeeManager();
    Employee employee = new Employee(1, "Olivia James", "IT", 100000);
    
    //Act
    manager.addEmployee(employee);
    manager.removeEmployee(1);
    
    //Assertion
    assertThat(manager.getEmployeeCount()).isEqualTo(0);
  }
}



