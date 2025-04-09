package com.codedifferently.lesson15;

public class Lesson15 {

  public static void main(String[] args) {
    System.out.println(getGreeting()); // This line is needed!

    Employee emp = new Employee(1, "Rasheed Miller", "IT", 50000.0);
    System.out.println(emp.getDetails());
  }

  public static String getGreeting() {
    return "Hello, World!";
  }

  public static Employee createSampleEmployee() {
    return new Employee(1, "Rasheed Miller", "IT", 50000.0);
  }
}
