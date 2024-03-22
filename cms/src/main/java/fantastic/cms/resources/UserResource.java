package fantastic.cms.resources;
import java.util.Arrays;
import java.util.List;

import fantastic.cms.requests.UserRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import fantastic.cms.models.User;
import fantastic.cms.requests.CategoryRequest;
@RestController
@RequestMapping("/api/user")
public class UserResource {

    @GetMapping(value = "/{id}")
    @Operation(summary = "Find user by id", description = "Find user by ID")
    @ApiResponse(responseCode = "404", description = "User not found")
    @ApiResponse(responseCode = "200", description = "User found")
    public ResponseEntity<User> findOne(@PathVariable("id") String id) {
        return ResponseEntity.ok(new User());
    }

    @GetMapping
    @Operation(summary = "List", description = "List all users")
    @ApiResponse(responseCode = "404", description = "Users not found")
    @ApiResponse(responseCode = "200", description = "Users found")
    public ResponseEntity<List<User>> findAll(@PathVariable("id") String id) {
        return ResponseEntity.ok(Arrays.asList(new User(), new User()));
    }

    @PostMapping
    @Operation(summary = "Create", description = "Create a new user")
    @ApiResponse(responseCode = "400", description = "invalid request")
    @ApiResponse(responseCode = "201", description = "User created successfully")
    public ResponseEntity<User> newUser(UserRequest user) {
        return new ResponseEntity<>(new User(), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete user by id", description = "Delete user by id")
    @ApiResponse(responseCode = "404", description = "User not found")
    @ApiResponse(responseCode = "200", description = "User deleted successfully")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeUser(@PathVariable("id") String id) {}

    @PutMapping("/{id}")
    @Operation(summary = "Update user by id", description = "Update user by id")
    @ApiResponse(responseCode = "400", description = "Invalid request")
    @ApiResponse(responseCode = "404", description = "User not found")
    @ApiResponse(responseCode = "200", description = "User deleted successfully")
    public ResponseEntity<User> updateUser(@PathVariable("id") String id, UserRequest user) {
        return new ResponseEntity<>(new User(), HttpStatus.OK);
    }
}


