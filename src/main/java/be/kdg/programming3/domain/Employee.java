package be.kdg.programming3.domain;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "EMPLOYEES")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employee_id;

    private String firstName;
    private String lastName;
    private Timestamp dateOfBirth;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String email;
    private String phone;
//    @Column(name = "hire_date")
//    private Date hireDate;
    @Column(unique = true)
    private String username;
    private String password;
    private String salt;

    @Enumerated(EnumType.STRING)
    private EmployeeRole role;

    @Enumerated(EnumType.STRING)
    private EmployeeDepartment department;

//    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    private List<ItemRequest> itemRequests;

    public Employee() {}

//    public Employee(String firstName, String lastName, Timestamp dateOfBirth, Gender gender, String email, String phone, Date hireDate, String username, String password, EmployeeRole role, EmployeeDepartment department) {
//        this.employee_id = employee_id;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.dateOfBirth = dateOfBirth;
//        this.gender = gender;
//        this.email = email;
//        this.phone = phone;
////        this.hireDate = hireDate;
//        this.username = username;
//        this.password = password;
//        this.role = role;
//        this.department = department;
//    }

public Employee(String firstName, String lastName, Gender gender, EmployeeRole role, String phoneNumber, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.role = role;
        this.phone = phoneNumber;
        this.password = password;
        this.username = firstName + lastName;
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
//    public Date getHireDate() {return hireDate;}
//    public void setHireDate(Date hireDate) {this.hireDate = hireDate;}
    public String getUsername() {return username;}
    public void setUsername(String username) {this.username = username;}
    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}
    public EmployeeRole getRole() {return role;}
    public void setRole(EmployeeRole role) {this.role = role;}
    public EmployeeDepartment getDepartment() {return department;}
    public void setDepartment(EmployeeDepartment department) {this.department = department;}
//    public List<ItemRequest> getItemRequests() {return itemRequests;}
//    public void setItemRequests(List<ItemRequest> itemRequests) {this.itemRequests = itemRequests;}
    public String getSalt() {return salt;}
    public void setSalt(String salt) {this.salt = salt;}

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
//                ", hireDate=" + hireDate +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", department=" + department +
                '}';
    }
}
