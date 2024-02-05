package com.example.orderListTDD.EditOrder;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class EditOrderRepositoryTest {
    @Autowired
    private EditOrderRepository editOrderRepository;

    @Test
    @Sql(scripts = "classpath:dataOfEditOrder.sql")
    void test_edit_order_by_no_should_be_successful() {
        String no = "A123";
        String title = "ORDER 1";
        String status = "2";

        // Entity：
        EditOrderEntity expected = new EditOrderEntity();
        expected.setNo(no);
        expected.setTitle(title);
        expected.setStatus(status);

        EditOrderEntity actual = editOrderRepository.findByNo(no);
        System.out.println("================actual=================" + actual);
        System.out.println("================expected=================" + expected);

        assertThat(actual).isEqualTo(expected);
    }
}