package com.example.employeecrud.dto;

import com.example.employeecrud.constant.ValidationConstants;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;

public record EmployeeRequest(

        @NotBlank(message = ValidationConstants.EMPLOYEE_CODE_REQUIRED)
        @Size(max = ValidationConstants.EMPLOYEE_CODE_MAX, message = ValidationConstants.EMPLOYEE_CODE_SIZE)
        String employeeCode,

        @NotBlank(message = ValidationConstants.FIRST_NAME_REQUIRED)
        @Size(max = ValidationConstants.NAME_MAX, message = ValidationConstants.FIRST_NAME_SIZE)
        String firstName,

        @NotBlank(message = ValidationConstants.LAST_NAME_REQUIRED)
        @Size(max = ValidationConstants.NAME_MAX, message = ValidationConstants.LAST_NAME_SIZE)
        String lastName,

        @NotBlank(message = ValidationConstants.EMAIL_REQUIRED)
        @Email(message = ValidationConstants.EMAIL_INVALID)
        @Size(max = ValidationConstants.EMAIL_MAX, message = ValidationConstants.EMAIL_SIZE)
        String email,

        @NotBlank(message = ValidationConstants.DEPARTMENT_REQUIRED)
        @Size(max = ValidationConstants.DEPARTMENT_MAX, message = ValidationConstants.DEPARTMENT_SIZE)
        String department,

        @NotBlank(message = ValidationConstants.DESIGNATION_REQUIRED)
        @Size(max = ValidationConstants.DESIGNATION_MAX, message = ValidationConstants.DESIGNATION_SIZE)
        String designation,

        @NotNull(message = ValidationConstants.SALARY_REQUIRED)
        @DecimalMin(value = ValidationConstants.SALARY_MIN_VALUE, inclusive = false, message = ValidationConstants.SALARY_POSITIVE)
        BigDecimal salary,

        @NotNull(message = ValidationConstants.JOINING_DATE_REQUIRED)
        @PastOrPresent(message = ValidationConstants.JOINING_DATE_PAST_OR_PRESENT)
        LocalDate joiningDate
) {
}
