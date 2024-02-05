package com.example.orderListTDD.InsertOrder;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
class InsertOrderRepositoryTest {
    @Autowired
    private InsertOrderRepository insertOrderRepository;
    @Test
    void test_insert_order_should_be_successful_first() {
        String orderNo = "A123";
        String orderTitle = "ORDER 1";
        String orderStatus = "SUCCESS";

        // Request：
        InsertOrderRequest insertOrderRequest = new InsertOrderRequest();
        insertOrderRequest.setOrderNo(orderNo);
        insertOrderRequest.setOrderTitle(orderTitle);
        insertOrderRequest.setOrderStatus(orderStatus);

        // 預期：
        InsertOrderEntity expected = new InsertOrderEntity();
        expected.setNo(orderNo);
        expected.setTitle(orderTitle);
        expected.setStatus(orderStatus);

        // Entity：
        InsertOrderEntity insertOrderEntity = new InsertOrderEntity();
        insertOrderEntity.setNo(insertOrderRequest.getOrderNo());
        insertOrderEntity.setTitle(insertOrderRequest.getOrderTitle());
        insertOrderEntity.setStatus(insertOrderRequest.getOrderStatus());

        // 實際：
        InsertOrderEntity actual = insertOrderRepository.save(insertOrderEntity);
        System.out.println("================actual=================" + actual);
        System.out.println("================expected=================" + expected);

        // 比較：
        assertThat(actual).isEqualTo(expected);
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

        // 預期：
        InsertOrderEntity expected = new InsertOrderEntity();
        expected.setNo(orderNo);
        expected.setTitle(orderTitle);
        expected.setStatus(orderStatus);

        // Entity：
        InsertOrderEntity insertOrderEntity = new InsertOrderEntity();
        insertOrderEntity.setNo(insertOrderRequest.getOrderNo());
        insertOrderEntity.setTitle(insertOrderRequest.getOrderTitle());
        insertOrderEntity.setStatus(insertOrderRequest.getOrderStatus());

        // 實際：
        InsertOrderEntity actual = insertOrderRepository.save(insertOrderEntity);
        System.out.println("================actual=================" + actual);
        System.out.println("================expected=================" + expected);

        // 比較：
        assertThat(actual).isEqualTo(expected);
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

        // 預期：
        InsertOrderEntity expected = new InsertOrderEntity();
        expected.setNo(orderNo);
        expected.setTitle(orderTitle);
        expected.setStatus(orderStatus);

        // Entity：
        InsertOrderEntity insertOrderEntity = new InsertOrderEntity();
        insertOrderEntity.setNo(insertOrderRequest.getOrderNo());
        insertOrderEntity.setTitle(insertOrderRequest.getOrderTitle());
        insertOrderEntity.setStatus(insertOrderRequest.getOrderStatus());

        // 實際：
        InsertOrderEntity actual = insertOrderRepository.save(insertOrderEntity);
        System.out.println("================actual=================" + actual);
        System.out.println("================expected=================" + expected);

        // 比較：
        assertThat(actual).isEqualTo(expected);
    }
}