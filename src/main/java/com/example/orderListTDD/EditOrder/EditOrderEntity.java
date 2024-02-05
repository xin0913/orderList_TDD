package com.example.orderListTDD.EditOrder;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "ORDER_LIST")
public class EditOrderEntity {

    @Id
    private String no;

    private String title;

    private String status;

}
