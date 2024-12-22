package be.kdg.programming3.service;

import be.kdg.programming3.domain.Employee;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(Employee employee);
    boolean checkIfEmployeeEmailExists(String email);
    boolean checkCorrectPasswordForEmployeeWithEmail(String email, String password);
    Employee getEmployeeByEmail(String email);
}
