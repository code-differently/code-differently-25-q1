package com.codedifferently.lesson15;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

public class Lesson15Test {

  @Test
  public void testMainPrintsGreetingAndEmployeeDetails() {

    PrintStream originalOut = System.out;
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    Lesson15.main(new String[] {});

    System.setOut(originalOut);

    String output = outContent.toString().trim();
    assertThat(output).contains("Hello, World!");
    assertThat(output)
        .contains("Employee's ID: 1 Name: Rasheed Miller Department: IT Salary: 50000.0");
  }

  @Test
  public void testGetGreetingReturnsHelloWorld() {
    String greeting = Lesson15.getGreeting();
    assertThat(greeting).isEqualTo("Hello, World!");
  }

  @Test
  public void testCreateSampleEmployee() {
    Employee emp = Lesson15.createSampleEmployee();
    assertThat(emp.getId()).isEqualTo(1);
    assertThat(emp.getName()).isEqualTo("Rasheed Miller");
    assertThat(emp.getDepartment()).isEqualTo("IT");
    assertThat(emp.getSalary()).isEqualTo(50000.0);
  }
}
