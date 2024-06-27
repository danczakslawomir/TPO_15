package pl.edu.pja.sladan.tpo_15.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(request -> request
                .requestMatchers("/").permitAll()
//                .requestMatchers("/images/background.png", "/images/Logo.png").permitAll()
                .requestMatchers("/register", "/confirm").permitAll()
                .requestMatchers("/userPage").hasAnyRole("USER", "ADMIN")
                .requestMatchers("/adminPage/**").hasAnyRole("ADMIN")
                .anyRequest().authenticated());
        http.formLogin(login -> login.loginPage("/login").permitAll());
//        http.csrf(csrf -> csrf.disable());

        http.logout(logout -> logout.logoutRequestMatcher(new AntPathRequestMatcher("/logout/**", HttpMethod.GET.name()))
                .logoutSuccessUrl("/"));

        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer(){
        return web -> web.ignoring().requestMatchers("/images/background.png", "/images/Logo.png");
    }

}
