package com.sanusi.reginstallmentservice.model.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class GetAllAccountResponse {
    private String accountNumber;
    private String accountName;
    private String phoneNumber;
    private String cif;
    private String address;
    private String currency;
}
