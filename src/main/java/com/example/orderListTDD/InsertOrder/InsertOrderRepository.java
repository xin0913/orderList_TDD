package com.example.orderListTDD.InsertOrder;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface InsertOrderRepository extends JpaRepository<InsertOrderEntity, String> {

    InsertOrderEntity save(InsertOrderRequest request);

    boolean existsByNoAndTitleAndStatus(String no, String title, String status);
}
