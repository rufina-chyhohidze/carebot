package be.kdg.programming3.domain;

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private EmployeeRole role;
    private EmployeeDepartment department;

    public Employee(int id, String firstName, String lastName, EmployeeRole role, EmployeeDepartment department) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.department = department;
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

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
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", role=" + role +
                ", department=" + department +
                '}';
    }
}
