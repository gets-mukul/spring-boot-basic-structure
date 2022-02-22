package com.skeleton.skeleton.repositories;

import com.skeleton.skeleton.entities.ProductPricingAudit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductPricingAuditRepository extends JpaRepository<ProductPricingAudit, String> {
}
