package com.example.orderListTDD.EditOrder;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditOrderRepository extends JpaRepository<EditOrderEntity, String> {
    EditOrderEntity findByNo(String no);
}
