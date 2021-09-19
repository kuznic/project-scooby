package com.meedra.listeners;

import com.meedra.model.Merchant;

import javax.persistence.PreUpdate;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class MerchantListener {

    @PreUpdate
    private void beforeUpdate(Merchant merchant)
    {
        merchant.setUpdatedAt(LocalDateTime.now(ZoneId.of("Africa/Lagos")));
    }
}
