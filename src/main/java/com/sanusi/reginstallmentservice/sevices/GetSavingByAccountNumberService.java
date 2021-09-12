package com.sanusi.reginstallmentservice.sevices;

import com.sanusi.reginstallmentservice.exception.AccountNotFoundException;
import com.sanusi.reginstallmentservice.exception.ApiRequestException;
import com.sanusi.reginstallmentservice.model.projections.DepositInfo;
import com.sanusi.reginstallmentservice.model.responses.GetAllSavingResponse;
import com.sanusi.reginstallmentservice.repositories.DepositRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetSavingByAccountNumberService {
    private DepositRepository depositRepository;

    public GetSavingByAccountNumberService(DepositRepository depositRepository) {
        this.depositRepository = depositRepository;
    }

    public GetAllSavingResponse execute(String accountNumber) {
        if(isEmptyString(accountNumber)){
            throw new ApiRequestException("Invalid request");
        }
        List<DepositInfo> depositInfoList = depositRepository.getAllDepositoByAccountNumber(accountNumber);
        if(depositInfoList.size() == 0) {
            throw new AccountNotFoundException("Account ID not found");
        }

        GetAllSavingResponse result = GetAllSavingResponse.builder()
                .list(depositInfoList)
                .build();
        return result;
    }

    private boolean isEmptyString(String string) {
        return string == null || string.trim().isEmpty();
    }
}
