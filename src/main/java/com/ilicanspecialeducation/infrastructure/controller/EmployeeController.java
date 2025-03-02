package com.ilicanspecialeducation.infrastructure.controller;

import com.ilicanspecialeducation.domain.data.request.RequestSaveEmployee;
import com.ilicanspecialeducation.domain.data.response.BaseResponse;
import com.ilicanspecialeducation.domain.data.response.ResponseGetAllEmployees;
import com.ilicanspecialeducation.domain.data.dto.EmployeeDTO;
import com.ilicanspecialeducation.domain.facade.employee.EmployeeFacade;
import com.ilicanspecialeducation.domain.facade.employee.EmployeeFacadeImpl;
import com.ilicanspecialeducation.domain.port.employee.EmployeePort;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {

    private final EmployeeFacade employeeFacade;

    @Autowired
    public EmployeeController(EmployeePort employeePort) {
        this.employeeFacade = new EmployeeFacadeImpl(employeePort);
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(description = "Retrieves all employees")
    public ResponseEntity<BaseResponse<ResponseGetAllEmployees>> getAllEmployees() {
        List<EmployeeDTO> employees = employeeFacade.getAllEmployees();
        return ResponseEntity.ok(new BaseResponse<>(new ResponseGetAllEmployees(employees)));
    }

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(description = "Add a new employee")
    public ResponseEntity<BaseResponse<Boolean>> saveEmployee(@RequestBody @Valid RequestSaveEmployee request) {
        employeeFacade.saveEmployee(request.getEmployee());
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE));
    }

    @DeleteMapping(value = "remove/{id}")
    @Operation(description = "Delete employee by id")
    public ResponseEntity<BaseResponse<Boolean>> removeEmployee(@PathVariable("id") Long id) {
        employeeFacade.removeEmployeeById(id);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE));
    }

    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(description = "Update an employee")
    public ResponseEntity<BaseResponse<Boolean>> updateEmployee(@RequestBody @Valid RequestSaveEmployee request) {
        employeeFacade.updateEmployee(request.getEmployee());
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE));
    }
}
