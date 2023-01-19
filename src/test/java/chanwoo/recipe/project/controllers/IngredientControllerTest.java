package chanwoo.recipe.project.controllers;

import chanwoo.recipe.project.commands.RecipeCommand;
import chanwoo.recipe.project.domain.Ingredient;
import chanwoo.recipe.project.domain.Recipe;
import chanwoo.recipe.project.services.IngredientService;
import chanwoo.recipe.project.services.RecipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class IngredientControllerTest {

    private IngredientController ingredientController;

    @Mock
    private RecipeService recipeService;

    @Mock
    private IngredientService ingredientService;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        ingredientController = new IngredientController(recipeService, ingredientService);
        mockMvc = MockMvcBuilders.standaloneSetup(ingredientController).build();
    }

    @Test
    void listIngredients() throws Exception {
        RecipeCommand recipe = new RecipeCommand();
        recipe.setId(1L);

        when(recipeService.findCommandById(anyLong())).thenReturn(recipe);

        mockMvc.perform(get("/recipe/1/ingredients"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipe/ingredient/list"))
                .andExpect(model().attributeExists("recipe"));
    }

    @Test
    void showIngredient() throws Exception {
        Ingredient ingredient = new Ingredient();
        ingredient.setId(1L);

        when(ingredientService.findById(anyLong())).thenReturn(ingredient);

        mockMvc.perform(get("/recipe/1/ingredients/1/show"))
                .andExpect(view().name("recipe/ingredient/show"))
                .andExpect(model().attributeExists("ingredient"))
                .andExpect(status().isOk());
    }
}