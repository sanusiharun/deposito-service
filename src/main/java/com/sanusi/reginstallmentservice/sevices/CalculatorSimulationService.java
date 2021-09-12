package com.sanusi.reginstallmentservice.sevices;

import com.sanusi.reginstallmentservice.model.requests.CalculatorRequest;
import com.sanusi.reginstallmentservice.model.responses.CalculatorResponse;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

@Service
public class CalculatorSimulationService {

    private CalculatorService calculatorService;

    public CalculatorSimulationService(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    public CalculatorResponse execute(CalculatorRequest request) {

        BigDecimal grantTotalDepositAmount = calculatorService.calculate(request);

        return CalculatorResponse.builder().finalBalance(grantTotalDepositAmount).build();
    }
}
