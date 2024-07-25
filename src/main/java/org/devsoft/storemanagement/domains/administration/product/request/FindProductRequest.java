package org.devsoft.storemanagement.domains.administration.product.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FindProductRequest {

    private Optional<String> code;
    private Optional<String> name;
    private Optional<String> description;
    private Optional<String> codeTypeProduct;
    private Optional<String> codeCategory;
    private Optional<Long> quantity;
    private int page;
    private int size;
}
