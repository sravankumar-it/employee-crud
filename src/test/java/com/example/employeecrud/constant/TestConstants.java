package com.example.employeecrud.constant;

import com.example.employeecrud.constant.ApiConstants;

import java.math.BigDecimal;
import java.time.LocalDate;

public final class TestConstants {

    public static final Long EMPLOYEE_ID = 1L;
    public static final Long SECOND_EMPLOYEE_ID = 2L;
    public static final String EMPLOYEE_CODE = "EMP-001";
    public static final String UPDATED_EMPLOYEE_CODE = "EMP-002";
    public static final String FIRST_NAME = "John";
    public static final String UPDATED_FIRST_NAME = "Jane";
    public static final String LAST_NAME = "Doe";
    public static final String UPDATED_LAST_NAME = "Smith";
    public static final String EMAIL = "john.doe@example.com";
    public static final String UPDATED_EMAIL = "jane.smith@example.com";
    public static final String DEPARTMENT = "Engineering";
    public static final String UPDATED_DEPARTMENT = "Product";
    public static final String DESIGNATION = "Software Engineer";
    public static final String UPDATED_DESIGNATION = "Product Manager";
    public static final BigDecimal SALARY = BigDecimal.valueOf(75000L);
    public static final BigDecimal UPDATED_SALARY = BigDecimal.valueOf(90000L);
    public static final LocalDate JOINING_DATE = LocalDate.of(2024, 1, 15);
    public static final LocalDate UPDATED_JOINING_DATE = LocalDate.of(2024, 6, 10);
    public static final String BLANK_VALUE = "";

    public static final String EMPLOYEES_ENDPOINT = ApiConstants.EMPLOYEES_BASE_PATH;
    public static final String EMPLOYEE_BY_ID_ENDPOINT = ApiConstants.EMPLOYEES_BASE_PATH + ApiConstants.ID_PATH;

    public static final String JSON_ID = "$.id";
    public static final String JSON_EMPLOYEE_CODE = "$.employeeCode";
    public static final String JSON_FIRST_NAME = "$.firstName";
    public static final String JSON_EMAIL = "$.email";
    public static final String JSON_MESSAGE = "$.message";
    public static final String JSON_FIRST_ARRAY_ID = "$[0].id";
    public static final String JSON_FIRST_ARRAY_EMAIL = "$[0].email";

    private TestConstants() {
    }
}
