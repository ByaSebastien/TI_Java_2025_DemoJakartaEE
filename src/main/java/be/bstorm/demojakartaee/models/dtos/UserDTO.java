package be.bstorm.demojakartaee.models.dtos;

import be.bstorm.demojakartaee.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class UserDTO {

    private Long id;
    private String username;
    private String role;

    public static UserDTO fromUser(User user) {
        return new UserDTO(user.getId(), user.getUsername(), user.getRole());
    }
}
