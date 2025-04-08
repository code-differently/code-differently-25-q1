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
  @Test
  public void testGetId(){
    Employee employee = new Employee(1, "Olivia James", "IT", 100000);
    int id = employee.getId();
    assertThat(id).isEqualTo(1);

  }
@Test
public void testSetId (){
  Employee employee = new Employee(1, "Olivia James", "IT", 100000);
  employee.setId(2);
   assertThat(employee.getId()).isEqualTo(2);
}




}
