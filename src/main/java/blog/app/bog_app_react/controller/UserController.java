package blog.app.bog_app_react.controller;

import blog.app.bog_app_react.entities.Post;
import blog.app.bog_app_react.entities.User;
import blog.app.bog_app_react.postservice.UserService;
import blog.app.bog_app_react.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/users")
    public List<User> getAllPosts() {
        return userService.getUsers();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
}
