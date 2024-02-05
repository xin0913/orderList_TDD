package com.example.orderListTDD.EditOrder;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/*
 * 使用 orderNo 修改 order
 * [PUT]："/edit/{orderNo}"
 * ex：/edit/A123
 * ===========================
 * request: {
 *   title: "ORDER 2",
 *   status: "2"
 * }
 * status:
 * 1: 待付款
 * 2: 已完成
 * 3: 作廢
 * ---------------------------
 * response: {
 *   msg: "訂單修改成功",
 *   resCode: "000"
 * }
 * response: {
 *   msg: "訂單修改錯誤",
 *   resCode: "001"
 * }
 * resCode:
 * 000: 成功
 * 001: 失敗
 * */
@ExtendWith(MockitoExtension.class)
class EditOrderServiceTest {
    @InjectMocks
    private EditOrderService editOrderService;

    @Mock
    private EditOrderRepository editOrderRepository;

    @Test
    void test_edit_order_by_no_should_be_successful() {
        String no = "A123";
        String title = "ORDER 2";
        String status = "2";

        // Request：
        EditOrderRequest editOrderRequest = new EditOrderRequest();
        editOrderRequest.setTitle(title);
        editOrderRequest.setStatus(status);

        // Entity：
        EditOrderEntity editOrderEntity = new EditOrderEntity();
        editOrderEntity.setNo(no);
        editOrderEntity.setTitle(title);
        editOrderEntity.setStatus(status);

        given(editOrderRepository.findByNo(no)).willReturn(editOrderEntity);

        // 預期：
        EditOrderResponse expected = new EditOrderResponse();
        expected.setMsg(no + " 訂單修改成功");
        expected.setResCode("000");

        // 實際：
        EditOrderResponse actual = editOrderService.editOrderByNo(editOrderRequest, no);

        // 比較：
        assertThat(actual).isEqualTo(expected);
        System.out.println("================actual=================" + actual);
        System.out.println("================expected=================" + expected);

        // Verify：
        verify(editOrderRepository, times(1)).findByNo(no);
    }
}
