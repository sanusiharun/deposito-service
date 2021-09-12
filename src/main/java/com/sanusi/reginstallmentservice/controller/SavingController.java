package com.sanusi.reginstallmentservice.controller;

import com.sanusi.reginstallmentservice.common.Response;
import com.sanusi.reginstallmentservice.model.requests.CreateSavingRequest;
import com.sanusi.reginstallmentservice.model.responses.CreateSavingResponse;
import com.sanusi.reginstallmentservice.model.responses.GetAllSavingResponse;
import com.sanusi.reginstallmentservice.sevices.CreateSavingService;
import com.sanusi.reginstallmentservice.sevices.GetAllSavingService;
import com.sanusi.reginstallmentservice.sevices.GetSavingByAccountNumberService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.log4j.Log4j2;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

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

    @Operation(summary = "List All Saving Accounts", description = "Retrieve available list saving account with none parameter")
    @GetMapping
    public Response<GetAllSavingResponse> getAllSavings(){
        return Response.success(200, getAllAccountService.execute());
    }

    @Operation(summary = "Get saving account by account number", description = "Retrieve saving account by account number")
    @GetMapping(value = "/{accountNumber}")
    public Response<GetAllSavingResponse> getSavingByAccountNumber(@PathVariable("accountNumber") String accountNumber) {
        return Response.success(200, getSavingByAccountNumberService.execute(accountNumber));
    }

    @Operation(summary = "Create saving", description = "Retrieve account saving info when success")
    @PostMapping("/create")
    public Response<CreateSavingResponse> createSaving(@RequestBody CreateSavingRequest request) {
        return Response.success(200, createSavingService.execute(request));
    }
}
