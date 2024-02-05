package com.example.orderListTDD.EditOrder;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
@WebMvcTest(controllers = EditOrderController.class)
public class EditOrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EditOrderService editOrderService;

    @Test
    void test_edit_order_by_no_should_be_successful() throws Exception {
        String no = "A123";
        String title = "ORDER 2";
        String status = "2";

        EditOrderRequest editOrderRequest = new EditOrderRequest();
        editOrderRequest.setTitle(title);
        editOrderRequest.setStatus(status);

        EditOrderResponse editOrderResponse = new EditOrderResponse();
        editOrderResponse.setMsg("訂單修改成功");
        editOrderResponse.setResCode("000");

        given(editOrderService.editOrderByNo(editOrderRequest, no))
                .willReturn(editOrderResponse);

        mockMvc.perform(MockMvcRequestBuilders.put("/edit/" + no)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(new ObjectMapper().writeValueAsString(editOrderRequest))
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.msg", Is.is("訂單修改成功")))
                .andExpect(jsonPath("$.resCode", Is.is("000")));
    }
}
