package com.example.orderListTDD.DeleteOrder;

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
 * 使用 orderNo 刪除 order
 * [DELETE]："/delete/{orderNo}"
 * ex：/delete/A123
 * ===========================
 * 回傳 order 刪除訊息
 * response: {
 *   msg: "訂單刪除成功",
 *   status: "SUCCESS"
 * }
 * */
@WebMvcTest(DeleteOrderController.class)
public class DeleteOrderControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private DeleteOrderService deleteOrderService;
    @Test
    void test_delete_order_should_be_successful_first() throws Exception {
        String orderNo = "A123";

        DeleteOrderByOrderNoResponse deleteOrderByOrderNoResponse = new DeleteOrderByOrderNoResponse(orderNo + " 訂單刪除成功");

        given(deleteOrderService.deleteOrderByOrderNo(anyString()))
                .willReturn(deleteOrderByOrderNoResponse);

        mockMvc.perform(MockMvcRequestBuilders.delete("/delete/" + orderNo))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.msg", Is.is(orderNo + " 訂單刪除成功")));
    }
}
