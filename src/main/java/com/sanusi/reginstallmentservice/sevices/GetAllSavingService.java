package com.sanusi.reginstallmentservice.sevices;

import com.sanusi.reginstallmentservice.exception.SavingAccountEmptyException;
import com.sanusi.reginstallmentservice.model.projections.DepositInfo;
import com.sanusi.reginstallmentservice.model.responses.GetAllSavingResponse;
import com.sanusi.reginstallmentservice.repositories.DepositRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllSavingService {
    private DepositRepository depositRepository;

    public GetAllSavingService(DepositRepository depositRepository) {
        this.depositRepository = depositRepository;
    }

    public GetAllSavingResponse execute() {
        List<DepositInfo> depositInfoList = depositRepository.getAllDeposito();
        if(depositInfoList.size() == 0) {
            throw new SavingAccountEmptyException("Empty Saving account");
        }

        GetAllSavingResponse result = GetAllSavingResponse.builder()
                .list(depositInfoList)
                .build();
        return result;
    }
}
