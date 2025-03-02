package com.ilicanspecialeducation.domain.data.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ilicanspecialeducation.domain.data.dto.EmployeeDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestSaveEmployee {
    private EmployeeDTO employee;
}
