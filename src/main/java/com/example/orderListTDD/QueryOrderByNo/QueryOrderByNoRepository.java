package com.example.orderListTDD.QueryOrderByNo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QueryOrderByNoRepository extends JpaRepository<QueryOrderByNoEntity, String> {
    QueryOrderByNoEntity findByNo(String orderNo);
}
