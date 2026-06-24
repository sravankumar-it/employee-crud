package com.example.employeecrud.service.impl;

import com.example.employeecrud.constant.MessageConstants;
import com.example.employeecrud.constant.TestConstants;
import com.example.employeecrud.dto.EmployeeResponse;
import com.example.employeecrud.entity.Employee;
import com.example.employeecrud.exception.DuplicateResourceException;
import com.example.employeecrud.exception.ResourceNotFoundException;
import com.example.employeecrud.repository.EmployeeRepository;
import com.example.employeecrud.util.EmployeeTestDataFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @Test
    void createEmployeeShouldSaveEmployee() {
        when(employeeRepository.findByEmail(TestConstants.EMAIL)).thenReturn(Optional.empty());
        when(employeeRepository.findByEmployeeCode(TestConstants.EMPLOYEE_CODE)).thenReturn(Optional.empty());
        when(employeeRepository.save(any(Employee.class))).thenAnswer(invocation -> {
            Employee employee = invocation.getArgument(0);
            employee.setId(TestConstants.EMPLOYEE_ID);
            return employee;
        });

        EmployeeResponse response = employeeService.createEmployee(EmployeeTestDataFactory.employeeRequest());

        assertThat(response.id()).isEqualTo(TestConstants.EMPLOYEE_ID);
        assertThat(response.email()).isEqualTo(TestConstants.EMAIL);
        verify(employeeRepository).save(any(Employee.class));
    }

    @Test
    void createEmployeeShouldThrowDuplicateResourceExceptionForDuplicateEmail() {
        when(employeeRepository.findByEmail(TestConstants.EMAIL))
                .thenReturn(Optional.of(EmployeeTestDataFactory.secondEmployee()));

        assertThatThrownBy(() -> employeeService.createEmployee(EmployeeTestDataFactory.employeeRequest()))
                .isInstanceOf(DuplicateResourceException.class)
                .hasMessage(String.format(MessageConstants.EMPLOYEE_EMAIL_EXISTS, TestConstants.EMAIL));

        verify(employeeRepository, never()).save(any(Employee.class));
    }

    @Test
    void getAllEmployeesShouldReturnEmployees() {
        when(employeeRepository.findAll()).thenReturn(List.of(EmployeeTestDataFactory.employee()));

        List<EmployeeResponse> responses = employeeService.getAllEmployees();

        assertThat(responses).hasSize(TestConstants.EMPLOYEE_ID.intValue());
        assertThat(responses.get(0).employeeCode()).isEqualTo(TestConstants.EMPLOYEE_CODE);
        verify(employeeRepository).findAll();
    }

    @Test
    void getEmployeeByIdShouldReturnEmployee() {
        when(employeeRepository.findById(TestConstants.EMPLOYEE_ID))
                .thenReturn(Optional.of(EmployeeTestDataFactory.employee()));

        EmployeeResponse response = employeeService.getEmployeeById(TestConstants.EMPLOYEE_ID);

        assertThat(response.id()).isEqualTo(TestConstants.EMPLOYEE_ID);
        assertThat(response.firstName()).isEqualTo(TestConstants.FIRST_NAME);
        verify(employeeRepository).findById(TestConstants.EMPLOYEE_ID);
    }

    @Test
    void getEmployeeByIdShouldThrowResourceNotFoundException() {
        when(employeeRepository.findById(TestConstants.EMPLOYEE_ID)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> employeeService.getEmployeeById(TestConstants.EMPLOYEE_ID))
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessage(String.format(MessageConstants.EMPLOYEE_NOT_FOUND_BY_ID, TestConstants.EMPLOYEE_ID));
    }

    @Test
    void updateEmployeeShouldSaveEmployee() {
        when(employeeRepository.findById(TestConstants.EMPLOYEE_ID))
                .thenReturn(Optional.of(EmployeeTestDataFactory.employee()));
        when(employeeRepository.findByEmail(TestConstants.UPDATED_EMAIL)).thenReturn(Optional.empty());
        when(employeeRepository.findByEmployeeCode(TestConstants.UPDATED_EMPLOYEE_CODE)).thenReturn(Optional.empty());
        when(employeeRepository.save(any(Employee.class))).thenAnswer(invocation -> invocation.getArgument(0));

        EmployeeResponse response = employeeService.updateEmployee(
                TestConstants.EMPLOYEE_ID,
                EmployeeTestDataFactory.updatedEmployeeRequest()
        );

        assertThat(response.email()).isEqualTo(TestConstants.UPDATED_EMAIL);
        assertThat(response.designation()).isEqualTo(TestConstants.UPDATED_DESIGNATION);
        verify(employeeRepository).save(any(Employee.class));
    }

    @Test
    void deleteEmployeeShouldDeleteEmployee() {
        Employee employee = EmployeeTestDataFactory.employee();
        when(employeeRepository.findById(TestConstants.EMPLOYEE_ID)).thenReturn(Optional.of(employee));

        employeeService.deleteEmployee(TestConstants.EMPLOYEE_ID);

        verify(employeeRepository).delete(employee);
    }
}
