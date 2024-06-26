package com.backend.controller;

import com.backend.Execption.AccountNotFound;
import com.backend.Execption.CustomerNotFound;
import com.backend.dto.AccountDTO;
import com.backend.dto.AccountHistoryDTO;
import com.backend.dto.AccountLitDTO;
import com.backend.dto.OperationDTO;
import com.backend.service.AccountServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.LongStream;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
public class AccountController {

    private final AccountServiceImpl accountService;

    @GetMapping("/accounts/{accountId}")
    public AccountDTO getAccount(@PathVariable  String accountId) throws AccountNotFound {
        return accountService.getAccount(accountId);
    }

    @GetMapping("/accounts")
    public List<AccountDTO> AccountsList() {
        return accountService.accountList();
    }

    @GetMapping("/accounts/{accountId}/operationsHistories")
    public AccountHistoryDTO getHistoriesAccount(@PathVariable String accountId,
                                                 @RequestParam(name = "page", defaultValue = "0") int page,
                                                 @RequestParam(name = "size", defaultValue = "5") int size) {
        return accountService.gethistoriesAccountOperation(accountId, page, size);
    }

    @GetMapping("/accounts/list-account/{customerId}")
    public List<AccountLitDTO> getListAccountsCustomer(@PathVariable int customerId) throws CustomerNotFound {
        return accountService.listAccountsCustomer(customerId);
    }

}
