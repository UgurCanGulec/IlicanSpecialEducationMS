package com.ilicanspecialeducation.infrastructure.adapter.account.repository;

import com.ilicanspecialeducation.infrastructure.adapter.account.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByUsername(String username);

    List<Account> findAllByIsActive(Boolean isActive);
}
