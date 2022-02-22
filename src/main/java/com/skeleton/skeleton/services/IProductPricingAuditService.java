package com.skeleton.skeleton.services;

import com.skeleton.skeleton.dtos.ProductPricingAuditDTO;
import org.springframework.stereotype.Service;

@Service
public interface IProductPricingAuditService {
    ProductPricingAuditDTO createNewProductPricingAudit(ProductPricingAuditDTO auditDto);
}
