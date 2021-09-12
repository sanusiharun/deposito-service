package com.sanusi.reginstallmentservice.sevices;

import com.sanusi.reginstallmentservice.model.entities.Account;
import com.sanusi.reginstallmentservice.model.responses.GetAllAccountResponse;
import com.sanusi.reginstallmentservice.repositories.AccountRepository;
import com.sanusi.reginstallmentservice.repositories.AccountTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetAllAccountService {
    private AccountRepository accountRepository;

    public GetAllAccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<GetAllAccountResponse> execute() {
        List<Account> accounts = accountRepository.findAll();
        if(accounts.size() < 0) {
            return null;
        }
        List<GetAllAccountResponse> result = accounts.stream().map(ac ->
            GetAllAccountResponse.builder()
                    .accountNumber(ac.getAccountNumber())
                    .currency(ac.getCurrency())
                    .accountName(ac.getAccountName())
                    .phoneNumber(ac.getPhoneNumber())
                    .cif(ac.getCif())
                    .address(ac.getAddress())
                    .build()).collect(Collectors.toList());
        return result;
    }
}
