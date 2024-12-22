package be.kdg.programming3.service;

import be.kdg.programming3.EmployeeDBException;
import be.kdg.programming3.config.PBKDF2Util;
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
    private final PBKDF2Util pbkdf2Util;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
        this.pbkdf2Util = new PBKDF2Util();
        LOG.debug("EmployeeServiceImpl instantiated with repository {}", employeeRepository.getClass().getSimpleName());
    }

    @Override
    public Employee createEmployee(Employee employee) {
        try {
            String salt = pbkdf2Util.generateSalt();
            String hashedPassword = pbkdf2Util.hashPassword(employee.getPassword(), salt);

            employee.setPassword(hashedPassword);
            employee.setSalt(salt);

            return employeeRepository.createEmployee(employee);
        } catch (EmployeeDBException e) {
            LOG.error("Error creating employee: {}", e.getMessage());
            return null;
        } catch (Exception e) {
            LOG.error("Error hashing password: {}", e.getMessage());
            throw new RuntimeException("Failed to hash password");
        }
    }

    @Override
    public boolean checkIfEmployeeEmailExists(String email) {
        return this.employeeRepository.checkIfEmployeeEmailExists(email);
    }

    @Override
    public boolean checkCorrectPasswordForEmployeeWithEmail(String email, String password) {
        Employee employee = this.employeeRepository.getEmployeeByEmail(email);
        if (employee == null) {
            return false;
        }

        try {
            return pbkdf2Util.verifyPassword(password, employee.getPassword(), employee.getSalt());
        } catch (Exception e) {
            LOG.error("Error validating password: {}", e.getMessage());
            return false;
        }

    }

    @Override
    public Employee getEmployeeByEmail(String email) {
        return this.employeeRepository.getEmployeeByEmail(email);
    }
}
