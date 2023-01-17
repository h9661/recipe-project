package chanwoo.recipe.project.converters;

import chanwoo.recipe.project.commands.IngredientCommand;
import chanwoo.recipe.project.commands.UnitOfMeasureCommand;
import chanwoo.recipe.project.domain.Ingredient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class IngredientCommandToIngredientTest {

    UnitOfMeasureCommandToUnitOfMeasure uomCommandConverter;
    IngredientCommandToIngredient ingredientCommandConverter;

    @BeforeEach
    void setUp() {
        uomCommandConverter = new UnitOfMeasureCommandToUnitOfMeasure();
        ingredientCommandConverter = new IngredientCommandToIngredient(uomCommandConverter);
    }

    @Test
    void convert() {
        IngredientCommand ingredientCommand = new IngredientCommand();
        ingredientCommand.setId(1L);
        ingredientCommand.setAmount(new BigDecimal(1));
        UnitOfMeasureCommand unitOfMeasureCommand = new UnitOfMeasureCommand();
        unitOfMeasureCommand.setId(1L);
        ingredientCommand.setUom(unitOfMeasureCommand);

        Ingredient ingredient = ingredientCommandConverter.convert(ingredientCommand);

        assertEquals(ingredient.getId(), ingredientCommand.getId());
        assertEquals(ingredient.getAmount(), ingredientCommand.getAmount());
        assertEquals(ingredient.getUom().getId(), ingredientCommand.getUom().getId());
    }
}