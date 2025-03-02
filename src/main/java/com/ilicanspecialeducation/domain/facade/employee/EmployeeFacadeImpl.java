package com.ilicanspecialeducation.domain.facade.employee;

import com.ilicanspecialeducation.domain.data.dto.EmployeeDTO;
import com.ilicanspecialeducation.domain.domainmodel.employee.EmployeeDomainModel;
import com.ilicanspecialeducation.domain.port.employee.EmployeePort;

import java.util.List;

public record EmployeeFacadeImpl(EmployeePort employeePort) implements EmployeeFacade {

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        EmployeeDomainModel employeeDomainModel = new EmployeeDomainModel(employeePort);
        return employeeDomainModel.getAllEmployees();
    }

    @Override
    public void saveEmployee(EmployeeDTO employee) {
        EmployeeDomainModel employeeDomainModel = new EmployeeDomainModel(employeePort);
        employeeDomainModel.saveEmployee(employee);
    }

    @Override
    public void removeEmployeeById(Long id) {
        EmployeeDomainModel employeeDomainModel = new EmployeeDomainModel(employeePort);
        employeeDomainModel.removeEmployeeById(id);
    }

    @Override
    public void updateEmployee(EmployeeDTO employee) {
        EmployeeDomainModel employeeDomainModel = new EmployeeDomainModel(employeePort);
        employeeDomainModel.updateEmployee(employee);
    }
}
