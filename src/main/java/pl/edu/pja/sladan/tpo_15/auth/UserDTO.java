package pl.edu.pja.sladan.tpo_15.auth;

import java.util.Set;

public class UserDTO {

    private String email;
    private String password;
    private Set<String> roles;
    
    public UserDTO(String email, String password, Set<String> roles) {
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Set<String> getRoles() {
        return roles;
    }
}
