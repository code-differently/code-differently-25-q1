package com.codedifferently.lesson15;

import com.google.common.annotations.VisibleForTesting;

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
  
    public void testGetDetails() {
      Employee employee = new Employee(id, "Will Smith", department, 101);
      String expected = "Employee Name: Will Smith, id: 101:";
      String actual = employee.getDetails();
  
      assertEquals(expected, actual);
        }
      
        private void assertEquals(String expected, String actual) {
          // TODO Auto-generated method stub
          throw new UnsupportedOperationException("Unimplemented method 'assertEquals'");
        }
      
        public String getDetails() {
      return Details;
  }
}
