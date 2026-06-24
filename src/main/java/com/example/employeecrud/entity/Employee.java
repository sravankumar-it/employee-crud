package com.example.employeecrud.entity;

import com.example.employeecrud.constant.EntityConstants;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = EntityConstants.EMPLOYEE_TABLE_NAME)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = EntityConstants.ID_COLUMN)
    private Long id;

    @Column(
            name = EntityConstants.EMPLOYEE_CODE_COLUMN,
            nullable = false,
            unique = true,
            length = EntityConstants.EMPLOYEE_CODE_LENGTH
    )
    private String employeeCode;

    @Column(name = EntityConstants.FIRST_NAME_COLUMN, nullable = false, length = EntityConstants.NAME_LENGTH)
    private String firstName;

    @Column(name = EntityConstants.LAST_NAME_COLUMN, nullable = false, length = EntityConstants.NAME_LENGTH)
    private String lastName;

    @Column(name = EntityConstants.EMAIL_COLUMN, nullable = false, unique = true, length = EntityConstants.EMAIL_LENGTH)
    private String email;

    @Column(name = EntityConstants.DEPARTMENT_COLUMN, nullable = false, length = EntityConstants.DEPARTMENT_LENGTH)
    private String department;

    @Column(name = EntityConstants.DESIGNATION_COLUMN, nullable = false, length = EntityConstants.DESIGNATION_LENGTH)
    private String designation;

    @Column(
            name = EntityConstants.SALARY_COLUMN,
            nullable = false,
            precision = EntityConstants.SALARY_PRECISION,
            scale = EntityConstants.SALARY_SCALE
    )
    private BigDecimal salary;

    @Column(name = EntityConstants.JOINING_DATE_COLUMN, nullable = false)
    private LocalDate joiningDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }
}
