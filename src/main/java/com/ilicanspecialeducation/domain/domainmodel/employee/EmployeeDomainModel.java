package com.ilicanspecialeducation.domain.domainmodel.employee;

import com.ilicanspecialeducation.domain.data.dto.EmployeeDTO;
import com.ilicanspecialeducation.domain.port.employee.EmployeePort;
import com.ilicanspecialeducation.domain.port.storage.ImageStoragePort;

import java.util.List;

public record EmployeeDomainModel(EmployeePort employeePort, ImageStoragePort imageStoragePort) {

    public List<EmployeeDTO> getAllEmployees() {
        return employeePort.getAllEmployees();
    }

    public void saveEmployee(EmployeeDTO employee) {
        employeePort.saveEmployee(employee);
    }

    public void removeEmployeeById(Long id) {
        EmployeeDTO employee = employeePort.getEmployeeById(id);
        imageStoragePort.deleteImage(employee.getPictureUrl());
        employeePort.removeEmployeeById(id);
    }

    public void updateEmployee(EmployeeDTO employee) {
        employeePort.updateEmployee(employee);
    }
}
