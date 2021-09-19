package com.meedra.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Data
@Slf4j
@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MerchantResponseDto implements Serializable {
    @JsonProperty(value="merchantId")
    private UUID merchantId;;

    @JsonProperty(value = "merchantName")
    private String merchantName;

    @JsonProperty(value = "merchantLocation")
    private String merchantLocation;

    @JsonProperty(value = "createdDate")
    private Date createdDate;

    @JsonProperty(value = "modifiedDate")
    private Date modifiedDate;
}
