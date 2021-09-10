package com.meedra.implementation;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.meedra.dto.MerchantDto;
import com.meedra.dto.MerchantResponseDto;
import com.meedra.model.Merchant;
import com.meedra.repository.MerchantRepository;
import com.meedra.service.MerchantService;
import lombok.var;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;



@Component
public class MerchantServiceImpl implements MerchantService {

    @Autowired
    MerchantRepository merchantRepo;

    @Autowired
    MerchantResponseDto merchantResponse;


    @Override
    public MerchantResponseDto createMerchant(MerchantDto merchant) {
        var newMerchant = new Merchant();
        BeanUtils.copyProperties(merchant, newMerchant);
        newMerchant.setMerchantId(UUID.randomUUID());
        newMerchant.setCreatedDate(Date.from(Instant.now()));
        newMerchant = merchantRepo.save(newMerchant);

        BeanUtils.copyProperties(newMerchant, merchantResponse);
        return merchantResponse;
    }

    @Override
    public MerchantResponseDto updateMerchant(MerchantDto merchant) {
        return null;
    }

    @Override
    public MerchantResponseDto deleteMerchant(UUID merchantId) {
        return null;
    }

    @Override
    public MerchantResponseDto getMerchant(UUID merchantId) {
        return null;
    }

    @Override
    public MerchantResponseDto getAllMerchants(Pageable page) {
        return null;
    }
}
