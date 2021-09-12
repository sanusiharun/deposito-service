package com.sanusi.reginstallmentservice.model.responses;

import com.sanusi.reginstallmentservice.model.projections.DepositInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class GetAllSavingResponse {
    private List<DepositInfo> list;
}
