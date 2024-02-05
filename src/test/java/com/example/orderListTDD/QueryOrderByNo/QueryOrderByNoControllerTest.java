package com.example.orderListTDD.QueryOrderByNo;

import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/*
 * 使用 orderNo 查詢 orderInfo
 * [GET]："/query/{orderNo}"
 * ex：/query/A123
 * ===========================
 * 回傳 orderInfo
 * response: {
 *   orderNo: "A123"
 *   orderTitle: "ORDER 1"
 *   orderStatus: "SUCCESS"
 * }
 * */

@WebMvcTest(QueryOrderByNoController.class)
class QueryOrderByNoControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private QueryOrderByNoService queryOrderByNoService;
    @Test
    void test_query_order_by_no_should_be_successful() throws Exception {
        String orderNo = "A123";
        String orderTitle = "ORDER 1";
        String orderStatus = "SUCCESS";

        QueryOrderByNoResponse queryOrderByNoResponse = new QueryOrderByNoResponse();
        queryOrderByNoResponse.setOrderNo(orderNo);
        queryOrderByNoResponse.setOrderTitle(orderTitle);
        queryOrderByNoResponse.setOrderStatus(orderStatus);

        given(queryOrderByNoService.queryOrderTitleByOrderNo(anyString()))
                .willReturn(queryOrderByNoResponse);

        mockMvc.perform(MockMvcRequestBuilders.get("/query/" + orderNo))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.orderNo", Is.is(orderNo)))
                .andExpect(jsonPath("$.orderTitle", Is.is(orderTitle)))
                .andExpect(jsonPath("$.orderStatus", Is.is(orderStatus)));
    }
    @Test
    void test_query_order_by_no_should_be_successful_second() throws Exception {
        String orderNo = "B123";
        String orderTitle = "ORDER 2";
        String orderStatus = "SUCCESS";

        QueryOrderByNoResponse queryOrderByNoResponse = new QueryOrderByNoResponse();
        queryOrderByNoResponse.setOrderNo(orderNo);
        queryOrderByNoResponse.setOrderTitle(orderTitle);
        queryOrderByNoResponse.setOrderStatus(orderStatus);

        given(queryOrderByNoService.queryOrderTitleByOrderNo(anyString()))
                .willReturn(queryOrderByNoResponse);

        mockMvc.perform(MockMvcRequestBuilders.get("/query/" + orderNo))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.orderNo", Is.is(orderNo)))
                .andExpect(jsonPath("$.orderTitle", Is.is(orderTitle)))
                .andExpect(jsonPath("$.orderStatus", Is.is(orderStatus)));
    }
    @Test
    void test_query_order_by_no_should_be_successful_third() throws Exception {
        String orderNo = "C123";
        String orderTitle = "ORDER 3";
        String orderStatus = "FAIL";

        QueryOrderByNoResponse queryOrderByNoResponse = new QueryOrderByNoResponse();
        queryOrderByNoResponse.setOrderNo(orderNo);
        queryOrderByNoResponse.setOrderTitle(orderTitle);
        queryOrderByNoResponse.setOrderStatus(orderStatus);

        given(queryOrderByNoService.queryOrderTitleByOrderNo(anyString()))
                .willReturn(queryOrderByNoResponse);

        mockMvc.perform(MockMvcRequestBuilders.get("/query/" + orderNo))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.orderNo", Is.is(orderNo)))
                .andExpect(jsonPath("$.orderTitle", Is.is(orderTitle)))
                .andExpect(jsonPath("$.orderStatus", Is.is(orderStatus)));
    }
    @Test
    void test_query_order_by_no_not_found_exception() throws Exception {
        String orderNo = "A456";

        given(queryOrderByNoService.queryOrderTitleByOrderNo(anyString()))
                .willThrow(new QueryOrderByNoNotFoundException());

        mockMvc.perform(MockMvcRequestBuilders.get("/query/" + orderNo))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.status", Is.is("404")))
                .andExpect(jsonPath("$.err_msg", Is.is("查無訂單(404 NOT_FOUND)")));
    }
}
