package blog.app.bog_app_react.postservice;

import blog.app.bog_app_react.entities.Post;
import blog.app.bog_app_react.entities.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();


    User getUserById(Long id);
}
