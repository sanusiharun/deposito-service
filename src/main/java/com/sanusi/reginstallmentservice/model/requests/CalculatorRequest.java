package com.sanusi.reginstallmentservice.model.requests;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
public class CalculatorRequest {

    @NotNull(message = "Tenor is mandatory")
    @Min(1)
    @ApiModelProperty(notes = "Tenor is number greather than 0")
    private Integer tenor;

    @NotNull(message = "First amount is mandatory")
    @Min(1000000)
    @ApiModelProperty(notes = "First is number")
    private Long firstAmount;

    @Min(value = 100)
    @ApiModelProperty(notes = "First is number")
    private Long monthlyAmount;
}
