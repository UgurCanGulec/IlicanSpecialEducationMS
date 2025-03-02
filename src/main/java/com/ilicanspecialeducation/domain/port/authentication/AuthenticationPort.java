package com.ilicanspecialeducation.domain.port.authentication;

import com.ilicanspecialeducation.domain.data.request.RequestLogin;
import com.ilicanspecialeducation.domain.data.request.RequestRefreshToken;
import com.ilicanspecialeducation.domain.data.request.RequestRegister;
import com.ilicanspecialeducation.domain.data.response.ResponseLogin;
import com.ilicanspecialeducation.domain.data.response.ResponseRefreshToken;

public interface AuthenticationPort {

    boolean register(RequestRegister request);

    ResponseLogin login(RequestLogin request);

    ResponseRefreshToken refreshToken(RequestRefreshToken request);
}
