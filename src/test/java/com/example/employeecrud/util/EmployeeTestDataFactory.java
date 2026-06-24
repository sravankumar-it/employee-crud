package com.example.employeecrud.util;

import com.example.employeecrud.constant.TestConstants;
import com.example.employeecrud.dto.EmployeeRequest;
import com.example.employeecrud.dto.EmployeeResponse;
import com.example.employeecrud.entity.Employee;

public final class EmployeeTestDataFactory {

    private EmployeeTestDataFactory() {
    }

    public static EmployeeRequest employeeRequest() {
        return new EmployeeRequest(
                TestConstants.EMPLOYEE_CODE,
                TestConstants.FIRST_NAME,
                TestConstants.LAST_NAME,
                TestConstants.EMAIL,
                TestConstants.DEPARTMENT,
                TestConstants.DESIGNATION,
                TestConstants.SALARY,
                TestConstants.JOINING_DATE
        );
    }

    public static EmployeeRequest updatedEmployeeRequest() {
        return new EmployeeRequest(
                TestConstants.UPDATED_EMPLOYEE_CODE,
                TestConstants.UPDATED_FIRST_NAME,
                TestConstants.UPDATED_LAST_NAME,
                TestConstants.UPDATED_EMAIL,
                TestConstants.UPDATED_DEPARTMENT,
                TestConstants.UPDATED_DESIGNATION,
                TestConstants.UPDATED_SALARY,
                TestConstants.UPDATED_JOINING_DATE
        );
    }

    public static EmployeeRequest invalidEmployeeRequest() {
        return new EmployeeRequest(
                TestConstants.BLANK_VALUE,
                TestConstants.FIRST_NAME,
                TestConstants.LAST_NAME,
                TestConstants.EMAIL,
                TestConstants.DEPARTMENT,
                TestConstants.DESIGNATION,
                TestConstants.SALARY,
                TestConstants.JOINING_DATE
        );
    }

    public static EmployeeResponse employeeResponse() {
        return new EmployeeResponse(
                TestConstants.EMPLOYEE_ID,
                TestConstants.EMPLOYEE_CODE,
                TestConstants.FIRST_NAME,
                TestConstants.LAST_NAME,
                TestConstants.EMAIL,
                TestConstants.DEPARTMENT,
                TestConstants.DESIGNATION,
                TestConstants.SALARY,
                TestConstants.JOINING_DATE
        );
    }

    public static EmployeeResponse updatedEmployeeResponse() {
        return new EmployeeResponse(
                TestConstants.EMPLOYEE_ID,
                TestConstants.UPDATED_EMPLOYEE_CODE,
                TestConstants.UPDATED_FIRST_NAME,
                TestConstants.UPDATED_LAST_NAME,
                TestConstants.UPDATED_EMAIL,
                TestConstants.UPDATED_DEPARTMENT,
                TestConstants.UPDATED_DESIGNATION,
                TestConstants.UPDATED_SALARY,
                TestConstants.UPDATED_JOINING_DATE
        );
    }

    public static Employee employee() {
        Employee employee = new Employee();
        employee.setId(TestConstants.EMPLOYEE_ID);
        employee.setEmployeeCode(TestConstants.EMPLOYEE_CODE);
        employee.setFirstName(TestConstants.FIRST_NAME);
        employee.setLastName(TestConstants.LAST_NAME);
        employee.setEmail(TestConstants.EMAIL);
        employee.setDepartment(TestConstants.DEPARTMENT);
        employee.setDesignation(TestConstants.DESIGNATION);
        employee.setSalary(TestConstants.SALARY);
        employee.setJoiningDate(TestConstants.JOINING_DATE);
        return employee;
    }

    public static Employee secondEmployee() {
        Employee employee = employee();
        employee.setId(TestConstants.SECOND_EMPLOYEE_ID);
        return employee;
    }
}
