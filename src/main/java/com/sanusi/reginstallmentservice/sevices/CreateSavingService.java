package com.sanusi.reginstallmentservice.sevices;

import com.sanusi.reginstallmentservice.exception.AccountNotFoundException;
import com.sanusi.reginstallmentservice.model.entities.Account;
import com.sanusi.reginstallmentservice.model.entities.Deposit;
import com.sanusi.reginstallmentservice.model.requests.CalculatorRequest;
import com.sanusi.reginstallmentservice.model.requests.CreateSavingRequest;
import com.sanusi.reginstallmentservice.model.responses.CreateSavingResponse;
import com.sanusi.reginstallmentservice.repositories.AccountRepository;
import com.sanusi.reginstallmentservice.repositories.DepositRepository;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

@Service
public class CreateSavingService {

    private CalculatorService calculatorService;
    private DepositRepository depositRepository;
    private AccountRepository accountRepository;

    public CreateSavingService(CalculatorService calculatorService, DepositRepository depositRepository, AccountRepository accountRepository) {
        this.calculatorService = calculatorService;
        this.depositRepository = depositRepository;
        this.accountRepository = accountRepository;
    }

    public CreateSavingResponse execute(CreateSavingRequest request) {

        Account account = accountRepository.findByAccountNumber(request.getAccountNumber()).orElseThrow(
                ()->  new AccountNotFoundException("Account ID not found"));

        CalculatorRequest req = CalculatorRequest.builder()
                .firstAmount(request.getFirstAmount())
                .monthlyAmount(request.getMonthlyAmount())
                .tenor(request.getTenor())
                .build();

        BigDecimal grantTotalDepositAmount = calculatorService.calculate(req);

        Deposit deposit = Deposit.builder()
                .accountId(account.getId())
                .savingPurpose(request.getSavingPurpose())
                .firstAmount(BigDecimal.valueOf(request.getFirstAmount()))
                .monthlyDepositAmount(BigDecimal.valueOf(request.getMonthlyAmount()))
                .tenor(request.getTenor())
                .finalBalance(grantTotalDepositAmount)
                .startDate(new Date())
                .maturityDate(DateUtils.addMonths(new Date(),request.getTenor()))
                .build();

        deposit.setIsDeleted(false);
        deposit.setUpdatedDate(new Date());

        deposit = depositRepository.save(deposit);

        CreateSavingResponse response = CreateSavingResponse.builder()
                .accountNumber(account.getAccountNumber())
                .accountName(account.getAccountName())
                .currency(account.getCurrency())
                .firstAmount(deposit.getFirstAmount())
                .monthlyDepositAmount(deposit.getMonthlyDepositAmount())
                .finalBalance(deposit.getFinalBalance())
                .savingPurpose(deposit.getSavingPurpose())
                .startDate(deposit.getStartDate())
                .maturityDate(deposit.getMaturityDate())
                .tenor(deposit.getTenor())
                .build();

        return response;
    }
}
