package com.ilicanspecialeducation.domain.data.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestLogin {
    private String username;
    private String password;
}
