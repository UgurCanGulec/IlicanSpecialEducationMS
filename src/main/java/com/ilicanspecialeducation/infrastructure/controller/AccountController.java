package com.ilicanspecialeducation.infrastructure.controller;

import com.ilicanspecialeducation.domain.data.request.RequestUpdateAccount;
import com.ilicanspecialeducation.domain.data.response.*;
import com.ilicanspecialeducation.domain.facade.account.AccountFacade;
import com.ilicanspecialeducation.domain.facade.account.AccountFacadeImpl;
import com.ilicanspecialeducation.domain.port.account.AccountPort;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    private final AccountFacade accountFacade;

    public AccountController(AccountPort accountPort) {
        this.accountFacade = new AccountFacadeImpl(accountPort);
    }

    @GetMapping(value = "/all")
    @Operation(description = "Retrieves all accounts")
    public ResponseEntity<BaseResponse<ResponseGetAllAccounts>> getAllAccounts() {
        ResponseGetAllAccounts response = accountFacade.getAllAccounts();
        return ResponseEntity.ok(new BaseResponse<>(response));
    }

    @GetMapping(value = "/{id}")
    @Operation(description = "Retrieves selected account")
    public ResponseEntity<BaseResponse<ResponseGetAccount>> getAccount(@PathVariable("id") Long id) {
        ResponseGetAccount response = accountFacade.getAccountById(id);
        return ResponseEntity.ok(new BaseResponse<>(response));
    }

    @PostMapping(value = "/update")
    @Operation(description = "Updates account")
    public ResponseEntity<BaseResponse<Boolean>> updateAccount(@RequestBody @Valid RequestUpdateAccount request) {
        boolean result = accountFacade.update(request);
        return ResponseEntity.ok(new BaseResponse<>(result));
    }
}
