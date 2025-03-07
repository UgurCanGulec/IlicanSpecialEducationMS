package com.ilicanspecialeducation.domain.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO {
    private Long id;
    private String email;
    private String username;
    private String role;
    private Boolean isActive;
}
