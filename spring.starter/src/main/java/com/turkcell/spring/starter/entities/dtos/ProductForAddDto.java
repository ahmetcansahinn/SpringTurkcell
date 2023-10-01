package com.turkcell.spring.starter.entities.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductForAddDto {

    @NotBlank(message = "İsim girmek zorunludur.")
    private String productName;
    private String quantityPerUnit;

    @Positive(message = "Ürün fiyatı 0'dan büyük olmalıdır.")
    private double unitPrice;
    private Short unitInStock;
    private Short unitOnOrder;
    private int categoryId;
    private int reOrderLevel;
    private short supplierId;

}
