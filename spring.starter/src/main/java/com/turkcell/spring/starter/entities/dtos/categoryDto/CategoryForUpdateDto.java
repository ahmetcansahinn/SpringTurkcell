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


    private int categoryId;

    @NotBlank(message = "{categoryNameShouldNotBeBlank}")
    @Size(min=3,max=10,  message="{categoryNameShouldBeMinimum}")
    private String categoryName;

    @NotBlank(message = "{descriptionShouldNotBeBlank}")
    private String description;
}
