package org.devsoft.storemanagement.common.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ResultDTO implements Serializable {

    private Boolean isSuccessful;
    private String errorMessage;
    private String codeErrorMessage;
    private String cause;

    public ResultDTO() {

    }

    public ResultDTO(final Boolean isSuccessful, final String errorMessage) {
        this.isSuccessful = isSuccessful;
        this.errorMessage = errorMessage;
    }
}
