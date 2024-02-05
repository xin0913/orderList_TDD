package com.example.orderListTDD.QueryOrderByNo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class QueryOrderByNoServiceTest {
    @InjectMocks
    private QueryOrderByNoService queryOrderByNoService;
    @Mock
    private QueryOrderByNoRepository queryOrderByNoRepository;
    @Test
    void test_query_order_title_by_order_no_should_be_successful_first() {
        String orderNo = "A123";
        String orderTitle = "ORDER 1";
        String orderStatus = "SUCCESS";

        // 設定 orderInfo(entity 為 Repository 的 return)
        QueryOrderByNoEntity queryOrderByNoEntity = new QueryOrderByNoEntity();
        queryOrderByNoEntity.setNo(orderNo);
        queryOrderByNoEntity.setTitle(orderTitle);
        queryOrderByNoEntity.setStatus(orderStatus);

        // 傳入 orderNo 回傳 orderInfo (用於 Service 內的 Repository)
        given(queryOrderByNoRepository.findByNo(anyString())).willReturn(queryOrderByNoEntity);

        // 預期：QueryOrderByNoResponse(orderNo=A123, orderTitle=ORDER 1, orderStatus=SUCCESS)
        QueryOrderByNoResponse expected = new QueryOrderByNoResponse();
        expected.setOrderNo(orderNo);
        expected.setOrderTitle(orderTitle);
        expected.setOrderStatus(orderStatus);

        // 實際：QueryOrderByNoResponse(orderNo=A123, orderTitle=ORDER 1, orderStatus=SUCCESS)
        QueryOrderByNoResponse actual = queryOrderByNoService.queryOrderTitleByOrderNo(orderNo);

        assertThat(actual).isEqualTo(expected);
    }
    @Test
    void test_query_order_title_by_order_no_should_be_successful_second() {
        String orderNo = "B123";
        String orderTitle = "ORDER 2";
        String orderStatus = "SUCCESS";

        // 設定 orderInfo(entity 為 Repository 的 return)
        QueryOrderByNoEntity queryOrderByNoEntity = new QueryOrderByNoEntity();
        queryOrderByNoEntity.setNo(orderNo);
        queryOrderByNoEntity.setTitle(orderTitle);
        queryOrderByNoEntity.setStatus(orderStatus);

        // 傳入 orderNo 回傳 orderInfo (用於 Service 內的 Repository)
        given(queryOrderByNoRepository.findByNo(anyString()))
                .willReturn(queryOrderByNoEntity);

        // 預期：QueryOrderByNoResponse(orderNo=B123, orderTitle=ORDER 2, orderStatus=SUCCESS)
        QueryOrderByNoResponse expected = new QueryOrderByNoResponse();
        expected.setOrderNo(orderNo);
        expected.setOrderTitle(orderTitle);
        expected.setOrderStatus(orderStatus);

        // 實際：QueryOrderByNoResponse(orderNo=B123, orderTitle=ORDER 2, orderStatus=SUCCESS)
        QueryOrderByNoResponse actual = queryOrderByNoService.queryOrderTitleByOrderNo(orderNo);

        assertThat(actual).isEqualTo(expected);
    }
    @Test
    void test_query_order_title_by_order_no_should_be_successful_third() {
        String orderNo = "C123";
        String orderTitle = "ORDER 3";
        String orderStatus = "FAIL";

        // 設定 orderInfo(entity 為 Repository 的 return)
        QueryOrderByNoEntity queryOrderByNoEntity = new QueryOrderByNoEntity();
        queryOrderByNoEntity.setNo(orderNo);
        queryOrderByNoEntity.setTitle(orderTitle);
        queryOrderByNoEntity.setStatus(orderStatus);

        // 傳入 orderNo 回傳 orderInfo (用於 Service 內的 Repository)
        given(queryOrderByNoRepository.findByNo(anyString())).willReturn(queryOrderByNoEntity);

        // 預期：QueryOrderByNoResponse(orderNo=C123, orderTitle=ORDER 3, orderStatus=FAIL)
        QueryOrderByNoResponse expected = new QueryOrderByNoResponse();
        expected.setOrderNo(orderNo);
        expected.setOrderTitle(orderTitle);
        expected.setOrderStatus(orderStatus);

        // 實際：QueryOrderByNoResponse(orderNo=C123, orderTitle=ORDER 3, orderStatus=FAIL)
        QueryOrderByNoResponse actual = queryOrderByNoService.queryOrderTitleByOrderNo(orderNo);

        assertThat(actual).isEqualTo(expected);
    }
}