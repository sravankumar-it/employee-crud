package com.example.employeecrud.service.impl;

import com.example.employeecrud.constant.MessageConstants;
import com.example.employeecrud.dto.EmployeeRequest;
import com.example.employeecrud.dto.EmployeeResponse;
import com.example.employeecrud.entity.Employee;
import com.example.employeecrud.exception.DuplicateResourceException;
import com.example.employeecrud.exception.ResourceNotFoundException;
import com.example.employeecrud.mapper.EmployeeMapper;
import com.example.employeecrud.repository.EmployeeRepository;
import com.example.employeecrud.service.EmployeeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeResponse createEmployee(EmployeeRequest request) {
        validateUniqueEmployee(request.email(), request.employeeCode(), null);
        Employee employee = EmployeeMapper.toEntity(request);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.toResponse(savedEmployee);
    }

    @Override
    @Transactional(readOnly = true)
    public List<EmployeeResponse> getAllEmployees() {
        return employeeRepository.findAll()
                .stream()
                .map(EmployeeMapper::toResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public EmployeeResponse getEmployeeById(Long id) {
        return EmployeeMapper.toResponse(findEmployeeById(id));
    }

    @Override
    public EmployeeResponse updateEmployee(Long id, EmployeeRequest request) {
        Employee employee = findEmployeeById(id);
        validateUniqueEmployee(request.email(), request.employeeCode(), id);
        EmployeeMapper.updateEntity(employee, request);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.toResponse(savedEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee employee = findEmployeeById(id);
        employeeRepository.delete(employee);
    }

    private Employee findEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format(MessageConstants.EMPLOYEE_NOT_FOUND_BY_ID, id)
                ));
    }

    private void validateUniqueEmployee(String email, String employeeCode, Long currentEmployeeId) {
        employeeRepository.findByEmail(email)
                .filter(employee -> isDifferentEmployee(employee, currentEmployeeId))
                .ifPresent(employee -> {
                    throw new DuplicateResourceException(
                            String.format(MessageConstants.EMPLOYEE_EMAIL_EXISTS, email)
                    );
                });

        employeeRepository.findByEmployeeCode(employeeCode)
                .filter(employee -> isDifferentEmployee(employee, currentEmployeeId))
                .ifPresent(employee -> {
                    throw new DuplicateResourceException(
                            String.format(MessageConstants.EMPLOYEE_CODE_EXISTS, employeeCode)
                    );
                });
    }

    private boolean isDifferentEmployee(Employee employee, Long currentEmployeeId) {
        return currentEmployeeId == null || !Objects.equals(employee.getId(), currentEmployeeId);
    }
}
