package com.example.orderListTDD.InsertOrder;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class InsertOrderController {

    private final InsertOrderService insertOrderService;

    @PostMapping("/insert")
    public InsertOrderResponse insertOrder(@RequestBody InsertOrderRequest insertOrderRequest) {
//        System.out.println("================insertOrderRequest================" + insertOrderRequest);
        return insertOrderService.insertOrder(insertOrderRequest);
    }
}
