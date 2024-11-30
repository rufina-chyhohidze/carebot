package be.kdg.programming3.repository;

import be.kdg.programming3.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository {
      Employee createEmployee(Employee employee);
      List<Employee> getAllEmployees();
      Employee findEmployeeById(int id);
      Employee findEmployeeByUsername(String username);
      boolean checkIfEmployeeEmailExists(String email);
      boolean checkCorrectPasswordForEmployeeWithEmail(String email, String password);

      Employee getEmployeeByEmail(String email);
}
