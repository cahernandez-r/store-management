package org.devsoft.storemanagement.domains.administration.product;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.devsoft.storemanagement.common.dto.PagedResponse;
import org.devsoft.storemanagement.common.repositories.ProductRepository;
import org.devsoft.storemanagement.common.repositories.specifications.SpecificationProduct;
import org.devsoft.storemanagement.domains.administration.product.request.FindProductRequest;
import org.devsoft.storemanagement.domains.administration.product.response.FetchProductResponse;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Transactional
@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;
    public PagedResponse<FetchProductResponse> findProductsByFilters (FindProductRequest request) {
        var especification  = SpecificationProduct.createFilmSpecifications(request);
        var resultPagedProduct = productRepository.findAll(especification, PageRequest.of(request.getPage(), request.getSize()));
        return ProductMapper.listProductToPagedResponse(resultPagedProduct.getContent(), request.getPage(), request.getSize(), resultPagedProduct.getTotalElements());
    }
}
