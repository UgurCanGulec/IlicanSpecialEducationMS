package com.ilicanspecialeducation.domain.data.response;

import com.ilicanspecialeducation.domain.data.dto.AccountDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseGetAllAccounts {
    List<AccountDTO> accounts;
}
