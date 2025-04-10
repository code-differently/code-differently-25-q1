package com.codedifferently.lesson15;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

class EmployeeTest {
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

@Test 
public void testGetname (){
  Employee employee = new Employee(1, "Olivia James", "IT", 100000);
  assertThat(employee.getName()).isEqualTo("Olivia James");
}

@Test
public void testSetname (){
  Employee employee = new Employee(1, "Olivia James", "IT", 100000);
  employee.setName("Vicente");
  assertThat(employee.getName().equals("Vicente"));
}

@Test
public void getDepartment(){
    Employee employee= new Employee(1, "Olivia James", "IT", 100000);
     assertThat(employee.getDepartment()).isEqualTo("IT");
}

@Test
public void setDepartment(){
    Employee employee= new Employee(1, "Olivia James", "IT", 100000);
    employee.setDepartment("HR");
     assertThat(employee.getDepartment().equals("HR"));
}

@Test
public void getSalary(){
    Employee employee= new Employee(1, "Olivia James", "IT", 100000);
     assertThat(employee.getSalary()).isEqualTo(100000);
}

@Test
public void setSalary(){
    Employee employee= new Employee(1, "Olivia James", "IT", 100000);
    employee.setSalary(50000);
    assertThat(employee.getSalary()).isEqualTo(50000);
}

@Test
public void getDetails(){
 
    Employee employee = new Employee(1, "Olivia James", "IT", 150000);
    assertThat(employee.getDetails()).isEqualTo("1 Olivia James IT 150000.0");

}

}


