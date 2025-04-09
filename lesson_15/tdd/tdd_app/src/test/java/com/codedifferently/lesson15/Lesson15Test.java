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
  public void employee_getID() {
  // Arrange
  int expectID = 12345;
  Employee employee = new Employee(expectID, null, null, 0);

  // Act
  int actualID = employee.getId();

  // Assert
  assertEquals(expectID, actualID);
  }

@Test
public void employee_setID() {
// Arrange
int expectID = 12345;
Employee employee = new Employee(expectID, "Will Smith", "Producing", expectID);

// Act
int actualID = employee.setID();

// Assert
assertEquals(expectID, actualID);

}

@Test
public void getName() {
// Arrange
Employee employee = new Employee(12345, "Will Smith", null, 100000);

// Act
String expected = "Will Smith";

// Assert
String actual = employee.getName();
assertEquals(expected, actual);
}

@Test
public void setName() {
//Arrange
Employee employee = new Employee(12345, "Will Smith", null, 100000);

// Act
String expected = "Will Smith";

// Assert
String actual = employee.getName();
assertEquals(expected, actual);
}

@Test
public void getDepartment() {
//Arrange
Employee employee = new Employee(12345, "Will Smith", "Producing", 0);

// Act
String expected = "Producing";

//Assert 
String actual = employee.getDepartment();
assertEquals(expected, actual);
}

@Test
public void setDepartment() {
//Arrange 
Employee employee = new Employee(12345, "Will Smith", "Producing", 0);

// Act 
String expected = "Producing";

// Assert
String actual = employee.getDepartment();
assertEquals(expected, actual);
}

@Test
public void getSalary() {
// Arrange
Employee employee = new Employee(12345, "Will Smith", "Producing", 50000);

// Act
Short actual = null;
Short expected = null;

// Assert
assertEquals(expected, actual);
}

@Test
public void setSalary(double salary) {
//Arrange 
Employee employee = new Employee(12345, "Will Smith", "Producing", 100000);

// Act
int actualId = employee.setSalary();

Short expected = null;
Short actual = null;
// Assert
assertEquals(expected, actual);
}

}