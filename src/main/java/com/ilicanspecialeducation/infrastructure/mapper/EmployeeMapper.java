package com.ilicanspecialeducation.infrastructure.mapper;

import com.ilicanspecialeducation.domain.data.dto.EmployeeDTO;
import com.ilicanspecialeducation.infrastructure.adapter.employee.entity.Employee;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface EmployeeMapper {

    EmployeeDTO mapEntity2DTO(Employee entity);

    Employee mapDTO2Entity(EmployeeDTO dto);

    List<EmployeeDTO> mapEntityList2DTOList(List<Employee> entityList);

    List<Employee> mapDTOList2EntityList(List<EmployeeDTO> dtoList);

}
