package com.example.orderListTDD;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface QueryOrderByNoRepository extends JpaRepository<QueryOrderByNoEntity, String> {
    QueryOrderByNoEntity findByNo(String orderNo);
}
