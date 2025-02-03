package be.bstorm.demojakartaee.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_")
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode @ToString
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    @Getter @Setter
    private String username;

    @Column(nullable = false)
    @Getter @Setter
    private String password;

    @Getter @Setter
    @Column(nullable = false)
    private String role;

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }
}
