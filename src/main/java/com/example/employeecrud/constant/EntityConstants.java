package com.example.employeecrud.constant;

public final class EntityConstants {

    public static final String EMPLOYEE_TABLE_NAME = "employees";
    public static final String ID_COLUMN = "id";
    public static final String EMPLOYEE_CODE_COLUMN = "employee_code";
    public static final String FIRST_NAME_COLUMN = "first_name";
    public static final String LAST_NAME_COLUMN = "last_name";
    public static final String EMAIL_COLUMN = "email";
    public static final String DEPARTMENT_COLUMN = "department";
    public static final String DESIGNATION_COLUMN = "designation";
    public static final String SALARY_COLUMN = "salary";
    public static final String JOINING_DATE_COLUMN = "joining_date";

    public static final int EMPLOYEE_CODE_LENGTH = 30;
    public static final int NAME_LENGTH = 100;
    public static final int EMAIL_LENGTH = 150;
    public static final int DEPARTMENT_LENGTH = 100;
    public static final int DESIGNATION_LENGTH = 100;
    public static final int SALARY_PRECISION = 12;
    public static final int SALARY_SCALE = 2;

    private EntityConstants() {
    }
}
