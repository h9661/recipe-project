package chanwoo.recipe.project.converters;

import chanwoo.recipe.project.commands.UnitOfMeasureCommand;
import chanwoo.recipe.project.domain.UnitOfMeasure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnitOfMeasureToUnitOfMeasureCommandTest {

    UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureConverter;

    @BeforeEach
    void setUp() {
        unitOfMeasureConverter = new UnitOfMeasureToUnitOfMeasureCommand();
    }

    @Test
    void convert() {
        UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setId(1L);

        UnitOfMeasureCommand unitOfMeasureCommand = unitOfMeasureConverter.convert(unitOfMeasure);

        assertEquals(unitOfMeasure.getId(), unitOfMeasureCommand.getId());
    }
}