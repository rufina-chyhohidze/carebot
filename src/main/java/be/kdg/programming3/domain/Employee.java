package be.kdg.programming3.domain;

import jakarta.persistence.*;

//@Entity
//@Table(name = "employee_table")
public class Employee {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employee_id;

    private String firstName;
    private String lastName;
    private EmployeeRole role;
    private EmployeeDepartment department;

    public Employee() {}

    public Employee(int employee_id, String firstName, String lastName, EmployeeRole role, EmployeeDepartment department) {
        this.employee_id = employee_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.department = department;
    }

    public int getEmployee_id() {return employee_id;}
    public void setEmployee_id(int id) {this.employee_id = id;}

    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}

    public String getLastName() {return lastName;}
    public void setLastName(String lastName) {this.lastName = lastName;}

    public EmployeeRole getRole() {return role;}
    public void setRole(EmployeeRole role) {this.role = role;}

    public EmployeeDepartment getDepartment() {return department;}
    public void setDepartment(EmployeeDepartment department) {this.department = department;}

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + employee_id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", role=" + role +
                ", department=" + department +
                '}';
    }
}
