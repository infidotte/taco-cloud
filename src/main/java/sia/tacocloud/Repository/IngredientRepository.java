package sia.tacocloud.Repository;

import sia.tacocloud.Entity.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository
        extends CrudRepository<Ingredient, String>{
}
