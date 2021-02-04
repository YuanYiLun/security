package cn.hyperchain.demo.config;

import cn.hyperchain.demo.base.MyBaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * File: GlobalExceptionHandler.java
 * Description:
 * Company:
 *
 * @Author: yyz
 * Datetime: 2021-01-15
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({MethodArgumentNotValidException.class, BindException.class})
    public ResponseEntity handleValidationException(MethodArgumentNotValidException e) {
        log.error("Validation Exception: ", e);
        FieldError fe = (FieldError) e.getBindingResult().getAllErrors().get(0);
        String message = String.format("%s %s", fe.getField(), Strings.isNotBlank(fe.getDefaultMessage()) ? fe.getDefaultMessage() : e.getMessage());
        return ResponseEntity.badRequest().body(MyBaseResponse.with(HttpStatus.BAD_REQUEST.value(), message));
    }

}
