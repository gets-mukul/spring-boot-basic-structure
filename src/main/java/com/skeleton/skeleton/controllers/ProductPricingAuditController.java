package com.skeleton.skeleton.controllers;

import com.skeleton.skeleton.dtos.ProductPricingAuditDTO;
import com.skeleton.skeleton.entities.APIResponse;
import com.skeleton.skeleton.services.impl.ProductPricingAuditService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.skeleton.skeleton.constants.API.Resource.BASE_URL;
import static com.skeleton.skeleton.constants.API.Resource.PRODUCT_PRICING_AUDIT_URL;
import static com.skeleton.skeleton.constants.API.Status.FAIL;
import static com.skeleton.skeleton.constants.API.Status.SUCCESS;

@RestController
@RequestMapping(BASE_URL + PRODUCT_PRICING_AUDIT_URL)
@RequiredArgsConstructor
public class ProductPricingAuditController {

    private final ProductPricingAuditService auditService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public APIResponse createProductPricingAudit(@RequestBody final ProductPricingAuditDTO auditDto) {
        try {
            final ProductPricingAuditDTO response = auditService.createNewProductPricingAudit(auditDto);
            return new APIResponse(SUCCESS, String.format("product price update audited successfully id: %s", response.getId()), null, response);
        } catch (final Exception e) {
            return new APIResponse(FAIL, "Error while creating new audit", e.getMessage(), e.getClass());
        }
    }
}
