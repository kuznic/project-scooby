package com.meedra.service;

import com.meedra.dto.MerchantDto;
import com.meedra.dto.MerchantResponseDto;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface MerchantService {

    MerchantResponseDto createMerchant(MerchantDto merchant);
    MerchantResponseDto updateMerchant(MerchantDto merchant);
    MerchantResponseDto deleteMerchant(UUID merchantId);
    MerchantResponseDto getMerchant(UUID merchantId);
    MerchantResponseDto getAllMerchants(Pageable page);


}
