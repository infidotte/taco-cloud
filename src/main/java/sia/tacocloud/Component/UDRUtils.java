package sia.tacocloud.Component;

import sia.tacocloud.Entity.Ingredient;
import sia.tacocloud.Entity.Taco;
import sia.tacocloud.Entity.UDT.IngredientUDT;
import sia.tacocloud.Entity.UDT.TacoUDT;

public class UDRUtils {
    public static IngredientUDT toIngredientUDT(Ingredient ingredient) {
        return new IngredientUDT(ingredient.getName(), ingredient.getType());
    }

    public static TacoUDT toTacoUDT(Taco taco) {
        return new TacoUDT(taco.getName(), taco.getIngredients());
    }
}
