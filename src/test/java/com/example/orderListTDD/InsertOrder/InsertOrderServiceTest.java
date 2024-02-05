package com.example.orderListTDD.InsertOrder;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

/*
 * 功能：新建訂單
 * [POST]："/insert"
 * ex：/insert
 * ===========================
 * request: {
 *   orderNo: "A123",
 *   orderTitle: "ORDER 1",
 *   orderStatus: "SUCCESS"
 * }
 * ---------------------------
 * response: {
 *   msg: "訂單新增成功",
 *   status: "SUCCESS"
 * }
 * response: {
 *   err_msg: "錯誤的請求(400 BAD_REQUEST)",
 *   status: "400"
 * }
 * */
@Slf4j
@ExtendWith(MockitoExtension.class)
class InsertOrderServiceTest {
    @InjectMocks
    private InsertOrderService insertOrderService;
    @Mock
    private InsertOrderRepository insertOrderRepository;
    @Test
    void test_insert_order_should_be_successful_first() {
        String orderNo = "A123";
        String orderTitle = "ORDER 1";
        String orderStatus = "SUCCESS";

        InsertOrderRequest insertOrderRequest = new InsertOrderRequest();
        insertOrderRequest.setOrderNo(orderNo);
        insertOrderRequest.setOrderTitle(orderTitle);
        insertOrderRequest.setOrderStatus(orderStatus);

        InsertOrderEntity insertOrderEntity = new InsertOrderEntity();
        insertOrderEntity.setNo(orderNo);
        insertOrderEntity.setTitle(orderTitle);
        insertOrderEntity.setStatus(orderStatus);

        given(insertOrderRepository.save(insertOrderRequest)).willReturn(insertOrderEntity);

        // 預期：
        InsertOrderResponse expected = new InsertOrderResponse();
        expected.setMsg(orderNo + " 訂單新增成功");
        expected.setStatus(orderStatus);

        // 實際：
        InsertOrderResponse actual = insertOrderService.insertOrder(insertOrderRequest);

        // 比較：
        assertThat(actual).isEqualTo(expected);
        System.out.println("================actual=================" + actual);
        System.out.println("================expected=================" + expected);
    }
    @Test
    void test_insert_order_should_be_successful_second() {
        String orderNo = "B123";
        String orderTitle = "ORDER 2";
        String orderStatus = "SUCCESS";

        // Request：
        InsertOrderRequest insertOrderRequest = new InsertOrderRequest();
        insertOrderRequest.setOrderNo(orderNo);
        insertOrderRequest.setOrderTitle(orderTitle);
        insertOrderRequest.setOrderStatus(orderStatus);

        // Entity：
        InsertOrderEntity insertOrderEntity = new InsertOrderEntity();
        insertOrderEntity.setNo(insertOrderRequest.getOrderNo());
        insertOrderEntity.setTitle(insertOrderRequest.getOrderTitle());
        insertOrderEntity.setStatus(insertOrderRequest.getOrderStatus());

        given(insertOrderRepository.save(insertOrderRequest)).willReturn(insertOrderEntity);

        // 預期：
        InsertOrderResponse expected = new InsertOrderResponse();
        expected.setMsg(orderNo + " 訂單新增成功");
        expected.setStatus(orderStatus);

        // 實際：
        InsertOrderResponse actual = insertOrderService.insertOrder(insertOrderRequest);

        // 比較：
        assertThat(actual).isEqualTo(expected);
        System.out.println("================actual=================" + actual);
        System.out.println("================expected=================" + expected);
    }
    @Test
    void test_insert_order_should_be_successful_third() {
        String orderNo = "C123";
        String orderTitle = "ORDER 3";
        String orderStatus = "FAIL";

        // Request：
        InsertOrderRequest insertOrderRequest = new InsertOrderRequest();
        insertOrderRequest.setOrderNo(orderNo);
        insertOrderRequest.setOrderTitle(orderTitle);
        insertOrderRequest.setOrderStatus(orderStatus);

        // Entity：
        InsertOrderEntity insertOrderEntity = new InsertOrderEntity();
        insertOrderEntity.setNo(insertOrderRequest.getOrderNo());
        insertOrderEntity.setTitle(insertOrderRequest.getOrderTitle());
        insertOrderEntity.setStatus(insertOrderRequest.getOrderStatus());

        given(insertOrderRepository.save(insertOrderRequest)).willReturn(insertOrderEntity);

        // 預期：
        InsertOrderResponse expected = new InsertOrderResponse();
        expected.setMsg(orderNo + " 訂單新增成功");
        expected.setStatus(orderStatus);

        // 實際：
        InsertOrderResponse actual = insertOrderService.insertOrder(insertOrderRequest);

        // 比較：
        assertThat(actual).isEqualTo(expected);
        System.out.println("================actual=================" + actual);
        System.out.println("================expected=================" + expected);
    }
    @Test
    void test_insert_duplicate_order_conflict_exception() {
        String orderNo = "A123";
        String orderTitle = "ORDER 1";
        String orderStatus = "SUCCESS";

        // Request：
        InsertOrderRequest insertOrderRequest = new InsertOrderRequest();
        insertOrderRequest.setOrderNo(orderNo);
        insertOrderRequest.setOrderTitle(orderTitle);
        insertOrderRequest.setOrderStatus(orderStatus);

        // Entity：
        InsertOrderEntity insertOrderEntity = new InsertOrderEntity();
        insertOrderEntity.setNo(insertOrderRequest.getOrderNo());
        insertOrderEntity.setTitle(insertOrderRequest.getOrderTitle());
        insertOrderEntity.setStatus(insertOrderRequest.getOrderStatus());

        // given
        given(insertOrderRepository.existsByNoAndTitleAndStatus(anyString(), anyString(), anyString())).willReturn(true);

        // 斷言
        assertThrows(
            InsertOrderConflictException.class, () -> {
                if (insertOrderRepository.existsByNoAndTitleAndStatus(
                        insertOrderRequest.getOrderNo(),
                        insertOrderRequest.getOrderTitle(),
                        insertOrderRequest.getOrderStatus())
                ) {
                    InsertOrderConflictException insertOrderConflictException = new InsertOrderConflictException();
                    System.out.println("InsertOrderConflictException：" + insertOrderConflictException);
                    throw insertOrderConflictException;
                }
                insertOrderRepository.save(insertOrderEntity);
            }
        );
    }
}
