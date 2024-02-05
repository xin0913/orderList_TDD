package com.example.orderListTDD.DeleteOrder;

import com.example.orderListTDD.InsertOrder.InsertOrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
class DeleteOrderRepositoryTest {
    @Autowired
    private DeleteOrderRepository deleteOrderRepository;

    @Test
    @Sql(scripts = "classpath:data.sql")
    void test_delete_order_should_be_successful() {
        String orderNo = "A123";

        deleteOrderRepository.deleteByNo(orderNo);

        // 斷言刪除後找不到對應的orderNo
        assertFalse(deleteOrderRepository.existsByNo(orderNo));

    }
}