package com.example.employeecrud.controller;

import com.example.employeecrud.constant.MessageConstants;
import com.example.employeecrud.constant.TestConstants;
import com.example.employeecrud.dto.EmployeeRequest;
import com.example.employeecrud.exception.GlobalExceptionHandler;
import com.example.employeecrud.exception.ResourceNotFoundException;
import com.example.employeecrud.service.EmployeeService;
import com.example.employeecrud.util.EmployeeTestDataFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EmployeeController.class)
@Import(GlobalExceptionHandler.class)
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private EmployeeService employeeService;

    @Test
    void createEmployeeShouldReturnCreated() throws Exception {
        when(employeeService.createEmployee(any(EmployeeRequest.class)))
                .thenReturn(EmployeeTestDataFactory.employeeResponse());

        mockMvc.perform(post(TestConstants.EMPLOYEES_ENDPOINT)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(EmployeeTestDataFactory.employeeRequest())))
                .andExpect(status().isCreated())
                .andExpect(jsonPath(TestConstants.JSON_ID).value(TestConstants.EMPLOYEE_ID))
                .andExpect(jsonPath(TestConstants.JSON_EMPLOYEE_CODE).value(TestConstants.EMPLOYEE_CODE))
                .andExpect(jsonPath(TestConstants.JSON_EMAIL).value(TestConstants.EMAIL));

        verify(employeeService).createEmployee(any(EmployeeRequest.class));
    }

    @Test
    void createEmployeeShouldReturnBadRequestForInvalidRequest() throws Exception {
        mockMvc.perform(post(TestConstants.EMPLOYEES_ENDPOINT)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(EmployeeTestDataFactory.invalidEmployeeRequest())))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath(TestConstants.JSON_MESSAGE).value(MessageConstants.VALIDATION_FAILED));

        verifyNoInteractions(employeeService);
    }

    @Test
    void getAllEmployeesShouldReturnOk() throws Exception {
        when(employeeService.getAllEmployees())
                .thenReturn(List.of(EmployeeTestDataFactory.employeeResponse()));

        mockMvc.perform(get(TestConstants.EMPLOYEES_ENDPOINT))
                .andExpect(status().isOk())
                .andExpect(jsonPath(TestConstants.JSON_FIRST_ARRAY_ID).value(TestConstants.EMPLOYEE_ID))
                .andExpect(jsonPath(TestConstants.JSON_FIRST_ARRAY_EMAIL).value(TestConstants.EMAIL));

        verify(employeeService).getAllEmployees();
    }

    @Test
    void getEmployeeByIdShouldReturnOk() throws Exception {
        when(employeeService.getEmployeeById(TestConstants.EMPLOYEE_ID))
                .thenReturn(EmployeeTestDataFactory.employeeResponse());

        mockMvc.perform(get(TestConstants.EMPLOYEE_BY_ID_ENDPOINT, TestConstants.EMPLOYEE_ID))
                .andExpect(status().isOk())
                .andExpect(jsonPath(TestConstants.JSON_ID).value(TestConstants.EMPLOYEE_ID))
                .andExpect(jsonPath(TestConstants.JSON_FIRST_NAME).value(TestConstants.FIRST_NAME));

        verify(employeeService).getEmployeeById(TestConstants.EMPLOYEE_ID);
    }

    @Test
    void getEmployeeByIdShouldReturnNotFound() throws Exception {
        String errorMessage = String.format(MessageConstants.EMPLOYEE_NOT_FOUND_BY_ID, TestConstants.EMPLOYEE_ID);
        when(employeeService.getEmployeeById(TestConstants.EMPLOYEE_ID))
                .thenThrow(new ResourceNotFoundException(errorMessage));

        mockMvc.perform(get(TestConstants.EMPLOYEE_BY_ID_ENDPOINT, TestConstants.EMPLOYEE_ID))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath(TestConstants.JSON_MESSAGE).value(errorMessage));

        verify(employeeService).getEmployeeById(TestConstants.EMPLOYEE_ID);
    }

    @Test
    void updateEmployeeShouldReturnOk() throws Exception {
        when(employeeService.updateEmployee(any(Long.class), any(EmployeeRequest.class)))
                .thenReturn(EmployeeTestDataFactory.updatedEmployeeResponse());

        mockMvc.perform(put(TestConstants.EMPLOYEE_BY_ID_ENDPOINT, TestConstants.EMPLOYEE_ID)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(EmployeeTestDataFactory.updatedEmployeeRequest())))
                .andExpect(status().isOk())
                .andExpect(jsonPath(TestConstants.JSON_ID).value(TestConstants.EMPLOYEE_ID))
                .andExpect(jsonPath(TestConstants.JSON_EMAIL).value(TestConstants.UPDATED_EMAIL));

        verify(employeeService).updateEmployee(any(Long.class), any(EmployeeRequest.class));
    }

    @Test
    void deleteEmployeeShouldReturnNoContent() throws Exception {
        mockMvc.perform(delete(TestConstants.EMPLOYEE_BY_ID_ENDPOINT, TestConstants.EMPLOYEE_ID))
                .andExpect(status().isNoContent());

        verify(employeeService).deleteEmployee(TestConstants.EMPLOYEE_ID);
    }
}
