package com.ilicanspecialeducation.infrastructure.controller;

import com.ilicanspecialeducation.domain.data.request.RequestLogin;
import com.ilicanspecialeducation.domain.data.request.RequestRefreshToken;
import com.ilicanspecialeducation.domain.data.request.RequestRegister;
import com.ilicanspecialeducation.domain.data.response.BaseResponse;
import com.ilicanspecialeducation.domain.data.response.ResponseGetAccountProfile;
import com.ilicanspecialeducation.domain.data.response.ResponseLogin;
import com.ilicanspecialeducation.domain.data.response.ResponseRefreshToken;
import com.ilicanspecialeducation.domain.facade.authentication.AuthenticationFacade;
import com.ilicanspecialeducation.domain.facade.authentication.AuthenticationFacadeImpl;
import com.ilicanspecialeducation.domain.port.account.AccountPort;
import com.ilicanspecialeducation.domain.port.authentication.AuthenticationPort;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    private final AuthenticationFacade authenticationFacade;

    public AuthenticationController(AuthenticationPort authenticationPort, AccountPort accountPort) {
        this.authenticationFacade = new AuthenticationFacadeImpl(authenticationPort, accountPort);
    }

    @PostMapping(value = "/register")
    @Operation(description = "Register new account account")
    public ResponseEntity<BaseResponse<Boolean>> register(@RequestBody @Valid RequestRegister request) {
        boolean result = authenticationFacade.register(request);
        return ResponseEntity.ok(new BaseResponse<>(result));
    }

    @PostMapping(value = "/login")
    @Operation(description = "Account login")
    public ResponseEntity<BaseResponse<ResponseLogin>> login(@RequestBody @Valid RequestLogin request) {
        ResponseLogin response = authenticationFacade.login(request);
        return ResponseEntity.ok(new BaseResponse<>(response));
    }

    @PostMapping(value = "/refresh")
    @Operation(description = "Refresh operation service")
    public ResponseEntity<BaseResponse<ResponseRefreshToken>> refresh(@RequestBody @Valid RequestRefreshToken request) {
        ResponseRefreshToken response = authenticationFacade.refresh(request);
        return ResponseEntity.ok(new BaseResponse<>(response));
    }

    @PostMapping(value = "/profile")
    @Operation(description = "Retrieves account profile")
    public ResponseEntity<BaseResponse<ResponseGetAccountProfile>> getAccountProfile() {
        ResponseGetAccountProfile response = authenticationFacade.getAccountProfile();
        return ResponseEntity.ok(new BaseResponse<>(response));
    }
}
