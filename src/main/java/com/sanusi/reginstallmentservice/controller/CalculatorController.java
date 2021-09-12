package com.sanusi.reginstallmentservice.controller;

import com.sanusi.reginstallmentservice.common.Response;
import com.sanusi.reginstallmentservice.model.requests.CalculatorRequest;
import com.sanusi.reginstallmentservice.model.responses.CalculatorResponse;
import com.sanusi.reginstallmentservice.sevices.CalculatorService;
import com.sanusi.reginstallmentservice.sevices.CalculatorSimulationService;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

@RestController
@Log4j2
@RequestMapping("calculator")
public class CalculatorController {

    private CalculatorSimulationService calculatorSimulationService;

    public CalculatorController(CalculatorSimulationService calculatorSimulationService) {
        this.calculatorSimulationService = calculatorSimulationService;
    }

    @GetMapping(value = "simulation/{tenor}/{firstAmount}/{monthlyAmount}")
    public Response<CalculatorResponse> calculate(@PathVariable("tenor") Integer tenor,
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
