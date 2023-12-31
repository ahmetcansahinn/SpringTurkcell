package com.turkcell.spring.starter.entities.dtos.orderDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderForListingDto {
    private int orderId;

    private LocalDate orderDate;

    private LocalDate requiredDate;

    private LocalDate shippedDate;

//    private short shipVia;
    private String freight;

}
