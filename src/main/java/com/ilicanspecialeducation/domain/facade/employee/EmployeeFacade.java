package com.ilicanspecialeducation.domain.facade.employee;

import com.ilicanspecialeducation.domain.data.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeFacade {

    List<EmployeeDTO> getAllEmployees();

    void saveEmployee(EmployeeDTO employee);

    void removeEmployeeById(Long id);

    void updateEmployee(EmployeeDTO employee);
}
