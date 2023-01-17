package chanwoo.recipe.project.converters;

import chanwoo.recipe.project.commands.IngredientCommand;
import chanwoo.recipe.project.domain.Ingredient;
import chanwoo.recipe.project.domain.UnitOfMeasure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class IngredientToIngredientCommandTest {
    UnitOfMeasureToUnitOfMeasureCommand uomConverter;
    IngredientToIngredientCommand ingredientConverter;

    @BeforeEach
    void setUp() {
        uomConverter = new UnitOfMeasureToUnitOfMeasureCommand();
        ingredientConverter = new IngredientToIngredientCommand(uomConverter);
    }

    @Test
    void convert() {
        Ingredient ingredient = new Ingredient();
        ingredient.setId(1L);
        ingredient.setAmount(BigDecimal.ONE);
        UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setId(2L);
        ingredient.setUom(unitOfMeasure);

        IngredientCommand ingredientCommand = ingredientConverter.convert(ingredient);

        assertEquals(ingredient.getId(), ingredientCommand.getId());
        assertEquals(ingredient.getAmount(), ingredientCommand.getAmount());
        assertEquals(ingredient.getUom().getId(), ingredientCommand.getUom().getId());
    }
}