package com.codedifferently.lesson15;

public class Employee {
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

  // Method to get all details of an employee
  public String getDetails() {
    return "The Employee's ID: "
        + id
        + " Name: "
        + name
        + " Department: "
        + department
        + " Salary: "
        + salary;
  }

  // Method to set all employee details at once
  public void setDetails(String name, String department, double salary) {
    this.name = name;
    this.department = department;
    this.salary = salary;
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
}
