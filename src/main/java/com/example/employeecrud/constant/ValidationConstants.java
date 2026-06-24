package com.example.employeecrud.constant;

public final class ValidationConstants {

    public static final String EMPLOYEE_CODE_REQUIRED = "Employee code is required";
    public static final String FIRST_NAME_REQUIRED = "First name is required";
    public static final String LAST_NAME_REQUIRED = "Last name is required";
    public static final String EMAIL_REQUIRED = "Email is required";
    public static final String EMAIL_INVALID = "Email must be valid";
    public static final String DEPARTMENT_REQUIRED = "Department is required";
    public static final String DESIGNATION_REQUIRED = "Designation is required";
    public static final String SALARY_REQUIRED = "Salary is required";
    public static final String SALARY_MIN_VALUE = "0.0";
    public static final String SALARY_POSITIVE = "Salary must be greater than zero";
    public static final String JOINING_DATE_REQUIRED = "Joining date is required";
    public static final String JOINING_DATE_PAST_OR_PRESENT = "Joining date cannot be in the future";

    public static final int EMPLOYEE_CODE_MAX = 30;
    public static final int NAME_MAX = 100;
    public static final int EMAIL_MAX = 150;
    public static final int DEPARTMENT_MAX = 100;
    public static final int DESIGNATION_MAX = 100;

    public static final String EMPLOYEE_CODE_SIZE = "Employee code must be at most 30 characters";
    public static final String FIRST_NAME_SIZE = "First name must be at most 100 characters";
    public static final String LAST_NAME_SIZE = "Last name must be at most 100 characters";
    public static final String EMAIL_SIZE = "Email must be at most 150 characters";
    public static final String DEPARTMENT_SIZE = "Department must be at most 100 characters";
    public static final String DESIGNATION_SIZE = "Designation must be at most 100 characters";

    private ValidationConstants() {
    }
}
