package com.example.orderListTDD.DeleteOrder;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeleteOrderRepository extends JpaRepository<DeleteOrderEntity, String> {
    boolean existsByNo(String no);
    void deleteByNo(String no);
}
