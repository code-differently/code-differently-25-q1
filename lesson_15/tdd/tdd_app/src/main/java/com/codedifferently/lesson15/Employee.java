package com.codedifferently.lesson15;



public class Employee {
  private static final String Details = null;
  private int id;
  private String name;
  private String department;
  private double salary;

  public Employee(int id, String name, String department, double salary) {
    this.id = id;
    this.name = name;
    this.department = department;
    this.salary = salary;
  }

  // Getters and setters
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public String getDepartment() {
    return department;
  }

  public double setSalary(int id) {
    return salary;
  }

  // public void testGetDetails() {
  //   Employee employee = new Employee(id, "Will Smith", department, 101);
  //   String expected = "Employee Name: Will Smith, id: 101:";
  //   String actual = employee.getDetails();

  //   assertEquals(expected, actual);
  // }

  public String getDetails() {
    return Details;
  }
}
