package com.ilicanspecialeducation.infrastructure.adapter.authentication;

import com.ilicanspecialeducation.domain.port.account.AccountPort;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserManagementService implements UserDetailsService {

    private final AccountPort accountPort;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return accountPort.loadUserByUsername(username);
    }
}
