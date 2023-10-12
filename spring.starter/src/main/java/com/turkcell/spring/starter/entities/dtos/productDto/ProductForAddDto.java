package com.turkcell.spring.starter.entities.dtos.productDto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
public class ProductForAddDto {

    @NotBlank(message = "{productNameShouldNotBeBlank}")
    private String productName;

    private short supplierId;

    private int categoryId;

    @PositiveOrZero(message = "{unitPriceShouldBePositive}")
    private double unitPrice;

    private short unitInStock;
}