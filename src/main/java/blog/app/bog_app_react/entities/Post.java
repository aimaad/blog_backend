package blog.app.bog_app_react.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Post {
    // Getters and setters
    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Getter
    @Setter
    @Column(name = "user_id")
    private Long userId;

    @Getter
    @Setter
    @ManyToOne(fetch =  FetchType.EAGER)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    @Getter
    @Setter
    private String title;
    @Setter
    @Getter
    private String body;



}
