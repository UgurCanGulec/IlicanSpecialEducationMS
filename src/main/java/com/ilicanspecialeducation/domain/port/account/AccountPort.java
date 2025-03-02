package com.ilicanspecialeducation.domain.port.account;

import com.ilicanspecialeducation.domain.data.dto.AccountDTO;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface AccountPort {

    UserDetails loadUserByUsername(String username);

    List<AccountDTO> getAllAccounts();

    AccountDTO getAccountById(Long id);

    void update(AccountDTO account);
}
