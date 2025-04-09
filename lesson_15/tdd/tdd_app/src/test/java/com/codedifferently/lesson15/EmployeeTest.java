package test.java.com.codedifferently.lesson15;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.codedifferently.lesson15.Employee;

public class EmployeeTest {

     @Test
     void getIdTest(){ 
        Employee employee1 = new Employee(1, "John", "Marketing", 50000.0); //Arrange

        int expected = 1;

        int actual = employee1.getId(); //Act

        assertEquals(expected, actual); //Assert

     }

     @Test
     void setIdTest() { //Arrange
      Employee employee1 = new Employee(2, "Gabrielle", "Payroll", 75000.0);

      int expected = 5;

       employee1.setId(5); //Act
       int actual = employee1.getId();

       assertEquals(expected, actual); //Assert

     }
    
     @Test
     void getNameTest() { 
      Employee employee1 = new Employee(1, "Franklin", "Shipping", 45000.0); //Arrange

      String expected = "Franklin";

      String actual = employee1.getName(); //Act

      assertEquals(expected, actual); //Assert
       
     }

     void setNameTest() { 
      Employee employee1 = new Employee(2, "Diana", "Human Resource", 95000.0);
                           //Arrange
      String expected = "Dianna";

      String actual = "Dianna";

      employee1.setName("Dianna"); //Act

      assertEquals(expected, actual); //Assert
    
}

   @Test
     void getDepartmentTest() { 
      Employee employee1 = new Employee(1, "Franklin", "Shipping", 45000.0); //Arrange

      String expected = "Franklin";

      String actual = employee1.getName(); //Act

      assertEquals(expected, actual); //Assert
       
     }










}


