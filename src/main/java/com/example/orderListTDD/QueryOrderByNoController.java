package com.example.orderListTDD;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class QueryOrderByNoController {

    private final QueryOrderByNoService queryOrderByNoService;

    @GetMapping("/query/{orderNo}")
    public QueryOrderByNoResponse queryOrderByNo(@PathVariable String orderNo) {
        return queryOrderByNoService.queryOrderTitleByOrderNo(orderNo);
    }
}