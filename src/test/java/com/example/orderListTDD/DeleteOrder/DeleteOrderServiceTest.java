package com.example.orderListTDD.DeleteOrder;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class DeleteOrderServiceTest {
    @InjectMocks
    private DeleteOrderService deleteOrderService;
    @Mock
    private DeleteOrderRepository deleteOrderRepository;
    @Test
    void test_delete_order_should_be_successful() {
        String orderNo = "A123";

        // Entity：
        DeleteOrderEntity deleteOrderEntity = new DeleteOrderEntity();
        deleteOrderEntity.setNo(orderNo);

        given(deleteOrderRepository.existsByNo(anyString())).willReturn(true);

        // 預期：
        DeleteOrderByOrderNoResponse expected = new DeleteOrderByOrderNoResponse(orderNo + " 訂單刪除成功");

        // 實際：
        DeleteOrderByOrderNoResponse actual = deleteOrderService.deleteOrderByOrderNo(orderNo);

        // 比較：
        assertThat(actual).isEqualTo(expected);
        System.out.println("================actual=================" + actual);
        System.out.println("================expected=================" + expected);

        // Verify：
        verify(deleteOrderRepository, times(1)).existsByNo(orderNo);
        verify(deleteOrderRepository, times(1)).deleteByNo(orderNo);
    }
    @Test
    void test_delete_order_should_be_undefined() {
        String orderNo = "A123";

        // Entity：
        DeleteOrderEntity deleteOrderEntity = new DeleteOrderEntity();
        deleteOrderEntity.setNo(orderNo);

        given(deleteOrderRepository.existsByNo(anyString())).willReturn(false);

        // 預期：
        DeleteOrderByOrderNoResponse expected = new DeleteOrderByOrderNoResponse(orderNo + " 訂單不存在");

        // 實際：
        DeleteOrderByOrderNoResponse actual = deleteOrderService.deleteOrderByOrderNo(orderNo);

        // 比較：
        assertThat(actual).isEqualTo(expected);
        System.out.println("================actual=================" + actual);
        System.out.println("================expected=================" + expected);

        // Verify：
        verify(deleteOrderRepository, times(1)).existsByNo(orderNo);
        verify(deleteOrderRepository, times(0)).deleteByNo(orderNo);
    }
}
