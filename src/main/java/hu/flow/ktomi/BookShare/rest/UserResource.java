package hu.flow.ktomi.BookShare.rest;

import hu.flow.ktomi.BookShare.persistence.model.User;
import hu.flow.ktomi.BookShare.persistence.repository.UserRepository;
import hu.flow.ktomi.BookShare.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class UserResource {

    private final UserService userService;

    @GetMapping("/users")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/user/{id}")
    public User findOne(@PathVariable Long id) {
        return userService.findOne(id);
    }

    @PostMapping("/user")
    public User create(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PutMapping("/user")
    public User update(@RequestBody User user) {
        return userService.addUser(user);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Void> create(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.ok().build();
    }
}
