import static org.assertj.core.api.Assertions.assertThat;

import com.codedifferently.lesson15.Employee;
import org.junit.jupiter.api.Test;

public class EmployeeTest {

  @Test
  public void testGetDetails() {
    // Create an instance of Employee by adding in temporary values
    Employee employee = new Employee(1, "John Doe", "Engineering", 50000);
    // This will call the getDetails method and store that in a variable called result
    String result = employee.getDetails();
    // This will create a string that we expect the getDetails method to return
    String expected = "The Employee's ID: 1 Name: John Doe Department: Engineering Salary: 50000.0";
    // This will compare the result of the getDetails method to the expected string
    assertThat(result).isEqualTo(expected);
  }

  @Test
  public void testSetDetails() {
    Employee employee = new Employee(1, "John Doe", "Engineering", 50000);
    employee.setDetails("Jane Doe", "Marketing", 60000, 1);

    String result = employee.getDetails();
    String expected = "The Employee's ID: 1 Name: Jane Doe Department: Marketing Salary: 60000.0";
    assertThat(result).isEqualTo(expected);
  }

  @Test
  public void testGetId() {
    Employee employee = new Employee(1, "John Doe", "Engineering", 50000);
    int result = employee.getId();
    assertThat(result).isEqualTo(1);
  }

  @Test
  public void testSetId() {
    Employee employee = new Employee(1, "John Doe", "Engineering", 50000);
    employee.setId(2);
    int result = employee.getId();
    assertThat(result).isEqualTo(2);
  }

  @Test
  public void testGetName() {
    Employee employee = new Employee(1, "John Doe", "Engineering", 50000);
    String result = employee.getName();
    assertThat(result).isEqualTo("John Doe");
  }

  @Test
  public void testSetName() {
    Employee employee = new Employee(1, "John Doe", "Engineering", 50000);
    employee.setName("Jane Doe");
    String result = employee.getName();
    assertThat(result).isEqualTo("Jane Doe");
  }

  @Test
  public void testGetDepartment() {
    Employee employee = new Employee(1, "John Doe", "Engineering", 50000);
    String result = employee.getDepartment();
    assertThat(result).isEqualTo("Engineering");
  }

  @Test
  public void testSetDepartment() {
    Employee employee = new Employee(1, "John Doe", "Engineering", 50000);
    employee.setDepartment("Marketing");
    String result = employee.getDepartment();
    assertThat(result).isEqualTo("Marketing");
  }

  @Test
  public void testGetSalary() {
    Employee employee = new Employee(1, "John Doe", "Engineering", 50000);
    double result = employee.getSalary();
    assertThat(result).isEqualTo(50000);
  }

  @Test
  public void testSetSalary() {
    Employee employee = new Employee(1, "John Doe", "Engineering", 50000);
    employee.setSalary(60000);
    double result = employee.getSalary();
    assertThat(result).isEqualTo(60000);
  }
}
