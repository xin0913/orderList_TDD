package com.example.orderListTDD.QueryOrderByNo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class QueryOrderByNoService {

    private final QueryOrderByNoRepository queryOrderByNoRepository;

    public QueryOrderByNoResponse queryOrderTitleByOrderNo(String orderNo) {

        QueryOrderByNoEntity response = queryOrderByNoRepository.findByNo(orderNo);

        QueryOrderByNoResponse queryOrderByNoResponse = new QueryOrderByNoResponse();
        queryOrderByNoResponse.setOrderNo(response.getNo());
        queryOrderByNoResponse.setOrderTitle(response.getTitle());
        queryOrderByNoResponse.setOrderStatus(response.getStatus());

        return queryOrderByNoResponse;
    }
}
