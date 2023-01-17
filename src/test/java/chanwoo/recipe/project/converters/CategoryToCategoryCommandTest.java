package chanwoo.recipe.project.converters;

import chanwoo.recipe.project.commands.CategoryCommand;
import chanwoo.recipe.project.domain.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryToCategoryCommandTest {

    CategoryToCategoryCommand categoryConverter;

    @BeforeEach
    void setUp() {
        categoryConverter = new CategoryToCategoryCommand();
    }

    @Test
    void convert() {
        Category category = new Category();
        category.setId(1L);

        CategoryCommand categoryCommand = categoryConverter.convert(category);

        assertEquals(category.getId(), categoryCommand.getId());
    }
}