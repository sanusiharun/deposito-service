package com.sanusi.reginstallmentservice.model.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
public class CalculatorResponse {
    private BigDecimal finalBalance;
}
