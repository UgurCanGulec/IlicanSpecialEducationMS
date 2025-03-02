package com.ilicanspecialeducation.domain.data.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseRefreshToken {
    private String token;
    private String refreshToken;
    private String setExpirationTime;
}
