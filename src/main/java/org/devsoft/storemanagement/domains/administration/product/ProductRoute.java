package org.devsoft.storemanagement.domains.administration.product;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductRoute {

    public static final String PRODUCTS  = "products";
    public static final String FIND_PRODUCTS_BY_FILTERS = "find_products_by_filters";
}
