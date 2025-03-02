package com.ilicanspecialeducation.domain.domainmodel.authentication;

import com.ilicanspecialeducation.domain.data.request.RequestLogin;
import com.ilicanspecialeducation.domain.data.request.RequestRefreshToken;
import com.ilicanspecialeducation.domain.data.request.RequestRegister;
import com.ilicanspecialeducation.domain.data.response.ResponseGetAccountProfile;
import com.ilicanspecialeducation.domain.data.response.ResponseLogin;
import com.ilicanspecialeducation.domain.data.response.ResponseRefreshToken;
import com.ilicanspecialeducation.domain.port.account.AccountPort;
import com.ilicanspecialeducation.domain.port.authentication.AuthenticationPort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public record AuthenticationDomainModel(
        AuthenticationPort authenticationPort,
        AccountPort accountPort) {

    public boolean register(RequestRegister request) {
        return authenticationPort.register(request);
    }

    public ResponseLogin login(RequestLogin request) {
        return authenticationPort.login(request);
    }

    public ResponseRefreshToken refreshToken(RequestRefreshToken request) {
        return authenticationPort.refreshToken(request);
    }

    public ResponseGetAccountProfile getAccountProfile() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        UserDetails account = accountPort.loadUserByUsername(username);
        return new ResponseGetAccountProfile(account);
    }
}
