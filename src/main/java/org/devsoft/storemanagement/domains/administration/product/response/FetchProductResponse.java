package org.devsoft.storemanagement.domains.administration.product.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.devsoft.storemanagement.common.dto.ResultDTO;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FetchProductResponse extends ResultDTO {

    private String code;
    private String name;
    private String description;
    private BigDecimal entryPrice;
    private BigDecimal salePrice;
    private Long typeProduct;
    private Long category;
    private Long quantity;
}
