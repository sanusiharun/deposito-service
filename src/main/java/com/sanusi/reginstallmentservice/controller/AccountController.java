package com.sanusi.reginstallmentservice.controller;

import com.sanusi.reginstallmentservice.common.Response;
import com.sanusi.reginstallmentservice.model.responses.GetAllAccountResponse;
import com.sanusi.reginstallmentservice.sevices.GetAllAccountService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Log4j2
@RequestMapping("account")
public class AccountController {

    private GetAllAccountService getAllAccountService;

    public AccountController(GetAllAccountService getAllAccountService) {
        this.getAllAccountService = getAllAccountService;
    }

    @Operation(summary = "List accounts", description = "Retrieve available account for testing")
    @GetMapping()
    public Response<List<GetAllAccountResponse>> getAllAccounts(){
        return Response.success(200, getAllAccountService.execute());
    }
}
