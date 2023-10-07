package com.turkcell.spring.starter.entities.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryForUpdateDto {

    @NotNull()
    @Min(1)
    private int categoryId;

    @NotBlank(message = "Lütfen kategori adı giriniz.")
    private String categoryName;

    @NotBlank(message = "Lütfen açıklama giriniz.")
    private String description;
}
