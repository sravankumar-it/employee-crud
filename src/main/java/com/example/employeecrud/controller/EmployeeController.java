package com.example.employeecrud.controller;

import com.example.employeecrud.constant.ApiConstants;
import com.example.employeecrud.constant.SwaggerConstants;
import com.example.employeecrud.dto.EmployeeRequest;
import com.example.employeecrud.dto.EmployeeResponse;
import com.example.employeecrud.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(ApiConstants.EMPLOYEES_BASE_PATH)
@Tag(name = SwaggerConstants.EMPLOYEE_TAG_NAME, description = SwaggerConstants.EMPLOYEE_TAG_DESCRIPTION)
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    @Operation(summary = SwaggerConstants.CREATE_EMPLOYEE_SUMMARY)
    @ApiResponses({
            @ApiResponse(
                    responseCode = SwaggerConstants.CREATED_RESPONSE_CODE,
                    description = SwaggerConstants.EMPLOYEE_CREATED_DESCRIPTION
            ),
            @ApiResponse(
                    responseCode = SwaggerConstants.BAD_REQUEST_RESPONSE_CODE,
                    description = SwaggerConstants.BAD_REQUEST_DESCRIPTION
            ),
            @ApiResponse(
                    responseCode = SwaggerConstants.CONFLICT_RESPONSE_CODE,
                    description = SwaggerConstants.CONFLICT_DESCRIPTION
            )
    })
    public ResponseEntity<EmployeeResponse> createEmployee(@Valid @RequestBody EmployeeRequest request) {
        EmployeeResponse response = employeeService.createEmployee(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    @Operation(summary = SwaggerConstants.GET_ALL_EMPLOYEES_SUMMARY)
    @ApiResponses({
            @ApiResponse(
                    responseCode = SwaggerConstants.OK_RESPONSE_CODE,
                    description = SwaggerConstants.EMPLOYEES_FOUND_DESCRIPTION
            )
    })
    public ResponseEntity<List<EmployeeResponse>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping(ApiConstants.ID_PATH)
    @Operation(summary = SwaggerConstants.GET_EMPLOYEE_BY_ID_SUMMARY)
    @ApiResponses({
            @ApiResponse(
                    responseCode = SwaggerConstants.OK_RESPONSE_CODE,
                    description = SwaggerConstants.EMPLOYEE_FOUND_DESCRIPTION
            ),
            @ApiResponse(
                    responseCode = SwaggerConstants.NOT_FOUND_RESPONSE_CODE,
                    description = SwaggerConstants.NOT_FOUND_DESCRIPTION
            )
    })
    public ResponseEntity<EmployeeResponse> getEmployeeById(@PathVariable(ApiConstants.ID_VARIABLE) Long id) {
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @PutMapping(ApiConstants.ID_PATH)
    @Operation(summary = SwaggerConstants.UPDATE_EMPLOYEE_SUMMARY)
    @ApiResponses({
            @ApiResponse(
                    responseCode = SwaggerConstants.OK_RESPONSE_CODE,
                    description = SwaggerConstants.EMPLOYEE_UPDATED_DESCRIPTION
            ),
            @ApiResponse(
                    responseCode = SwaggerConstants.BAD_REQUEST_RESPONSE_CODE,
                    description = SwaggerConstants.BAD_REQUEST_DESCRIPTION
            ),
            @ApiResponse(
                    responseCode = SwaggerConstants.NOT_FOUND_RESPONSE_CODE,
                    description = SwaggerConstants.NOT_FOUND_DESCRIPTION
            ),
            @ApiResponse(
                    responseCode = SwaggerConstants.CONFLICT_RESPONSE_CODE,
                    description = SwaggerConstants.CONFLICT_DESCRIPTION
            )
    })
    public ResponseEntity<EmployeeResponse> updateEmployee(
            @PathVariable(ApiConstants.ID_VARIABLE) Long id,
            @Valid @RequestBody EmployeeRequest request
    ) {
        return ResponseEntity.ok(employeeService.updateEmployee(id, request));
    }

    @DeleteMapping(ApiConstants.ID_PATH)
    @Operation(summary = SwaggerConstants.DELETE_EMPLOYEE_SUMMARY)
    @ApiResponses({
            @ApiResponse(
                    responseCode = SwaggerConstants.NO_CONTENT_RESPONSE_CODE,
                    description = SwaggerConstants.EMPLOYEE_DELETED_DESCRIPTION
            ),
            @ApiResponse(
                    responseCode = SwaggerConstants.NOT_FOUND_RESPONSE_CODE,
                    description = SwaggerConstants.NOT_FOUND_DESCRIPTION
            )
    })
    public ResponseEntity<Void> deleteEmployee(@PathVariable(ApiConstants.ID_VARIABLE) Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}
