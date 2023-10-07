package com.turkcell.spring.starter.entities.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderForAddDto {

//    @NotBlank(message = "customer id boş bırakılamaz.")
//    private String customerId;
//
//    @NotEmpty(message = "Employee id boş bırakılamaz.")
//    private short employeeId;

    private int orderId;

    @NotBlank(message = "Tarih kısmı boş bırakılamaz")
    private LocalDate orderDate;

    private LocalDate requiredDate;

    private LocalDate shippedDate;

    @Positive(message = "Lütfen sıfırdan büyük bir sayı giriniz.")
    private short shipVia;

    private String freight;
}
