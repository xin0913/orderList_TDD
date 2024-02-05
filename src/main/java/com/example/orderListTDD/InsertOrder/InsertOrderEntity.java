package com.example.orderListTDD.InsertOrder;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "ORDER_LIST")
public class InsertOrderEntity {

    @Id
    private String no;

    private String title;

    private String status;

}
