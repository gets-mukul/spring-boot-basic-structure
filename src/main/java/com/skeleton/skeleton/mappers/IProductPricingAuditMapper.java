package com.skeleton.skeleton.mappers;

import com.skeleton.skeleton.dtos.ProductPricingAuditDTO;
import com.skeleton.skeleton.entities.ProductPricingAudit;
import lombok.NonNull;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IProductPricingAuditMapper {

    ProductPricingAuditDTO convertEntityToDTO(@NonNull final ProductPricingAudit auditEntity);

    ProductPricingAudit convertDTOToEntity(@NonNull final ProductPricingAuditDTO auditDTO);
}
