package com.example.orderListTDD;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private final static Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    // 404
    @ExceptionHandler(QueryOrderByNoNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    protected Map<String, String> handlQueryOrderByNoNotFoundException(QueryOrderByNoNotFoundException e) {
        log.error("handleQueryNoApprovalFormFoundException", e);
        return Map.of("orderStatus", "FAIL", "err_msg", "查無訂單(404 NOT_FOUND)");
    }
}
