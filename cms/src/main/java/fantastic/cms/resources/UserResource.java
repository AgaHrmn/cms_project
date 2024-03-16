package fantastic.cms.resources;
import java.util.Arrays;
import java.util.List;

import fantastic.cms.requests.UserRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import fantastic.cms.models.User;
import fantastic.cms.requests.CategoryRequest;
@RestController
@RequestMapping("/api/user")
public class UserResource {

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findOne(@PathVariable("id") String id) {
        return ResponseEntity.ok(new User());
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll(@PathVariable("id") String id) {
        return ResponseEntity.ok(Arrays.asList(new User(), new User()));
    }

    @PostMapping
    public ResponseEntity<User> newUser(UserRequest user) {
        return new ResponseEntity<>(new User(), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeUser(@PathVariable("id") String id) {}

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") String id, UserRequest user) {
        return new ResponseEntity<>(new User(), HttpStatus.OK);
    }
}


