package com.sanusi.reginstallmentservice.sevices;

import com.sanusi.reginstallmentservice.model.requests.CalculatorRequest;
import com.sanusi.reginstallmentservice.model.responses.CalculatorResponse;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

@Service
public class CalculatorService {

    private Double percentage(double p) {
        return (float)p/100.0;
    }

    private Double tenor(Integer tenor) {
        return (float)tenor/12.0;
    }

    public BigDecimal calculate(CalculatorRequest request){
        BigDecimal grantTotalDepositAmount =null;
        BigDecimal amount = null;
        double tenor = tenor(request.getTenor());
        double pctg = percentage(6);
        MathContext m = new MathContext(2);
        for(int i = 0; i < request.getTenor();i++){
            if(i > 0) {
                amount = amount.add(BigDecimal.valueOf(request.getMonthlyAmount()));
            }else {
                amount = BigDecimal.valueOf(request.getFirstAmount());

            }
        }
        return (amount.multiply(BigDecimal.valueOf((float)tenor*pctg)).add(amount)).setScale(2, RoundingMode.HALF_EVEN);
    }
}
