package com.sanusi.reginstallmentservice.model.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
public class GetSavingInfoResponse {
    private String accountNumber;
    private String accountName;
    private String productName;
    private String currency;
    private BigDecimal finalBalance;
    private BigDecimal firstAmount;
    private BigDecimal monthlyDepositAmount;
    private Integer tenor;
    private Date startDate;
    private Date maturityDate;
}
