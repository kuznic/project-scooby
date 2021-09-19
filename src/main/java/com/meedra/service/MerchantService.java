package com.meedra.service;

import com.meedra.dto.MerchantDto;
import com.meedra.dto.MerchantResponseDto;
import javassist.NotFoundException;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface MerchantService {

    MerchantResponseDto createMerchant(MerchantDto merchant);
    MerchantResponseDto updateMerchant(MerchantDto merchant);
    MerchantResponseDto deleteMerchant(UUID merchantId);
    MerchantResponseDto getMerchant(UUID merchantId) throws NotFoundException;
    MerchantResponseDto getAllMerchants(Pageable page);


}
