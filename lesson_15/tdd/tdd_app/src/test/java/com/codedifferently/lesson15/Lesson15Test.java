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
    
  }

  @Test
  public void testGetDetails() {
    Employee employee = new Employee(1, "John Doe", "Engineering", 50000);

    String result = employee.getDetails();
    String expected = "The Employee's ID: 1 Name: John Doe Department: Engineering Salary: 50000.0";
    assertThat(result).isEqualTo(expected);
  }
}
