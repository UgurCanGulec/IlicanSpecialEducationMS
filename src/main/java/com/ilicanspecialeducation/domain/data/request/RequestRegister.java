package com.ilicanspecialeducation.domain.data.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.ilicanspecialeducation.domain.enums.Status;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestRegister {
    private String username;
    private String password;
    private String email;
    private String role;
    private Status status;
}
