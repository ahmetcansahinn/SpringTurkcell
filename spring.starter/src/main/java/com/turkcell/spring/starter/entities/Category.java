package com.turkcell.spring.starter.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="categories")
@Entity
@Builder
public class Category {
    @Id
    @GeneratedValue
    @Column(name="category_id")
    private int categoryId;

    @Column(name="category_name")
    private String categoryName;

    @Column(name="description")
    private String description;
//

    @OneToMany( mappedBy = "categories", cascade = CascadeType.MERGE)
    private List<Product> products;//bir category birsürü producta sahip


}
