package be.kdg.programming3.service;

import be.kdg.programming3.EmployeeDBException;
import be.kdg.programming3.domain.Employee;
import be.kdg.programming3.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private static final Logger LOG = LoggerFactory.getLogger(EmployeeServiceImpl.class);
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
        LOG.debug("EmployeeServiceImpl instantiated with repository {}", employeeRepository.getClass().getSimpleName());
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }

    @Override
    public Employee createEmployee(Employee employee) {
        try {
            return employeeRepository.createEmployee(employee);
        } catch (EmployeeDBException e) {
            LOG.error("Error creating employee: {}", e.getMessage());
            return null;
        }
    }

    @Override
    public boolean checkIfEmployeeEmailExists(String email) {
        return this.employeeRepository.checkIfEmployeeEmailExists(email);
    }

    @Override
    public boolean checkCorrectPasswordForEmployeeWithEmail(String email, String password) {
        return this.employeeRepository.checkCorrectPasswordForEmployeeWithEmail(email, password);
    }

    @Override
    public Employee getEmployeeByEmail(String email) {
        return this.employeeRepository.getEmployeeByEmail(email);
    }
}
