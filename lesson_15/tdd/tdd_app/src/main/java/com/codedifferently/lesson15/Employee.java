package com.codedifferently.lesson15;

public class Employee {
  private int id;
  private String name;
  private String department;
  private double salary;
  private String getDetails;

  public Employee(int id, String name, String department, double salary, String getDetails) {
    this.id = id;
    this.name = name;
    this.department = department;
    this.salary = salary;
    this.getDetails = getDetails;
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

  public void setName(String name) {
    this.name = name;
  }

  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public double getSalary() {
    return salary;
  }

  public void setSalary(double salary) {
    this.salary = salary;
  }

  public String getgetDetails() {
    return getDetails;
  }

  public void setgetDetails(String getDetails) {
    this.getDetails = getDetails;
  }
}
