package com.example.orderListTDD.EditOrder;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EditOrderController {
    private final EditOrderService editOrderService;
    @PutMapping("/edit/{no}")
    public EditOrderResponse editOrderByNo(@RequestBody EditOrderRequest editOrderRequest, @PathVariable String no) {
//        System.out.println("\neditOrderRequest: " + editOrderRequest + "\nno: " + no);
        return editOrderService.editOrderByNo(editOrderRequest, no);
    }
}
