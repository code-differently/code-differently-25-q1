package com.codedifferently.lesson15;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;


public class EmployeeManagerTest {

    EmployeeManager manager;

    @BeforeEach 
    void setup(){
        manager = new EmployeeManager();
    }

    @Test
    public void addEmployeeToMap() {
        Employee employee = new Employee(1, "M", "Tech", 50000, "Non Hipanic Black" );
        manager.addEmployee(employee);
    


    // Assert that the employee was added correctly
    assertEquals(manager.getEmployee(1)).isEqualTo(newEmployee);
    }

    @Test 
    public void getEmployee() {
        Employee employee = new Employee(1, "M", "Tech", 50000, "Non Hispanic Black");
        manager.addEmployee(employee);
        assertThat(manager.getEmployee(1)).isEqualTo(employee);
    }

    @Test 
    public void updateEmployee() {
        Employee origin = new Employee(1, "John", "Amazon", 1, "Detail");
        manager.addEmployee(origin);
        Employee updated = new Employee(1, "Mike", "Netflix", 1, "Detail");
        manager.updateEmployee(updated);
        assertEquals(manager.getEmployee(1)). isEqualTo(updated);

    }

    @Test 
    public void removeEmployee() {
        Employee employee1 = new Employee(3, "Jason", "Apple", 3, "Detail" );
        manager.addEmployee(employee1);
       assertEquals(manager.getEmployee(3)).isEqualTo(employee1);
       manager.removeEmployee(3);
       assertThrows(IllegalArgumentException.class, () -> manager.getEmployee(3));

    }
}
