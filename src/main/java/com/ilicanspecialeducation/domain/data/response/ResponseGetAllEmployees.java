package com.ilicanspecialeducation.domain.data.response;

import com.ilicanspecialeducation.domain.data.dto.EmployeeDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseGetAllEmployees {
    private List<EmployeeDTO> employees;
}
