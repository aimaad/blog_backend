package blog.app.bog_app_react.controller;


import blog.app.bog_app_react.entities.Post;
import blog.app.bog_app_react.postservice.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("/posts")
    public List<Post> getAllPosts() {
        return postService.getPosts();
    }

    @GetMapping("/posts/{id}")
    public Post getPostById(@PathVariable Long id) {
        return postService.getPostById(id);
    }

    @PostMapping("/posts")
    public Post insertPost(@RequestBody Post post) {
        return postService.insertPost(post);
    }

    @PutMapping("/posts/{id}")
    public Post updatePost(@RequestBody Post post, @PathVariable Long id) {
        return postService.updatePost(post, id);
    }

    @DeleteMapping("/posts/{id}")
    public void deletePost(@PathVariable Long id) {
        postService.deletePost(id);
    }

    @GetMapping("/posts/search")
    List<Map<String,Object>> searchPosts(@RequestParam String q) {
        return postService.searchPosts(q);
    }
}
