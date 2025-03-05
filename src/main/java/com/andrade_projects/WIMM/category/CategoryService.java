package com.andrade_projects.WIMM.category;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<CategoryDTO> findAll() {
        List<Category> categories = repository.findAll();
        return categories.stream().map(CategoryDTO::new).toList();
    }

    public CategoryDTO findById(UUID id) {
        Category category = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Não foi encontrada nenhuma categoria com o ID: " + id));
        return new CategoryDTO(category);
    }

    public CategoryDTO insert(CategoryDTO obj) {
        Category category = new Category(obj.getId(), obj.getName());
        category =  repository.save(category);

        return new CategoryDTO(category);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }

    public CategoryDTO update(UUID id, CategoryDTO obj) {
        Category entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Não foi encontrada nenhuma categoria com o ID: " + id));
        updateData(entity, obj);
        entity = repository.save(entity);
        return new CategoryDTO(entity);
    }

    private void updateData(Category entity, CategoryDTO obj) {
        entity.setName(obj.getName());
    }


}
