package sia.tacocloud.Entity.UDT;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;
import sia.tacocloud.Entity.Ingredient.Type;

@Data
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
@UserDefinedType("ingredient")
public class IngredientUDT {
    private final String name;
    private final Type type;
}
