package com.codedifferently.lesson15;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

 public class EmployeeTest{




    @Test
    public void testGetDetails() {
        // Arrange
        Employee employee = new Employee(1, "Justin Eklund", "Software Engineering", 5000000);
    
        // Act
        String details = employee.getDetails();
    
        // Assert
        assertThat(details).isEqualTo("1 Justin Eklund Software Engineering 5000000.0");
    }
    
    @Test
    public void testGetId() {
        // Arrange
        Employee employee = new Employee(1, "Justin Eklund", "Software Engineering", 5000000);
    
        // Act
        int id = employee.getId();
    
        // Assert
        assertThat(id).isEqualTo(1);
    }
    @Test
    public void testSetId() {
        // Arrange
        Employee employee = new Employee(1, "Justin Eklund", "Software Engineering", 5000000);
    
        // Act
        employee.setId(2);
    
        // Assert
        assertThat(employee.getId()).isEqualTo(2);
    }
    @Test
    public void testGetName() {
        // Arrange
        Employee employee = new Employee(1, "Justin Eklund", "Software Engineering", 5000000);
    
        // Act
        String name = employee.getName();
    
        // Assert
        assertThat(name).isEqualTo("Justin Eklund");
    }
    @Test
    public void testSetName() {
        // Arrange
        Employee employee = new Employee(1, "Justin Eklund", "Software Engineering", 5000000);
    
        // Act
        employee.setName("John Doe");
    
        // Assert
        assertThat(employee.getName()).isEqualTo("J");
    }
    @Test
    public void testGetDepartment() {
        // Arrange
        Employee employee = new Employee(1, "Justin Eklund", "Software Engineering", 5000000);
    
        // Act
        String department = employee.getDepartment();
    
        // Assert
        assertThat(department).isEqualTo("Software Engineering");
    }
    @Test
    public void testSetDepartment() {
        // Arrange
        Employee employee = new Employee(1, "Justin Eklund", "Software Engineering", 5000000);
    
        // Act
        employee.setDepartment("Marketing");
    
        // Assert
        assertThat(employee.getDepartment()).isEqualTo("Marketing");
    }
    @Test
    public void testGetSalary() {
        // Arrange
        Employee employee = new Employee(1, "Justin Eklund", "Software Engineering", 5000000);
    
        // Act
        double salary = employee.getSalary();
    
        // Assert
        assertThat(salary).isEqualTo(5000000);
    }
    @Test
    public void testSetSalary() {
        // Arrange
        Employee employee = new Employee(1, "Justin Eklund", "Software Engineering", 5000000);
    
        // Act
        employee.setSalary(6000000);
    
        // Assert
        assertThat(employee.getSalary()).isEqualTo(6000000);
    }
 }