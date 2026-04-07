package com.example.orderService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public  class Order implements Serializable {

    String id;
    String item ;
    int orderPrice;


}