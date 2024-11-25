package be.kdg.programming3.service;

import be.kdg.programming3.domain.Employee;
import be.kdg.programming3.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private static final Logger LOG = LoggerFactory.getLogger(DeliveryServiceImpl.class);
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
        LOG.debug("EmployeeServiceImpl instantiated with repository {}", employeeRepository.getClass().getSimpleName());
    }

    @Override
    public List<Employee> getAllEmployees() {
        return List.of();
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }
}
