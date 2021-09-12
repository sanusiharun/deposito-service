package com.sanusi.reginstallmentservice.sevices;

import com.sanusi.reginstallmentservice.model.requests.CalculatorRequest;
import com.sanusi.reginstallmentservice.model.responses.CalculatorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Set;

@Service
public class CalculatorSimulationService {

    private CalculatorService calculatorService;

    @Autowired
    private Validator validator;

    public CalculatorSimulationService(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    public CalculatorResponse execute(CalculatorRequest request) {
        final Set<ConstraintViolation<Object>> result = validator.validate(request);
        if (!result.isEmpty()) {
            throw new ConstraintViolationException(result);
        }

        BigDecimal grantTotalDepositAmount = calculatorService.calculate(request);

        return CalculatorResponse.builder().finalBalance(grantTotalDepositAmount).build();
    }
}
