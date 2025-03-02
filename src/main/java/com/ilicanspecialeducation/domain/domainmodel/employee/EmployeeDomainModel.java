package com.ilicanspecialeducation.domain.domainmodel.employee;

import com.ilicanspecialeducation.domain.data.dto.EmployeeDTO;
import com.ilicanspecialeducation.domain.port.employee.EmployeePort;

import java.util.List;

public record EmployeeDomainModel(EmployeePort employeePort) {

    public List<EmployeeDTO> getAllEmployees() {
        return employeePort.getAllEmployees();
    }

    public void saveEmployee(EmployeeDTO employee) {
        employeePort.saveEmployee(employee);
    }

    public void removeEmployeeById(Long id) {
        employeePort.removeEmployeeById(id);
    }

    public void updateEmployee(EmployeeDTO employee) {
        employeePort.updateEmployee(employee);
    }
}
