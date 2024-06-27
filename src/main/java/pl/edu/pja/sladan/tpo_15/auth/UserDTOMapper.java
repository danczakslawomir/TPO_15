package pl.edu.pja.sladan.tpo_15.auth;

import java.util.stream.Collectors;

public class UserDTOMapper {
    public static UserDTO map(User user) {
        return new UserDTO(
                user.getEmail(),
                user.getPassword(), 
                user.getRoles()
                        .stream()
                        .map(UserRole::getName)
                        .collect(Collectors.toSet())
        );
    }

}
