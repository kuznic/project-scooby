package com.meedra;


import com.meedra.model.Merchant;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class MerchantTest {


    @Test
    public void testCreateMerchant() {
        Merchant merchant = new Merchant();
        merchant.setMerchantName("Ade and sons");
        merchant.setMerchantLocation("10, Edison Drive");

    }



}
