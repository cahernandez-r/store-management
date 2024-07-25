package org.devsoft.storemanagement.common.repositories.specifications;

import jakarta.persistence.criteria.Join;
import org.devsoft.storemanagement.common.entities.Category;
import org.devsoft.storemanagement.common.entities.Product;
import org.devsoft.storemanagement.common.entities.TypeProduct;
import org.devsoft.storemanagement.domains.administration.product.request.FindProductRequest;
import org.springframework.data.jpa.domain.Specification;

import java.util.Optional;

public class SpecificationProduct {

    public static Specification<Product> createFilmSpecifications(final FindProductRequest request) {
        return filterCode(request.getCode())
                .and(filterNameProduct(request.getName())
                        .and(filterQuantityProduct(request.getQuantity())
                                .and(filterCategory(request.getCodeCategory())
                                        .and(filterProduct(request.getCodeTypeProduct())))));
    }

    public static Specification<Product> filterCode(final Optional<String> opCodeProduct) {
        return (root, query, builder) -> opCodeProduct.map(productCode -> builder.equal(root.get("code"), (productCode))
        ).orElse(null);
    }

    public static Specification<Product> filterNameProduct(final Optional<String> opNameProduct) {
        return (root, query, builder) -> opNameProduct.map(productName -> builder.like(root.get("name"), "%" + (productName) + "%")
        ).orElse(null);
    }

    public static Specification<Product> filterQuantityProduct(final Optional<Long> opQuantityProduct) {
        return (root, query, builder) -> opQuantityProduct.map(productQuantity -> builder.equal(root.get("quantity"), (productQuantity))
        ).orElse(null);
    }

    public static Specification<Product> filterProduct(final Optional<String> opTypeProduct) {
        return (root, query, builder) -> {
            Join<Product, TypeProduct> joinTypeProduct = root.join("typeProduct");
            return opTypeProduct.map(typeCodeProduct -> builder.equal(joinTypeProduct.get("code"), (typeCodeProduct))
            ).orElse(null);
        };
    }
    public static Specification<Product> filterCategory(final Optional<String> opTypeCategory) {
        return (root, query, builder) -> {
            Join<Product, Category> joinProductCategory = root.join("category");
            return opTypeCategory.map(categoryCodeProduct -> builder.equal(joinProductCategory.get("code"), (categoryCodeProduct))
            ).orElse(null);
        };
    }
}
