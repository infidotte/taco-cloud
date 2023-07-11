package sia.tacocloud.Entity;

import com.datastax.oss.driver.api.core.uuid.Uuids;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;
import sia.tacocloud.Component.UDRUtils;
import sia.tacocloud.Entity.UDT.IngredientUDT;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Table
public class Taco {
    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    private UUID id = Uuids.timeBased();

    @NotNull
    @Size(min = 5, message = "Name must be at least 5 chars long")
    private String name;

    @PrimaryKeyColumn(type = PrimaryKeyType.CLUSTERED, ordering = Ordering.DESCENDING)
    private Date createdAt = new Date();

    @NotNull
    @Size(min = 1, message = "You must choose at least 1 ingredient")
    @Column("ingredients")
    private List<IngredientUDT> ingredients = new ArrayList<>();
    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(UDRUtils.toIngredientUDT(ingredient));
    }
}
