package blog.app.bog_app_react.postservice;


import blog.app.bog_app_react.entities.Post;
import java.util.List;
import java.util.Map;

public interface PostService {
    List<Post> getPosts();
    Post getPostById(Long id);
    Post insertPost(Post post);
    Post updatePost(Post post, Long id);
    void deletePost(Long id);
    List<Map<String,Object>> searchPosts(String query);

}
