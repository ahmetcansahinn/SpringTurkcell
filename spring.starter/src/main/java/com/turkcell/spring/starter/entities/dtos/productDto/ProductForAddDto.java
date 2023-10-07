package com.turkcell.spring.starter.entities.dtos.productDto;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductForAddDto {
//    private int productId;

    @NotBlank(message = "İsim girmek zorunludur.")
    private String productName;

    private String quantityPerUnit;
//
    @PositiveOrZero(message = "Ürün fiyatı 0'dan büyük olmalıdır.")

    private double unitPrice;

    @Positive(message = "Ürün stok bilgisi pozitif bir değer almalıdır.")
    private Short unitInStock;

    private Short unitOnOrder;
//
//    @NotEmpty(message = "category id boş bırakılamaz")
//    @Positive(message = "Lütfen pozitif bir değer giriniz.")
    @NotNull
    @Min(1)
    private int categoryId;

    private int reOrderLevel;

//    @NotEmpty(message = "supplier id boş bırakılamaz")
//    @Positive(message = "Lütfen pozitif bir değer giriniz.")
    @NotNull
    @Min(1)
    private short supplierId;

}
