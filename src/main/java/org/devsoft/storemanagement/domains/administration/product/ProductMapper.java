package org.devsoft.storemanagement.domains.administration.product;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.devsoft.storemanagement.common.dto.PagedResponse;
import org.devsoft.storemanagement.common.entities.Product;
import org.devsoft.storemanagement.domains.administration.product.response.FetchProductResponse;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ProductMapper {

    public static PagedResponse<FetchProductResponse> listProductToPagedResponse(final List<Product> products, final int page,
                                                                                 final int size, final long totalElements) {
        return PagedResponse.<FetchProductResponse>builder()
                .data(listProductToFetchProductResponse(products))
                .page(page)
                .size(size)
                .totalElements(totalElements)
                .build();
    }

    private static List<FetchProductResponse> listProductToFetchProductResponse(final List<Product> products) {
        return products.stream().map(product -> FetchProductResponse
                        .builder()
                        .code(product.getCode())
                        .name(product.getName())
                        .description(product.getDescription())
                        .entryPrice(product.getEntryPrice())
                        .salePrice(product.getSalePrice())
                        .typeProduct(product.getTypeProduct().getId())
                        .category(product.getCategory().getId())
                        .quantity(product.getQuantity())
                        .build())
                .toList();
    }

}
