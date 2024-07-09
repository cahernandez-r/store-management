package org.devsoft.storemanagement.common.exceptions;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BusinessException extends RuntimeException {

    private String message;

    public BusinessException(final String message) {
        super(message);
        this.message = message;
    }
}
