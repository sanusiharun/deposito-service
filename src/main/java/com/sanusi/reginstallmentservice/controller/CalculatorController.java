package com.sanusi.reginstallmentservice.controller;

import com.sanusi.reginstallmentservice.common.Response;
import com.sanusi.reginstallmentservice.model.requests.CalculatorRequest;
import com.sanusi.reginstallmentservice.model.responses.CalculatorResponse;
import com.sanusi.reginstallmentservice.sevices.CalculatorService;
import com.sanusi.reginstallmentservice.sevices.CalculatorSimulationService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.log4j.Log4j2;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@RestController
@Log4j2
@RequestMapping("calculator")
@Validated
public class CalculatorController {

    private CalculatorSimulationService calculatorSimulationService;

    public CalculatorController(CalculatorSimulationService calculatorSimulationService) {
        this.calculatorSimulationService = calculatorSimulationService;
    }

    @Operation(summary = "Saving Account Calculator", description = "Retrieve calculation final balance")
    @GetMapping(value = "simulation/{tenor}/{firstAmount}/{monthlyAmount}")
    public Response<CalculatorResponse> calculate(@Valid @NotNull(message = "Tenor is mandatory") @Min(1) @PathVariable("tenor") Integer tenor,
                                                  @PathVariable("firstAmount") Long firstAmount,
                                                  @PathVariable("monthlyAmount") Long monthlyAmount) {
        CalculatorRequest request = CalculatorRequest.builder()
                .tenor(tenor)
                .firstAmount(firstAmount)
                .monthlyAmount(monthlyAmount)
                .build();
        return Response.success(200, calculatorSimulationService.execute(request));
    }

}
