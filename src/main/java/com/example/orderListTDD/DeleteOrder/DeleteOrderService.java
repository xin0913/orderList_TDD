package com.example.orderListTDD.DeleteOrder;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteOrderService {

    private final DeleteOrderRepository deleteOrderRepository;

    public DeleteOrderByOrderNoResponse deleteOrderByOrderNo(String orderNo) {

        if (deleteOrderRepository.existsByNo(orderNo)) {
            deleteOrderRepository.deleteByNo(orderNo);
            return new DeleteOrderByOrderNoResponse(orderNo + " 訂單刪除成功");
        } else {
            return new DeleteOrderByOrderNoResponse(orderNo + " 訂單不存在");
        }

    }
}
