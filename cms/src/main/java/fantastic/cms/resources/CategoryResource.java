package fantastic.cms.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import fantastic.cms.models.Category;
import fantastic.cms.requests.CategoryRequest;

@RestController
@RequestMapping("/api/category")
public class CategoryResource {
    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findOne(@PathVariable("id") String id) {
        return ResponseEntity.ok(new Category());
    }

    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        return ResponseEntity.ok(Arrays.asList(new Category(), new Category()));
    }

    @PostMapping
    public ResponseEntity<Category> newCategory(CategoryRequest category) {
        return new ResponseEntity<>(new Category(), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeCategory(@PathVariable("id") String id) {

    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable("id") String id, CategoryRequest category) {
        return new ResponseEntity<>(new Category(), HttpStatus.OK);
    }
}
