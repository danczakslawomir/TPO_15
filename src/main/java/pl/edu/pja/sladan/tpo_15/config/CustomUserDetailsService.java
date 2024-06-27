package pl.edu.pja.sladan.tpo_15.config;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.edu.pja.sladan.tpo_15.auth.UserService;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserService userService;

    public CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails ud =  userService.findUserCredentialsByEmail(username)
              .map(dto -> User.builder()
                      .username(dto.getEmail())
                      .password(dto.getPassword())
                      .roles(dto.getRoles().toArray(String[]::new))
                      .build())
              .orElseThrow(() -> new UsernameNotFoundException("User " + username + " not found"));
        System.out.println(ud);
        return ud;
    }
}
