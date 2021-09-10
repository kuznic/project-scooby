package com.meedra;


import com.meedra.implementation.MerchantServiceImpl;
import com.meedra.model.Merchant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class MerchantTest {

    @Autowired
    MerchantServiceImpl merchantService;

    @Test
    public void testCreateMerchant() throws Exception {
        Merchant merchant = new Merchant();
        merchant.setMerchantName("Ade and sons");
        merchant.setMerchantLocation("10, Edison Drive");

    }



}
