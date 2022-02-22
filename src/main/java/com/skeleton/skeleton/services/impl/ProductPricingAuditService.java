package com.skeleton.skeleton.services.impl;

import com.skeleton.skeleton.dtos.ProductPricingAuditDTO;
import com.skeleton.skeleton.entities.ProductPricingAudit;
import com.skeleton.skeleton.mappers.IProductPricingAuditMapper;
import com.skeleton.skeleton.repositories.IProductPricingAuditRepository;
import com.skeleton.skeleton.services.IProductPricingAuditService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductPricingAuditService implements IProductPricingAuditService {

    private final IProductPricingAuditRepository productPricingAuditRepo;
    private final IProductPricingAuditMapper productPricingAuditMapper;

    @Override
    public ProductPricingAuditDTO createNewProductPricingAudit(final ProductPricingAuditDTO auditDto) {
        final ProductPricingAudit productPricingAudit = productPricingAuditMapper.convertDTOToEntity(auditDto);
        final ProductPricingAudit newAudit = productPricingAuditRepo.save(productPricingAudit);
        log.info("new audit has been recorded with id: {}", newAudit.getId());
        return productPricingAuditMapper.convertEntityToDTO(newAudit);
    }
}
