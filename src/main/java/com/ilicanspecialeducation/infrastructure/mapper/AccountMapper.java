package com.ilicanspecialeducation.infrastructure.mapper;

import com.ilicanspecialeducation.domain.data.dto.AccountDTO;
import com.ilicanspecialeducation.infrastructure.adapter.account.entity.Account;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface AccountMapper {

    AccountDTO mapEntityToDTO(Account entity);

    Account mapDTOToEntity(AccountDTO dto);

    List<AccountDTO> mapEntityListToDtoList(List<Account> entityList);
}
