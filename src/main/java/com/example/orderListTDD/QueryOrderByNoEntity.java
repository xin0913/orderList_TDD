package com.example.orderListTDD;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "ORDER_LIST")
public class QueryOrderByNoEntity {

    @Id
    private String no;

    private String title;

    private String status;
}
