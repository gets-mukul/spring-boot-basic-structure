package com.skeleton.skeleton.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Setter
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductPricingAuditDTO {

    private String id;
    private Double oldBaseAmount;
    private Double newBaseAmount;
    private String cityId;
    private String skuId;
    private String productId;
    private String productName;
    private String maker;
    private String checker;
    private String reason;
    private String updatedBy;
    private LocalDateTime updatedOn;
    private String createdBy;
    private LocalDateTime createdOn;
}
