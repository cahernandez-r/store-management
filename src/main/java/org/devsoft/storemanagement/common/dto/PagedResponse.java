package org.devsoft.storemanagement.common.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PagedResponse<T> {
    private List<T> data;
    private Integer page;
    private Integer size;
    private Long totalElements;
}
