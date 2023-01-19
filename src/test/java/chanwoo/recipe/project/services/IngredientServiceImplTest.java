package chanwoo.recipe.project.services;

import chanwoo.recipe.project.domain.Ingredient;
import chanwoo.recipe.project.repository.IngredientRepository;
import org.json.JSONStringer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class IngredientServiceImplTest {

    @Mock
    IngredientService ingredientService;

    @Mock
    IngredientRepository ingredientRepository;

    Ingredient ingredient = new Ingredient();

    @BeforeEach
    void setUp() {
        ingredientService = new IngredientServiceImpl(ingredientRepository);
        ingredient.setId(1L);
    }

    @Test
    void findById() {
        when(ingredientRepository.findById(anyLong())).thenReturn(Optional.of(ingredient));

        assertEquals(ingredient, ingredientService.findById(anyLong()));
    }
}