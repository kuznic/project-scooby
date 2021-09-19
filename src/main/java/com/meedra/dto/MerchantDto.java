package com.meedra.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Data
@Slf4j
@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MerchantDto {
    @JsonProperty(value = "merchantName")
    private String merchantName;

    @JsonProperty(value = "merchantLocation")
    private String merchantLocation;
}
