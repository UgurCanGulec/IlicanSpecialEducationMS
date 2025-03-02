package com.ilicanspecialeducation.domain.facade.account;

import com.ilicanspecialeducation.domain.data.request.RequestUpdateAccount;
import com.ilicanspecialeducation.domain.data.response.*;
import jakarta.validation.Valid;

public interface AccountFacade {

    ResponseGetAllAccounts getAllAccounts();

    ResponseGetAccount getAccountById(Long id);

    boolean update(@Valid RequestUpdateAccount request);

}
