package blog.app.bog_app_react.repositories;

import blog.app.bog_app_react.entities.Post;
import blog.app.bog_app_react.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
