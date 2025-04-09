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
    // Act
    Lesson15.main(null);
  }

  // @Test
  // public void getId() {
  //   var expectedId = 7;

  //   Employee employee1 = new Employee(7, "Montez", "", 0);

  //   var actual = employee1.getId();

  //   assertEquals(expectedId, actual);
  // }


  // @Test 
  // public void setId() {
  //   int expectedId = 7;

  //   Employee employee1 = new Employee(7, "Montez", "", 0);

  //   employee1.setId(42);

  //   assertEquals(42, emp.getId();)
  // }


  // @Test 
  // public void getName() {
  //   String expectedNameString = "Montez";

  //   Employee employee1 = new Employee(0, "Montez", "", 0);

  //   var actual = employee1.getName();

  //   assertEquals( expectedNameString, actual);
  // }


  // @Test 
  // public void setName() {
  //   int expectedString = "Montez";

  //   Employee employee1 = new Employee(0, "Montez", "", 0);

  //   employee1.setId(42);

  //   assertEquals(42, emp.getName();)
  // }

  // @test 
  // public void getDepartment() {
  //   String expectedString = "";

  //   Employee employee1 = new Employee(0, "Montez", "", 0 );

  //   var actual = expectedString.getDepartment();

  //   assertEquals( expectedString, actual);
  // }

  // @Test 
  // public void setDepartment() {
  //   int expectedDepartment = "Sales";

  //   Employee employee1 = new Employee(0, "", "Tech", 0);

  //   employee1.setDepartment("Sales");

  //   assertEquals("", employee1.getDepartment());
  // }

  // @test 
  // public void getSalary() {
  //   var expectedSalary = 50000;

  //   Employee employye2 = new Employee( 0, "", "", expectedSalary);

  //   var actual = employee2.getSalary();

  //   assertEquals( expectedSalary, actual);
  // }

  // @Test 
  // public void setSalary() {
  //   int expectedSalary = 4200;

  //   Employee employee1 = new Employee(7, "Montez", "", expectedSalary);

  //   employee1.setSalary(4200);

  //   assertEquals(4200, employee1.getSalary());
  // }
}
