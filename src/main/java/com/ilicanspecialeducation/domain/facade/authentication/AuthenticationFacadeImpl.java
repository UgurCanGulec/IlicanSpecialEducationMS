package com.ilicanspecialeducation.domain.facade.authentication;

import com.ilicanspecialeducation.domain.data.request.RequestLogin;
import com.ilicanspecialeducation.domain.data.request.RequestRefreshToken;
import com.ilicanspecialeducation.domain.data.request.RequestRegister;
import com.ilicanspecialeducation.domain.data.response.ResponseGetAccountProfile;
import com.ilicanspecialeducation.domain.data.response.ResponseLogin;
import com.ilicanspecialeducation.domain.data.response.ResponseRefreshToken;
import com.ilicanspecialeducation.domain.domainmodel.authentication.AuthenticationDomainModel;
import com.ilicanspecialeducation.domain.port.account.AccountPort;
import com.ilicanspecialeducation.domain.port.authentication.AuthenticationPort;

public record AuthenticationFacadeImpl(
        AuthenticationPort authenticationPort,
        AccountPort accountPort) implements AuthenticationFacade {

    @Override
    public boolean register(RequestRegister request) {
        AuthenticationDomainModel domainModel = new AuthenticationDomainModel(authenticationPort, accountPort);
        return domainModel.register(request);
    }

    @Override
    public ResponseLogin login(RequestLogin request) {
        AuthenticationDomainModel domainModel = new AuthenticationDomainModel(authenticationPort, accountPort);
        return domainModel.login(request);
    }

    @Override
    public ResponseRefreshToken refresh(RequestRefreshToken request) {
        AuthenticationDomainModel domainModel = new AuthenticationDomainModel(authenticationPort, accountPort);
        return domainModel.refreshToken(request);
    }

    @Override
    public ResponseGetAccountProfile getAccountProfile() {
        AuthenticationDomainModel domainModel = new AuthenticationDomainModel(authenticationPort, accountPort);
        return domainModel.getAccountProfile();
    }
}
