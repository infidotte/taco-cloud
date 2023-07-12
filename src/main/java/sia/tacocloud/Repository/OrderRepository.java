package sia.tacocloud.Repository;

import org.springframework.data.repository.CrudRepository;
import sia.tacocloud.Entity.TacoOrder;

import java.util.List;

public interface OrderRepository
        extends CrudRepository<TacoOrder, String> {
}
