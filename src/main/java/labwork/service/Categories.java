package labwork.service;

import labwork.structure.Category;
import labwork.service.errorHandler.CategoryNotFound;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class Categories {

    private Map<UUID, Category> categoryMap = new HashMap<>();

    public Category addCategory(Category category) {
        Category newCategory = Category.builder()
                .id(UUID.randomUUID())
                .categoryName(category.getCategoryName())
                .build();
        categoryMap.put(newCategory.getId(), newCategory);
        return newCategory;
    }
    
    public List<Category> getCategories() {
        return List.copyOf(categoryMap.values());
    }

    public Category getCategoryId(UUID id) {
        Category category = categoryMap.get(id);
        if (category == null) {
            throw new CategoryNotFound(id);
        }
        return category;
    }

    public void deleteCategory(UUID id) {
        Category category = getCategoryId(id);
        categoryMap.remove(category.getId());
    }

}