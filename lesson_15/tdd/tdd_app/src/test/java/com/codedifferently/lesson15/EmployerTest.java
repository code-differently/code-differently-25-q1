import static org.assertj.core.api.Assertions.assertThat;

import com.codedifferently.lesson15.Employee;
import com.codedifferently.lesson15.EmployeeManager;
import org.junit.jupiter.api.Test;

public class EmployerTest {
  @Test
  public void testAddEmployee() {
    EmployeeManager employeeManager = new EmployeeManager();
    Employee employee = new Employee(1, "Meiko Stephens", "IT", 50000);
    employeeManager.addEmployee(employee);
    assertThat(employeeManager.getEmployeeCount()).isEqualTo(1);
  }

  @Test
  public void testGetEmployee() {
    EmployeeManager employeeManager = new EmployeeManager();
    Employee employee = new Employee(1, "Meiko Stephens", "IT", 50000);
    employeeManager.addEmployee(employee);
    Employee result = employeeManager.getEmployee(1);
    assertThat(result).isEqualTo(employee);
  }

  @Test
  public void testUpdateEmployee() {
    EmployeeManager employeeManager = new EmployeeManager();
    Employee employee = new Employee(1, "Meiko Stephens", "IT", 50000);
    employeeManager.addEmployee(employee);
    employee.setName("John Smith");
    employeeManager.updateEmployee(employee);
    Employee result = employeeManager.getEmployee(1);
    assertThat(result.getName()).isEqualTo("John Smith");
  }

  @Test
  public void testRemoveEmployee() {
    EmployeeManager employeeManager = new EmployeeManager();
    Employee employee = new Employee(1, "Meiko Stephens", "IT", 50000);
    employeeManager.addEmployee(employee);
    employeeManager.removeEmployee(1);
    assertThat(employeeManager.getEmployeeCount()).isEqualTo(0);
  }
}
