package blog.app.bog_app_react.loader;

import blog.app.bog_app_react.entities.Post;
import blog.app.bog_app_react.entities.User;
import blog.app.bog_app_react.repositories.PostRepository;
import blog.app.bog_app_react.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        String usersUrl = "https://jsonplaceholder.typicode.com/users";
        User[] users = restTemplate.getForObject(usersUrl, User[].class);
        if (users != null) {
            userRepository.saveAll(Arrays.asList(users));
        }

        String postsUrl = "https://jsonplaceholder.typicode.com/posts";
        Post[] posts = restTemplate.getForObject(postsUrl, Post[].class);
        if (posts != null) {
            for (Post post : posts) {
                User user = Arrays.stream(users)
                        .filter(u -> u.getId().equals(post.getUserId()))
                        .findFirst()
                        .orElse(null);
                post.setUser(user);
            }
            postRepository.saveAll(Arrays.asList(posts));
        }
    }
}
