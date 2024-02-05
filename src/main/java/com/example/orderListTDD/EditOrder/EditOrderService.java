package com.example.orderListTDD.EditOrder;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EditOrderService {

    private final EditOrderRepository editOrderRepository;
    public EditOrderResponse editOrderByNo(EditOrderRequest editOrderRequest, String no) {
        EditOrderEntity existingOrder = editOrderRepository.findByNo(no);
        existingOrder.setNo(no);
        existingOrder.setTitle(editOrderRequest.getTitle());
        existingOrder.setStatus(editOrderRequest.getStatus());

        EditOrderResponse response = new EditOrderResponse();
        try {
            editOrderRepository.save(existingOrder);
            response.setMsg(no + " 訂單修改成功");
            response.setResCode("000");
        }
        catch (Exception e) {
            response.setMsg(no + " 訂單修改失敗");
            response.setResCode("001");
        }
        return response;
    }
}
