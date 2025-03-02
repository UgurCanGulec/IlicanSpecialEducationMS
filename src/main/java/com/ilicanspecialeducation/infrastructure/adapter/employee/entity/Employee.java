package com.ilicanspecialeducation.infrastructure.adapter.employee.entity;

import com.ilicanspecialeducation.domain.enums.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "NAME_SURNAME", length = 500, nullable = false)
    private String nameSurname;
    @Column(name = "TITLE", length = 500)
    private String title;
    @Column(name = "PICTURE_URL", length = 4000)
    private String pictureUrl;
    @Column(name = "HIRE_DATE")
    private LocalDate hireDate;
    @Column(name = "EMAIL", length = 500)
    private String email;
    @Column(name = "DESCRIPTION", length = 4000)
    private String description;
    @Column(name = "STATUS")
    @Enumerated(value = EnumType.STRING)
    private Status status;
}
