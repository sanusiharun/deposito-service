package com.sanusi.reginstallmentservice.model.requests;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
public class CreateSavingRequest {

    @NotNull(message = "Tenor is mandatory") @Min(1)
    @ApiModelProperty(notes = "Tenor is number greather than 0")
    private Integer tenor;

    @NotNull
    @NotBlank
    @ApiModelProperty(notes = "Account number is mandatory")
    private String accountNumber;

    @NotNull(message = "First amount is mandatory") @Min(1000000)
    @ApiModelProperty(notes = "First Amount is number")
    private Long firstAmount;

    @NotNull(message = "monthly amount is mandatory") @Min(100)
    @ApiModelProperty(notes = "monthly amount is number")
    private Long monthlyAmount;

    @NotNull(message = "Tenor is mandatory")
    @NotBlank(message = "Purpose must be not blank")
    @ApiModelProperty(notes = "saving purpose is mandatory")
    private String savingPurpose;
}
