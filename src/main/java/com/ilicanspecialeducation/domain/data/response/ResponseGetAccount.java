package com.ilicanspecialeducation.domain.data.response;

import com.ilicanspecialeducation.domain.data.dto.AccountDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseGetAccount {
    private AccountDTO account;
}
