package com.andrade_projects.WIMM.category;

import jakarta.validation.constraints.NotBlank;
import java.util.UUID;

public class CategoryDTO {

    private UUID id;
    @NotBlank(message = "Informe o nome da categoria.")
    private String name;

    public CategoryDTO() {
    }

    public CategoryDTO(Category category) {
        this.id = category.getId();
        this.name = category.getName();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
