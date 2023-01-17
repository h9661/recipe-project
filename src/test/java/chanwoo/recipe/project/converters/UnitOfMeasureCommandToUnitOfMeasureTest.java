package chanwoo.recipe.project.converters;

import chanwoo.recipe.project.commands.UnitOfMeasureCommand;
import chanwoo.recipe.project.domain.UnitOfMeasure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnitOfMeasureCommandToUnitOfMeasureTest {

    UnitOfMeasureCommandToUnitOfMeasure unitOfMeasureCommandConverter;

    @BeforeEach
    void setUp() {
        unitOfMeasureCommandConverter = new UnitOfMeasureCommandToUnitOfMeasure();
    }

    @Test
    void convert() {
        UnitOfMeasureCommand unitOfMeasureCommand = new UnitOfMeasureCommand();
        unitOfMeasureCommand.setId(1L);

        UnitOfMeasure unitOfMeasure = unitOfMeasureCommandConverter.convert(unitOfMeasureCommand);

        assertEquals(unitOfMeasureCommand.getId(), unitOfMeasure.getId());
    }
}