package sia.tacocloud.Repository;

import org.springframework.data.repository.CrudRepository;
import sia.tacocloud.Entity.User;

public interface UserRepository
        extends CrudRepository<User, Long> {
    User findUserByUsername(String username);
}
