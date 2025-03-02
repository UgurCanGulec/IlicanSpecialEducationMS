package com.ilicanspecialeducation.domain.facade.authentication;

import com.ilicanspecialeducation.domain.data.request.RequestLogin;
import com.ilicanspecialeducation.domain.data.request.RequestRefreshToken;
import com.ilicanspecialeducation.domain.data.request.RequestRegister;
import com.ilicanspecialeducation.domain.data.response.ResponseGetAccountProfile;
import com.ilicanspecialeducation.domain.data.response.ResponseLogin;
import com.ilicanspecialeducation.domain.data.response.ResponseRefreshToken;

public interface AuthenticationFacade {

    boolean register(RequestRegister request);

    ResponseLogin login(RequestLogin request);

    ResponseRefreshToken refresh(RequestRefreshToken request);

    ResponseGetAccountProfile getAccountProfile();
}
