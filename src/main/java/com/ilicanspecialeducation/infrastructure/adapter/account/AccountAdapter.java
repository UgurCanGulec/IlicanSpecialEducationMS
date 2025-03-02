package com.ilicanspecialeducation.infrastructure.adapter.account;

import com.ilicanspecialeducation.domain.data.dto.AccountDTO;
import com.ilicanspecialeducation.domain.port.account.AccountPort;
import com.ilicanspecialeducation.infrastructure.adapter.account.entity.Account;
import com.ilicanspecialeducation.infrastructure.adapter.account.repository.AccountRepository;
import com.ilicanspecialeducation.infrastructure.mapper.AccountMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountAdapter implements AccountPort {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return accountRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
    }

    @Override
    public List<AccountDTO> getAllAccounts() {
        List<Account> accounts = accountRepository.findAllByIsActive(Boolean.TRUE);
        return accountMapper.mapEntityListToDtoList(accounts);
    }

    @Override
    public AccountDTO getAccountById(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException(id.toString()));
        return accountMapper.mapEntityToDTO(account);
    }

    @Override
    public void update(AccountDTO account) {
        Account updatedAccount = accountRepository.findById(account.getId()).orElseThrow(() -> new UsernameNotFoundException(account.getId().toString()));
        updatedAccount.setUsername(account.getUsername());
        updatedAccount.setIsActive(account.getIsActive());
        updatedAccount.setRole(account.getRole());
        updatedAccount.setEmail(account.getEmail());
        accountRepository.save(updatedAccount);
    }

}
