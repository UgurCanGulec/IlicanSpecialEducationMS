package com.ilicanspecialeducation.domain.data.dto;

import com.ilicanspecialeducation.domain.enums.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class EmployeeDTO {
    private Long id;
    private String nameSurname;
    private String title;
    private String pictureUrl;
    private LocalDate hireDate;
    private String email;
    private String description;
    private Status status;
}
