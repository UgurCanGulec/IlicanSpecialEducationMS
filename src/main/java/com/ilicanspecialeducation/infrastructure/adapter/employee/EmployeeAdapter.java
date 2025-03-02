package com.ilicanspecialeducation.infrastructure.adapter.employee;

import com.ilicanspecialeducation.domain.exceptions.EmployeeNotFoundException;
import com.ilicanspecialeducation.domain.exceptions.ExceptionMessage;
import com.ilicanspecialeducation.domain.data.dto.EmployeeDTO;
import com.ilicanspecialeducation.infrastructure.mapper.EmployeeMapper;
import com.ilicanspecialeducation.infrastructure.adapter.employee.entity.Employee;
import com.ilicanspecialeducation.domain.enums.Status;
import com.ilicanspecialeducation.infrastructure.adapter.employee.repository.EmployeeRepository;
import com.ilicanspecialeducation.domain.port.employee.EmployeePort;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class EmployeeAdapter implements EmployeePort {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = Optional.of(employeeRepository.findAll())
                .filter(list -> !CollectionUtils.isEmpty(list))
                .orElseThrow(() -> new EmployeeNotFoundException(ExceptionMessage.EMPLOYEE_NOT_FOUND));
        return employeeMapper.mapEntityList2DTOList(employees);
    }

    @Override
    public void saveEmployee(EmployeeDTO employeeDTO) {
        Employee employee = employeeMapper.mapDTO2Entity(employeeDTO);
        employee.setStatus(Status.ACTIVE);
        employeeRepository.save(employee);
    }

    @Override
    public void removeEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(ExceptionMessage.EMPLOYEE_NOT_FOUND));
        employeeRepository.delete(employee);
    }

    @Override
    public void updateEmployee(EmployeeDTO employeeDTO) {
        Employee employee = employeeRepository.findById(employeeDTO.getId())
                .orElseThrow(() -> new EmployeeNotFoundException(ExceptionMessage.EMPLOYEE_NOT_FOUND));
        employee.setStatus(employeeDTO.getStatus());
        employee.setDescription(employeeDTO.getDescription());
        employee.setTitle(employeeDTO.getTitle());
        employee.setNameSurname(employeeDTO.getNameSurname());
        employee.setPictureUrl(employeeDTO.getPictureUrl());
        employee.setEmail(employeeDTO.getEmail());
        employee.setHireDate(employeeDTO.getHireDate());
        employeeRepository.save(employee);
    }
}
