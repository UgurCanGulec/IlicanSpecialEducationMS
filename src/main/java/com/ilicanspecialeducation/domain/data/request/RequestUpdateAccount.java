package com.ilicanspecialeducation.domain.data.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ilicanspecialeducation.domain.data.dto.AccountDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestUpdateAccount {
    private AccountDTO account;
}
