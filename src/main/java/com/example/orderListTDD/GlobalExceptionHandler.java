package com.example.orderListTDD;

import com.example.orderListTDD.InsertOrder.InsertOrderBadRequestException;
import com.example.orderListTDD.InsertOrder.InsertOrderConflictException;
import com.example.orderListTDD.QueryOrderByNo.QueryOrderByNoNotFoundException;
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

    // 400
    @ExceptionHandler(InsertOrderBadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected Map<String,String> handleInsertOrderBadRequestException(InsertOrderBadRequestException e) {
        log.error("handleInsertOrderBadRequestException", e);
        return Map.of("status", "400", "err_msg", "錯誤的請求(400 BAD_REQUEST)");
    }

    // 404
    @ExceptionHandler(QueryOrderByNoNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    protected Map<String, String> handleQueryOrderByNoNotFoundException(QueryOrderByNoNotFoundException e) {
        log.error("handleQueryNoApprovalFormFoundException", e);
        return Map.of("status", "404", "err_msg", "查無訂單(404 NOT_FOUND)");
    }

    // 409
    @ExceptionHandler(InsertOrderConflictException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    protected Map<String, String> handleInsertOrderConflictException(InsertOrderConflictException e) {
        log.error("handleInsertOrderConflictException", e);
        return Map.of("status", "409", "err_msg", "訂單已存在(409 CONFLICT)");
    }
}
