package com.example.orderListTDD;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
class QueryOrderByNoRepositoryTest {

    @Autowired
    private QueryOrderByNoRepository queryOrderByNoRepository;

    @Test
    @Sql(scripts = "classpath:data.sql")
    void test_query_order_by_no_should_be_successful() {
        String orderNo = "A123";
        String orderTitle = "ORDER 1";
        String orderStatus = "SUCCESS";

        QueryOrderByNoEntity expected = new QueryOrderByNoEntity();
        expected.setNo(orderNo);
        expected.setTitle(orderTitle);
        expected.setStatus(orderStatus);

        QueryOrderByNoEntity actual = queryOrderByNoRepository.findByNo(orderNo);

//        System.out.println("=================actual====================" + actual);
        assertThat(actual).isEqualTo(expected);
    }
}