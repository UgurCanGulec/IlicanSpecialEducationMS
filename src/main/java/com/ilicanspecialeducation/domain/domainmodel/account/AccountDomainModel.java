package com.ilicanspecialeducation.domain.domainmodel.account;

import com.ilicanspecialeducation.domain.data.dto.AccountDTO;
import com.ilicanspecialeducation.domain.data.response.ResponseGetAccount;
import com.ilicanspecialeducation.domain.data.response.ResponseGetAllAccounts;
import com.ilicanspecialeducation.domain.port.account.AccountPort;

import java.util.Objects;

public record AccountDomainModel(AccountPort accountPort) {

    public ResponseGetAllAccounts getAllAccounts() {
        return new ResponseGetAllAccounts(accountPort.getAllAccounts());
    }

    public ResponseGetAccount getAccountById(Long id) {
        AccountDTO account = accountPort.getAccountById(id);
        if (Objects.isNull(account)) {
            throw new RuntimeException("Account not found");
        }
        if (Boolean.FALSE.equals(account.getIsActive())) {
            throw new RuntimeException("Account is inactive");
        }
        return new ResponseGetAccount(accountPort.getAccountById(id));
    }

    public boolean update(AccountDTO account) {
        if (Objects.isNull(account)) {
            throw new RuntimeException("Account is null");
        }
        if (Objects.isNull(account.getId())) {
            throw new RuntimeException("Account id is null");
        }
        accountPort.update(account);
        return true;
    }
}
