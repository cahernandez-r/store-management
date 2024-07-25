package org.devsoft.storemanagement.domains.administration.product;

import lombok.RequiredArgsConstructor;
import org.devsoft.storemanagement.common.dto.PagedResponse;
import org.devsoft.storemanagement.domains.administration.product.request.FindProductRequest;
import org.devsoft.storemanagement.domains.administration.product.response.FetchProductResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(ProductRoute.PRODUCTS)
public class ProductController {

    private final ProductService productService;

    @PostMapping(ProductRoute.FIND_PRODUCTS_BY_FILTERS)
    public PagedResponse<FetchProductResponse> findProductsByFilters(@RequestBody final FindProductRequest request) {
        return productService.findProductsByFilters(request);
    }
}
