package com.ilicanspecialeducation.domain.facade.account;

import com.ilicanspecialeducation.domain.data.request.RequestUpdateAccount;
import com.ilicanspecialeducation.domain.data.response.*;
import com.ilicanspecialeducation.domain.domainmodel.account.AccountDomainModel;
import com.ilicanspecialeducation.domain.port.account.AccountPort;

public record AccountFacadeImpl(AccountPort accountPort) implements AccountFacade {

    @Override
    public ResponseGetAllAccounts getAllAccounts() {
        AccountDomainModel accountDomainModel = new AccountDomainModel(accountPort);
        return accountDomainModel.getAllAccounts();
    }

    @Override
    public ResponseGetAccount getAccountById(Long id) {
        AccountDomainModel accountDomainModel = new AccountDomainModel(accountPort);
        return accountDomainModel.getAccountById(id);
    }

    @Override
    public boolean update(RequestUpdateAccount request) {
        AccountDomainModel accountDomainModel = new AccountDomainModel(accountPort);
        return accountDomainModel.update(request.getAccount());
    }
}
