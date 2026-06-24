package com.example.employeecrud.constant;

public final class ApiConstants {

    public static final String API_V1 = "/api/v1";
    public static final String EMPLOYEES_RESOURCE = "/employees";
    public static final String EMPLOYEES_BASE_PATH = API_V1 + EMPLOYEES_RESOURCE;
    public static final String ID_VARIABLE = "id";
    public static final String ID_PATH = "/{" + ID_VARIABLE + "}";

    private ApiConstants() {
    }
}
