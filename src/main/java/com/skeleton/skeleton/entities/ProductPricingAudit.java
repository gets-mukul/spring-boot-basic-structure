package com.skeleton.skeleton.entities;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import static com.skeleton.skeleton.constants.DB.Schema.LICIOUS;
import static com.skeleton.skeleton.constants.DB.Table.PRODUCT_PRICING_AUDIT_TABLE;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = PRODUCT_PRICING_AUDIT_TABLE, catalog = LICIOUS)
public class ProductPricingAudit extends BaseEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;

    @Column(name = "old_base_amount", nullable = false)
    private Double oldBaseAmount;

    @Column(name = "new_base_amount", nullable = false)
    private Double newBaseAmount;

    @Column(name = "city_id", nullable = false)
    private String cityId;

    @Column(name = "sku_id", nullable = false)
    private String skuId;

    @Column(name = "product_id", nullable = false)
    private String productId;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "maker")
    private String maker;

    @Column(name = "checker")
    private String checker;

    @Column(name = "reason")
    private String reason;
}
