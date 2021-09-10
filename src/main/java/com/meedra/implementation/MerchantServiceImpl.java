package com.meedra.implementation;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.meedra.dto.MerchantDto;
import com.meedra.dto.MerchantResponseDto;
import com.meedra.model.Merchant;
import com.meedra.repository.MerchantRepository;
import com.meedra.service.MerchantService;
import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;



@Component
@Slf4j
public class MerchantServiceImpl implements MerchantService {

    @Autowired
    MerchantRepository merchantRepo;

    @Autowired
    private CacheManager cacheManager;


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
    @Cacheable(value = "merchantCache", key = "#merchantId")
    public MerchantResponseDto getMerchant(UUID merchantId) throws NotFoundException {
        var retrievedMerchant = merchantRepo.findByMerchantIdAndIsDeletedFalse(merchantId);
        if (retrievedMerchant.isPresent())
        {
            BeanUtils.copyProperties(retrievedMerchant.get(), merchantResponse);
        }
        else{
            throw new NotFoundException("Merchant with id" + merchantId + "does not exist");
        }

        return merchantResponse;
    }

    @Override
    public MerchantResponseDto getAllMerchants(Pageable page) {
        return null;
    }


}
