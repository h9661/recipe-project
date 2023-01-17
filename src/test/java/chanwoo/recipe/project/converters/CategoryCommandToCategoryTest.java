package chanwoo.recipe.project.converters;

import chanwoo.recipe.project.commands.CategoryCommand;
import chanwoo.recipe.project.domain.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

class CategoryCommandToCategoryTest {

    CategoryCommandToCategory categoryCommandConverter;

    @BeforeEach
    void setUp() {
        categoryCommandConverter = new CategoryCommandToCategory();
    }

    @Test
    void convert() {
        CategoryCommand categoryCommand = new CategoryCommand();
        categoryCommand.setId(1L);

        Category category = categoryCommandConverter.convert(categoryCommand);

        assertEquals(categoryCommand.getId(), category.getId());
    }
}