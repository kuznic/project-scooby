package com.meedra.controller;


import com.meedra.dto.MerchantDto;
import com.meedra.dto.MerchantResponseDto;
import com.meedra.implementation.MerchantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@RequestMapping("/api/scooby/v1/merchant")
public class MerchantController {

    @Autowired
    MerchantServiceImpl merchantService;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public MerchantResponseDto createMerchant(@Validated @RequestBody MerchantDto merchant) throws HttpClientErrorException.BadRequest
    {
        return merchantService.createMerchant(merchant);

    }

}
