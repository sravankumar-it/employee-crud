package com.example.employeecrud.constant;

public final class SwaggerConstants {

    public static final String API_TITLE = "Employee CRUD API";
    public static final String API_VERSION = "1.0.0";
    public static final String API_DESCRIPTION = "Spring Boot Java 21 employee CRUD API";

    public static final String EMPLOYEE_TAG_NAME = "Employee";
    public static final String EMPLOYEE_TAG_DESCRIPTION = "Employee CRUD operations";

    public static final String CREATE_EMPLOYEE_SUMMARY = "Create employee";
    public static final String GET_ALL_EMPLOYEES_SUMMARY = "Get all employees";
    public static final String GET_EMPLOYEE_BY_ID_SUMMARY = "Get employee by id";
    public static final String UPDATE_EMPLOYEE_SUMMARY = "Update employee";
    public static final String DELETE_EMPLOYEE_SUMMARY = "Delete employee";

    public static final String CREATED_RESPONSE_CODE = "201";
    public static final String OK_RESPONSE_CODE = "200";
    public static final String NO_CONTENT_RESPONSE_CODE = "204";
    public static final String BAD_REQUEST_RESPONSE_CODE = "400";
    public static final String NOT_FOUND_RESPONSE_CODE = "404";
    public static final String CONFLICT_RESPONSE_CODE = "409";

    public static final String EMPLOYEE_CREATED_DESCRIPTION = "Employee created";
    public static final String EMPLOYEE_FOUND_DESCRIPTION = "Employee found";
    public static final String EMPLOYEES_FOUND_DESCRIPTION = "Employees found";
    public static final String EMPLOYEE_UPDATED_DESCRIPTION = "Employee updated";
    public static final String EMPLOYEE_DELETED_DESCRIPTION = "Employee deleted";
    public static final String BAD_REQUEST_DESCRIPTION = "Invalid request";
    public static final String NOT_FOUND_DESCRIPTION = "Employee not found";
    public static final String CONFLICT_DESCRIPTION = "Duplicate employee value";

    private SwaggerConstants() {
    }
}
