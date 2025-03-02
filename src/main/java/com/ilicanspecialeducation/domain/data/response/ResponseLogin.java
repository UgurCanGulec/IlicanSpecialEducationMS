package com.ilicanspecialeducation.domain.data.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseLogin {
    private boolean isAuthenticated;
    private String username;
    private String token;
    private String role;
    private String refreshToken;
    private String expirationTime;
}
