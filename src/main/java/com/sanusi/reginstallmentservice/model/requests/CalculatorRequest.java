package com.sanusi.reginstallmentservice.model.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CalculatorRequest {

    private Integer tenor;
    private Long firstAmount;
    private Long monthlyAmount;
    private String product;
}
