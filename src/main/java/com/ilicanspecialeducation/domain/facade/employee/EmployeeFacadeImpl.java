package com.ilicanspecialeducation.domain.facade.employee;

import com.ilicanspecialeducation.domain.data.dto.EmployeeDTO;
import com.ilicanspecialeducation.domain.domainmodel.employee.EmployeeDomainModel;
import com.ilicanspecialeducation.domain.port.employee.EmployeePort;
import com.ilicanspecialeducation.domain.port.storage.ImageStoragePort;

import java.util.List;

public record EmployeeFacadeImpl(EmployeePort employeePort,
                                 ImageStoragePort imageStoragePort) implements EmployeeFacade {

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        EmployeeDomainModel employeeDomainModel = new EmployeeDomainModel(employeePort, imageStoragePort);
        return employeeDomainModel.getAllEmployees();
    }

    @Override
    public void saveEmployee(EmployeeDTO employee) {
        EmployeeDomainModel employeeDomainModel = new EmployeeDomainModel(employeePort, imageStoragePort);
        employeeDomainModel.saveEmployee(employee);
    }

    @Override
    public void removeEmployeeById(Long id) {
        EmployeeDomainModel employeeDomainModel = new EmployeeDomainModel(employeePort, imageStoragePort);
        employeeDomainModel.removeEmployeeById(id);
    }

    @Override
    public void updateEmployee(EmployeeDTO employee) {
        EmployeeDomainModel employeeDomainModel = new EmployeeDomainModel(employeePort, imageStoragePort);
        employeeDomainModel.updateEmployee(employee);
    }
}
