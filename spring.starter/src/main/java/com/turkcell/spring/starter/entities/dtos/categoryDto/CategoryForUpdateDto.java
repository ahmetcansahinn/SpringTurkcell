package com.turkcell.spring.starter.entities.dtos.categoryDto;

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
    private int id;

    @NotBlank(message = "Kategori adı girmek zorunludur.")
    @Size(min=5,message = "{categoryNameShouldBeMinimum}")
    private String categoryName;

    @NotBlank(message = "Açıklama alanı zorunludur.")
    private String description;
}
