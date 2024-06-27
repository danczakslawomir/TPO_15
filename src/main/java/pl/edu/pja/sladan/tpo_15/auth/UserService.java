package pl.edu.pja.sladan.tpo_15.auth;

import jakarta.transaction.Transactional;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;

    public UserService(UserRepository userRepository, UserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
    }

    public Optional<UserDTO> findUserCredentialsByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(UserDTOMapper::map);
    }

    public List<String> findAllUserEmails(){
        return userRepository.findAllUsersByRoles_Name("USER")
                .stream().map(User::getEmail).toList();
    }

    @Transactional
    public void deleteUser(String email){
        if (isAdmin() && !isAdminAccount(email))
            userRepository.deleteByEmail(email);
    }

    private boolean isAdmin(){
        return SecurityContextHolder.getContext()
                .getAuthentication().getAuthorities().stream()
                .anyMatch(authority -> authority.getAuthority().equals("ROLE_ADMIN"));
    }

    private boolean isAdminAccount(String email){
        return SecurityContextHolder.getContext()
                .getAuthentication().getName() == email;
    }

    @Transactional
    public void register(UserRegisterDTO userRegisterDTO){
        User user = new User();
        user.setFirstName(userRegisterDTO.getFirstName());
        user.setLastName(userRegisterDTO.getLastName());
        user.setEmail(userRegisterDTO.getEmail());
        user.setPassword(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode(userRegisterDTO.getPassword()));

        userRoleRepository.findByName("USER").ifPresentOrElse(
                role -> user.getRoles().add(role),
                NoSuchElementException::new
        );

        userRepository.save(user);
    }

}
