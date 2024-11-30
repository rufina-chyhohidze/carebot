package be.kdg.programming3.service;

import be.kdg.programming3.domain.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee createEmployee(Employee employee);
}
