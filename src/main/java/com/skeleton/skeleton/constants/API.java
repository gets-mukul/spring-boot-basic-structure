package com.skeleton.skeleton.constants;

import lombok.experimental.UtilityClass;

@UtilityClass
public class API {

    public class Resource {
        public static final String BASE_URL = "/api/v1";
        public static final String PRODUCT_PRICING_AUDIT_URL = "/product-pricing-audit";
    }

    public class Status {
        public static final String SUCCESS = "200";
        public static final String FAIL = "500";
    }
}
