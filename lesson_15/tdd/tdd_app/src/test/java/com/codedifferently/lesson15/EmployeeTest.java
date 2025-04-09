package com.codedifferently.lesson15;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class EmployeeTest {
  @Test
  public void getId() {
    var expectedId = 7;

    Employee employee1 = new Employee(7, null, null, 0, null);

    var actual = employee1.getId();

    assertEquals(expectedId, actual);
  }


  @Test 
  public void setId() {
    int expectedId = 7;

    Employee employee1 = new Employee(7, null, null, 0, null);

    employee1.setId(expectedId);

    assertEquals( expectedId, employee1.getId());
  }


  @Test 
  public void getName() {
    var expectedNameString = "Montez";

    Employee employee1 = new Employee(0, "Montez", "", 0, null);

    var actual = employee1.getName();

    assertEquals( expectedNameString, actual);
  }


  @Test 
  public void setName() {
    var expectedNameString = "Montez";

    Employee employee1 = new Employee(0, "Montez", "", 0, null);

    employee1.setName(expectedNameString);

    assertEquals( expectedNameString, employee1.getName());
  }

  @Test 
  public void getDepartment() {
    var expectedString = "Tech";

    Employee employee1 = new Employee(0, null, "Tech", 0, null );

    var actual = employee1.getDepartment();

    assertEquals( expectedString, actual);
  }

  @Test 
  public void setDepartment() {
    var expectedDepartment = "Sales";

    Employee employee1 = new Employee(0, null, "Tech", 0, null);

    employee1.setDepartment("Sales");

    assertEquals( expectedDepartment, employee1.getDepartment());
  }

  @Test 
  public void getSalary() {
    var expectedSalary = 50000;

    Employee employye2 = new Employee( 0, null, null, expectedSalary, null);

    var actual = employye2.getSalary();

    assertEquals( expectedSalary, actual);
  }

  @Test 
  public void setSalary() {
    int expectedSalary = 4200;

    Employee employee1 = new Employee(0, null, null, expectedSalary, null);

    employee1.setSalary(expectedSalary);

    assertEquals( expectedSalary, employee1.getSalary());
  }

  @Test
  public void setDetails() {
    var  expectedDetailString = "Non Hipanic Black";

    Employee employee = new Employee(0, null, null, 0, "Non Hispanic Black");

    var actual = employee.getDetails();

    assertEquals(expectedDetailString, actual);
  }
}



