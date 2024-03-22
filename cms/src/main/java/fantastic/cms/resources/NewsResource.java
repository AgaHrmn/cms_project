package fantastic.cms.resources;

import java.util.Arrays;
import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import fantastic.cms.models.News;
import fantastic.cms.requests.NewsRequest;
import fantastic.cms.models.Review;

import java.util.List;

@RestController
@RequestMapping("/api/news")
@Tag(name="news", description = "News API")
public class NewsResource {

    @GetMapping(value = "/{id}")
    @Operation(summary = "Find", description = "Find the Category by ID")
    @ApiResponse(responseCode = "404", description = "News not found")
    @ApiResponse(responseCode = "200", description = "News found")
    public ResponseEntity<News> findOne(@PathVariable("id") String id) {
        return ResponseEntity.ok(new News());
    }

    @GetMapping
    @Operation(summary = "Find", description = "List all news")
    @ApiResponse(responseCode = "404", description = "News not found")
    @ApiResponse(responseCode = "200", description = "All news found")
    public ResponseEntity<List<News>> findAll() {
        return ResponseEntity.ok(Arrays.asList(new News(), new News()));
    }

    @PostMapping
    @Operation(summary = "Create", description = "Create new news")
    @ApiResponse(responseCode = "400", description = "Invalid request")
    @ApiResponse(responseCode = "201", description = "News created successfully")
    public ResponseEntity<News> newNews(NewsRequest news) {
        return new ResponseEntity<>(new News(), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete", description = "Delete news")
    @ApiResponse(responseCode = "404", description = "News not found")
    @ApiResponse(responseCode = "200", description = "News deleted successfully")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeNews(@PathVariable("id") String id) {}

    @PutMapping("/{id}")
    @Operation(summary = "Delete", description = "Update news")
    @ApiResponse(responseCode = "400", description = "Invalid request")
    @ApiResponse(responseCode = "404", description = "News not found")
    @ApiResponse(responseCode = "200", description = "News updated successfully")
    public ResponseEntity<News> updateNews(@PathVariable("id") String id, NewsRequest news) {
        return new ResponseEntity<>(new News(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}/review/{userId}")
    @Operation(summary = "Reviewed", description = "Add a review to news")
    @ApiResponse(responseCode = "200", description = "Review added successfully")
    @ApiResponse(responseCode = "400", description = "Invalid request")
    @ApiResponse(responseCode = "404", description = "News not found")
    public ResponseEntity<Review> addReview(@PathVariable("id") String id,
                                         @PathVariable("userId") String userId) {
        if (id == null || id.isEmpty() || userId == null || userId.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(new Review());
    }

    @GetMapping(value = "/revised")
    @Operation(summary = "Find revised news", description = "Find revised news")
    @ApiResponse(responseCode = "400", description = "Invalid request")
    @ApiResponse(responseCode = "404", description = "Reviewed news not found")
    @ApiResponse(responseCode = "200", description = "Reviewed news found")
    public ResponseEntity<List<News>> revisedNews() {
        return ResponseEntity.ok(Arrays.asList(new News(), new News()));
    }
}
