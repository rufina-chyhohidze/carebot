package be.kdg.programming3.domain;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "employee_table")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employee_id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "date_of_birth")
    private Timestamp dateOfBirth;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String email;
    private String phone;
    @Column(name = "hire_date")
    private Date hireDate;
    @Column(name = "username", unique = true)
    private String username;
    private String password;

    @Enumerated(EnumType.STRING)
    private EmployeeRole role;

    @Enumerated(EnumType.STRING)
    private EmployeeDepartment department;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ItemRequest> itemRequests;

    public Employee() {}

    public Employee(int employee_id, String firstName, String lastName, Timestamp dateOfBirth, Gender gender, String email, String phone, Date hireDate, String username, String password, EmployeeRole role, EmployeeDepartment department) {
        this.employee_id = employee_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.hireDate = hireDate;
        this.username = username;
        this.password = password;
        this.role = role;
        this.department = department;
    }

    public int getEmployee_id() {return employee_id;}
    public void setEmployee_id(int id) {this.employee_id = id;}
    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}
    public String getLastName() {return lastName;}
    public void setLastName(String lastName) {this.lastName = lastName;}
    public Timestamp getDateOfBirth() {return dateOfBirth;}
    public void setDateOfBirth(Timestamp dateOfBirth) {this.dateOfBirth = dateOfBirth;}
    public Gender getGender() {return gender;}
    public void setGender(Gender gender) {this.gender = gender;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public String getPhone() {return phone;}
    public void setPhone(String phone) {this.phone = phone;}
    public Date getHireDate() {return hireDate;}
    public void setHireDate(Date hireDate) {this.hireDate = hireDate;}
    public String getUsername() {return username;}
    public void setUsername(String username) {this.username = username;}
    public EmployeeRole getRole() {return role;}
    public void setRole(EmployeeRole role) {this.role = role;}
    public EmployeeDepartment getDepartment() {return department;}
    public void setDepartment(EmployeeDepartment department) {this.department = department;}
    public List<ItemRequest> getItemRequests() {return itemRequests;}
    public void setItemRequests(List<ItemRequest> itemRequests) {this.itemRequests = itemRequests;}

    @Override
    public String toString() {
        return "Employee{" +
                "employee_id=" + employee_id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", hireDate=" + hireDate +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", department=" + department +
                '}';
    }
}
