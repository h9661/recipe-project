package chanwoo.recipe.project.converters;

import chanwoo.recipe.project.commands.IngredientCommand;
import chanwoo.recipe.project.domain.Ingredient;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class IngredientCommandToIngredient implements Converter<IngredientCommand, Ingredient> {

    private final UnitOfMeasureCommandToUnitOfMeasure uomCommandToUomConverter;

    public IngredientCommandToIngredient(UnitOfMeasureCommandToUnitOfMeasure uomCommandToUomConverter) {
        this.uomCommandToUomConverter = uomCommandToUomConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public Ingredient convert(IngredientCommand source) {
        if(source == null)
            return null;

        final Ingredient ingredient = new Ingredient();

        ingredient.setId(source.getId());
        ingredient.setAmount(source.getAmount());
        ingredient.setDescription(source.getDescription());
        ingredient.setUom(uomCommandToUomConverter.convert(source.getUom()));

        return ingredient;
    }
}
