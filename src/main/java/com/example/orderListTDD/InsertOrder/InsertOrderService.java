package com.example.orderListTDD.InsertOrder;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class InsertOrderService {

    private final InsertOrderRepository insertOrderRepository;
    public InsertOrderResponse insertOrder(InsertOrderRequest insertOrderRequest) {

        InsertOrderEntity response = insertOrderRepository.save(insertOrderRequest);

        InsertOrderResponse insertOrderResponse = new InsertOrderResponse();
        insertOrderResponse.setMsg(response.getNo() + " 訂單新增成功");
        insertOrderResponse.setStatus(response.getStatus());
//        System.out.println("==========InsertOrderResponse==========" + insertOrderResponse);
        return insertOrderResponse;
    }
}
