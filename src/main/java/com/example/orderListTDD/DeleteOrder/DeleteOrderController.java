package com.example.orderListTDD.DeleteOrder;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DeleteOrderController {

    private final DeleteOrderService deleteOrderService;
    @DeleteMapping("/delete/{orderNo}")
    public DeleteOrderByOrderNoResponse deleteOrderByOrderNo(@PathVariable String orderNo) {
        return deleteOrderService.deleteOrderByOrderNo(orderNo);
    }
}
