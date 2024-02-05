package com.example.orderListTDD.InsertOrder;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
 * */
@WebMvcTest(InsertOrderController.class)
public class InsertOrderControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private InsertOrderService insertOrderService;
    @Test
    void test_insert_order_should_be_successful() throws Exception {

        String orderNo = "A123";
        String orderTitle = "ORDER 1";
        String orderStatus = "SUCCESS";

        InsertOrderRequest insertOrderRequest = new InsertOrderRequest();
        insertOrderRequest.setOrderNo(orderNo);
        insertOrderRequest.setOrderTitle(orderTitle);
        insertOrderRequest.setOrderStatus(orderStatus);

        InsertOrderResponse insertOrderResponse = new InsertOrderResponse();
        insertOrderResponse.setMsg("訂單新增成功");
        insertOrderResponse.setStatus(orderStatus);

        given(insertOrderService.insertOrder(any())).willReturn(insertOrderResponse);

        mockMvc.perform(MockMvcRequestBuilders.post("/insert")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(new ObjectMapper().writeValueAsString(insertOrderRequest))
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.msg", Is.is("訂單新增成功")))
                .andExpect(jsonPath("$.status", Is.is(orderStatus)));
    }
    @Test
    void test_insert_order_should_be_successful_second() throws Exception {

        String orderNo = "B123";
        String orderTitle = "ORDER 2";
        String orderStatus = "SUCCESS";

        InsertOrderRequest insertOrderRequest = new InsertOrderRequest();
        insertOrderRequest.setOrderNo(orderNo);
        insertOrderRequest.setOrderTitle(orderTitle);
        insertOrderRequest.setOrderStatus(orderStatus);

        InsertOrderResponse insertOrderResponse = new InsertOrderResponse();
        insertOrderResponse.setMsg("訂單新增成功");
        insertOrderResponse.setStatus(orderStatus);

        given(insertOrderService.insertOrder(any())).willReturn(insertOrderResponse);

        mockMvc.perform(MockMvcRequestBuilders.post("/insert")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(new ObjectMapper().writeValueAsString(insertOrderRequest))
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.msg", Is.is("訂單新增成功")))
                .andExpect(jsonPath("$.status", Is.is(orderStatus)));
    }
    @Test
    void test_insert_order_should_be_successful_third() throws Exception {

        String orderNo = "C123";
        String orderTitle = "ORDER 3";
        String orderStatus = "FAIL";

        InsertOrderRequest insertOrderRequest = new InsertOrderRequest();
        insertOrderRequest.setOrderNo(orderNo);
        insertOrderRequest.setOrderTitle(orderTitle);
        insertOrderRequest.setOrderStatus(orderStatus);

        InsertOrderResponse insertOrderResponse = new InsertOrderResponse();
        insertOrderResponse.setMsg("訂單新增失敗");
        insertOrderResponse.setStatus(orderStatus);

        given(insertOrderService.insertOrder(any())).willReturn(insertOrderResponse);

        mockMvc.perform(MockMvcRequestBuilders.post("/insert")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(new ObjectMapper().writeValueAsString(insertOrderRequest))
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.msg", Is.is("訂單新增失敗")))
                .andExpect(jsonPath("$.status", Is.is(orderStatus)));
    }
    @Test
    void test_insert_order_bad_request_exception() throws Exception {
        // 模擬少給一個參數
        String orderNo = "A123";
        String orderTitle = "ORDER 1";

        InsertOrderRequest insertOrderRequest = new InsertOrderRequest();
        insertOrderRequest.setOrderNo(orderNo);
        insertOrderRequest.setOrderTitle(orderTitle);

        given(insertOrderService.insertOrder(insertOrderRequest)).willThrow(new InsertOrderBadRequestException());

        mockMvc.perform(MockMvcRequestBuilders.post("/insert")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(new ObjectMapper().writeValueAsString(insertOrderRequest))
                )
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.status", Is.is("400")))
                .andExpect(jsonPath("$.err_msg", Is.is("錯誤的請求(400 BAD_REQUEST)")));
    }
}