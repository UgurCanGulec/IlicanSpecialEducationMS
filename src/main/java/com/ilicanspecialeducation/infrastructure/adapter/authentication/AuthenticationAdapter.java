package com.ilicanspecialeducation.infrastructure.adapter.authentication;

import com.ilicanspecialeducation.domain.data.request.RequestLogin;
import com.ilicanspecialeducation.domain.data.request.RequestRefreshToken;
import com.ilicanspecialeducation.domain.data.request.RequestRegister;
import com.ilicanspecialeducation.domain.data.response.ResponseLogin;
import com.ilicanspecialeducation.domain.data.response.ResponseRefreshToken;
import com.ilicanspecialeducation.domain.port.authentication.AuthenticationPort;
import com.ilicanspecialeducation.infrastructure.adapter.account.entity.Account;
import com.ilicanspecialeducation.infrastructure.adapter.account.repository.AccountRepository;
import com.ilicanspecialeducation.infrastructure.jwt.JsonWebTokenUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthenticationAdapter implements AuthenticationPort {

    private final PasswordEncoder passwordEncoder;
    private final JsonWebTokenUtil jsonWebTokenUtil;
    private final AccountRepository accountRepository;
    private final AuthenticationManager authenticationManager;

    @Override
    public ResponseRefreshToken refreshToken(RequestRefreshToken request) {
        ResponseRefreshToken response = new ResponseRefreshToken();
        String username = jsonWebTokenUtil.extractUsername(request.getToken());
        Account account = accountRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
        if (jsonWebTokenUtil.isTokenValid(request.getToken(), account)) {
            String jsonWebToken = jsonWebTokenUtil.generateToken(account);
            response.setToken(jsonWebToken);
            response.setRefreshToken(request.getToken());
            response.setSetExpirationTime("24Hr");
        }
        return response;
    }

    @Override
    public boolean register(RequestRegister request) {
        try {
            Account account = new Account();
            account.setEmail(request.getEmail());
            account.setUsername(request.getUsername());
            account.setPassword(passwordEncoder.encode(request.getPassword()));
            account.setRole(request.getRole());
            accountRepository.save(account);
        } catch (Exception exception) {
            throw new RuntimeException(exception.getMessage());
        }
        return true;
    }

    @Override
    public ResponseLogin login(RequestLogin request) {
        ResponseLogin response = new ResponseLogin();
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    request.getUsername(), request.getPassword()
            ));
            Account account = accountRepository.findByUsername(request.getUsername()).orElseThrow(() -> new UsernameNotFoundException(request.getUsername()));
            String jsonWebToken = jsonWebTokenUtil.generateToken(account);
            String refreshToken = jsonWebTokenUtil.generateRefreshToken(new HashMap<>(), account);
            response.setAuthenticated(authentication.isAuthenticated());
            response.setRole(account.getRole());
            response.setUsername(account.getUsername());
            response.setRefreshToken(refreshToken);
            response.setToken(jsonWebToken);
            response.setExpirationTime("24Hr");
        } catch (Exception exception) {
            throw new RuntimeException(exception.getMessage());
        }
        return response;
    }
}
