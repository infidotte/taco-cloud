package sia.tacocloud.Service;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import sia.tacocloud.Entity.User;
import sia.tacocloud.Repository.UserRepository;

public class UDService {
    @Bean
    public UserDetailsService userDetailsService(UserRepository repository){
        return username -> {
            User user = repository.findUserByUsername(username);
            if(user != null) return user;
            throw new UsernameNotFoundException("User ‘" + username + "’ not found");
        };
    }
}
