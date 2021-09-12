package com.sanusi.reginstallmentservice.model.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Builder
@AllArgsConstructor
public class CreateSavingRequest {

    private Integer tenor;
    private String accountNumber;
    private Long firstAmount;
    private Long monthlyAmount;
    private String savingPurpose;
}
