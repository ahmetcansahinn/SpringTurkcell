package com.turkcell.spring.starter.entities.dtos.orderDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderForGetById {

//    @NotBlank(message = "customer id boş bırakılamaz.")

//    private String customerId;

//    @NotBlank(message = "Employe id boş bırakılamaz.")
//    private short employeeId;
    private int orderId;
    private LocalDate orderDate;
    private LocalDate requiredDate;
    private LocalDate shippedDate;
    private short shipVia;
    private String freight;

}
