package org.devsoft.storemanagement.common.config;

import lombok.extern.slf4j.Slf4j;
import org.devsoft.storemanagement.common.dto.ResultDTO;
import org.devsoft.storemanagement.common.exceptions.BusinessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class HandlerException {

    @ExceptionHandler({BusinessException.class})
    public ResponseEntity<ResultDTO> handlerBusinessException(final BusinessException e) {
        return ResponseEntity.ok(new ResultDTO(Boolean.FALSE,  e.getMessage()));
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ResultDTO> handlerException(final Exception e) {
        log.error(e.getMessage(), e);
        return ResponseEntity.ok(new ResultDTO(Boolean.FALSE,  e.getMessage()));
    }
}
