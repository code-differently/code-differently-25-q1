package com.codedifferently.lesson15;

import org.junit.jupiter.api.Test;

class Lesson15Test {

  EmployeeManager employeeManager;

  @BeforeEach
  void setUp() {
    employeeManager = new EmployeeManager();
  }

  @Test
  void testaddEmployee() {
    employeeManager.addEmployee("1");
  }
  
  @Test
  void testgetEployee() {
    //assert
  }

  @Test
  void testupdateEmployee() {
    //add stuff
  }

  @Test
  void testremoveEmployee() {
    //add stuff
  }

  @Test
  void testssertEmployeeInCollection() {
    //add stuff
    //throw new is needed
  }

  @Test
  void testgetEmployeeCount() {
    
  }
  
  @Test
  public void testGetGreeting() {
    // Act
    Lesson15.main(null);
  }
}
