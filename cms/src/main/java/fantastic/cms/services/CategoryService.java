package fantastic.cms.services;

import fantastic.cms.requests.CategoryRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import fantastic.cms.repositories.CategoryRepository;
import fantastic.cms.models.Category;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category update(Category category) {
        return this.categoryRepository.save(category);
    }

    public Category create(CategoryRequest request) {
        Category category = new Category();
        category.setName(request.getName());
        return this.categoryRepository.save(category);
    }

    public void delete(String id) {
        final Category category = this.categoryRepository.findOne(id);
        this.categoryRepository.delete(category);
    }

    public List<Category> findAll() {
        return this.categoryRepository.findAll();
    }

    public Category findOne(String id) {
        return this.categoryRepository.findOne(id);
    }
}
