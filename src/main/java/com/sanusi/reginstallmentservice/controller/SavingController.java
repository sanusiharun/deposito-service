package com.sanusi.reginstallmentservice.controller;

import com.sanusi.reginstallmentservice.common.Response;
import com.sanusi.reginstallmentservice.model.requests.CreateSavingRequest;
import com.sanusi.reginstallmentservice.model.responses.CreateSavingResponse;
import com.sanusi.reginstallmentservice.model.responses.GetAllSavingResponse;
import com.sanusi.reginstallmentservice.sevices.CreateSavingService;
import com.sanusi.reginstallmentservice.sevices.GetAllSavingService;
import com.sanusi.reginstallmentservice.sevices.GetSavingByAccountNumberService;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

@RestController
@Log4j2
@RequestMapping("saving")
public class SavingController {

    private GetAllSavingService getAllAccountService;
    private CreateSavingService createSavingService;
    private GetSavingByAccountNumberService getSavingByAccountNumberService;

    public SavingController(GetAllSavingService getAllAccountService, CreateSavingService createSavingService,
                            GetSavingByAccountNumberService getSavingByAccountNumberService) {
        this.getAllAccountService = getAllAccountService;
        this.createSavingService = createSavingService;
        this.getSavingByAccountNumberService = getSavingByAccountNumberService;
    }

    @GetMapping
    public Response<GetAllSavingResponse> getAllSavings(){
        return Response.success(200, getAllAccountService.execute());
    }

    @GetMapping(value = "/{accountNumber}")
    public Response<GetAllSavingResponse> getSavingByAccountNumber(@PathVariable("accountNumber") String accountNumber) {
        return Response.success(200, getSavingByAccountNumberService.execute(accountNumber));
    }

    @PostMapping
    public Response<CreateSavingResponse> createSaving(@RequestBody CreateSavingRequest request) {
        return Response.success(200, createSavingService.execute(request));
    }
}
