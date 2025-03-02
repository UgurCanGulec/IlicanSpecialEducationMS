package com.ilicanspecialeducation.domain.data.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseGetAccountProfile {
    private UserDetails account;
}
