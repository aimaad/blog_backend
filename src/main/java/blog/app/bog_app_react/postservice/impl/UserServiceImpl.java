package blog.app.bog_app_react.postservice.impl;

import blog.app.bog_app_react.entities.Post;
import blog.app.bog_app_react.entities.User;
import blog.app.bog_app_react.postservice.UserService;
import blog.app.bog_app_react.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
