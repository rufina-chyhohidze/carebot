package be.kdg.programming3.repository;

import be.kdg.programming3.EmployeeDBException;
import be.kdg.programming3.domain.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public Employee createEmployee(Employee employee) {
        try {
            em.persist(employee);
        } catch (Exception e) {
            throw new EmployeeDBException(e.getMessage());
        }
        return employee; // now employee has id
    }

    @Override
    @Transactional
    public List<Employee> getAllEmployees() {
        return em.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
    }

    @Override
    @Transactional
    public Employee findEmployeeById(int id) {
        return em.createQuery("SELECT e FROM Employee e WHERE e.employee_id = :id", Employee.class).setParameter("id", id).getSingleResult();
    }

    @Override
    @Transactional
    public Employee findEmployeeByUsername(String username) {
        return em.createQuery("SELECT e FROM Employee e WHERE e.username = :username", Employee.class).setParameter("username", username).getSingleResult();
    }
}
