import static org.assertj.core.api.Assertions.assertThat;

import com.codedifferently.lesson15.Employee;
import org.junit.jupiter.api.Test;

public class EmployeeTest {
  @Test
  public void testGetId() {
    Employee employee = new Employee(1, "Meiko Stephens", "IT", 50000);
    int id = employee.getId();
    assertThat(id).isEqualTo(1);
  }

  @Test
  public void testSetId() {
    Employee employee = new Employee(1, "Meiko Stephens", "IT", 50000);
    employee.setId(2);
    assertThat(employee.getId()).isEqualTo(2);
  }

  @Test
  public void testGetName() {
    Employee employee = new Employee(1, "Meiko Stephens", "IT", 50000);
    String name = employee.getName();
    assertThat(name).isEqualTo("Meiko Stephens");
  }

  @Test
  public void testSetName() {
    Employee employee = new Employee(2, "Meiko Stephens", "IT", 50000);
    employee.setName("John Smith");
    assertThat(employee.getName()).isEqualTo("John Smith");
  }

  @Test
  public void testGetDepartment() {
    Employee employee = new Employee(1, "Meiko Stephens", "IT", 50000);
    String department = employee.getDepartment();
    assertThat(department).isEqualTo("IT");
  }

  @Test
  public void testSetDepartment() {
    Employee employee = new Employee(2, "Meiko Stephens", "IT", 50000);
    employee.setDepartment("HR");
    assertThat(employee.getDepartment()).isEqualTo("HR");
  }

  @Test
  public void testGetSalary() {
    Employee employee = new Employee(1, "Meiko Stephens", "IT", 50000);
    double salary = employee.getSalary();
    assertThat(salary).isEqualTo(50000);
  }

  @Test
  public void testSetSalary() {
    Employee employee = new Employee(1, "Meiko Stephens", "IT", 50000);
    employee.setSalary(40000);
    assertThat(employee.getSalary()).isEqualTo(40000);
  }

  @Test
  public void testGetDetails() {
    Employee employee = new Employee(1, "Meiko Stephens", "IT", 50000);
    String details = employee.getDetails();
    assertThat(details)
        .isEqualTo("Employee's ID: 1 Name: Meiko Stephens Department: IT Salary: 50000.0");
  }

  @Test
  public void testSetDetails() {
    Employee employee = new Employee(1, "Meiko Stephens", "IT", 50000);
    employee.setDetails(2, "John Smith", "HR", 40000);
    String result = employee.getDetails();
    String expected = "Employee's ID: 2 Name: John Smith Department: HR Salary: 40000.0";
    assertThat(result).isEqualTo(expected);
  }
}
