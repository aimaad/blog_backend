package blog.app.bog_app_react.postservice.impl;


import blog.app.bog_app_react.entities.Post;
import blog.app.bog_app_react.postservice.PostService;
import blog.app.bog_app_react.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post getPostById(Long id) {
        return postRepository.findById(id).orElse(null);
    }

    @Override
    public Post insertPost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post updatePost(Post post, Long id) {
        Post existingPost = postRepository.findById(id).orElse(null);
        if (existingPost != null) {
            existingPost.setTitle(post.getTitle());
            existingPost.setBody(post.getBody());
            return postRepository.save(existingPost);
        } else {
            return null;
        }
    }

    @Override
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
    public List<Map<String, Object>> searchPosts(String query) {
        return postRepository.findByTitleContaining(query).stream()
                .map(this::convertPostToMap)
                .collect(Collectors.toList());
    }

    private Map<String, Object> convertPostToMap(Post post) {
        if (post == null) {
            return null;
        }
        return Map.of(
                "id", post.getId(),
                    "userId",post.getUser().getId(),
                "title", post.getTitle(),
                "body", post.getBody()
        );
    }
}
