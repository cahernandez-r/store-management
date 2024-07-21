package org.devsoft.storemanagement.domains.administration.product;

import lombok.RequiredArgsConstructor;
import org.devsoft.storemanagement.common.dto.PagedResponse;
import org.devsoft.storemanagement.domains.administration.product.request.FindProductRequest;
import org.devsoft.storemanagement.domains.administration.product.response.FetchProductResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("products")
public class ProductController {

    private final ProductService productService;

    @GetMapping("findProductsByFilters")
    public PagedResponse<FetchProductResponse> findProductsByFilters(@RequestBody FindProductRequest request) {
        return productService.test(request);
    }
}
