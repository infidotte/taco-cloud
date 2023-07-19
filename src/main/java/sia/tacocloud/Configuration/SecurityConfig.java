package sia.tacocloud.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity)
        throws Exception{
        return httpSecurity
                .authorizeHttpRequests((request) -> request
                        .requestMatchers("/design", "/orders")
                        .hasRole("USER")
                )
                .authorizeHttpRequests((request) -> request
                        .requestMatchers("/", "/**")
                        .permitAll()
                )
                .formLogin((form) -> form
                        .loginPage("/login"))
                .logout(logout -> logout
                        .logoutSuccessUrl("/"))
                .build();
    }
}
