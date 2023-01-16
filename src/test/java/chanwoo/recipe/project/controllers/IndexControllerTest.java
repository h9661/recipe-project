package chanwoo.recipe.project.controllers;

import chanwoo.recipe.project.domain.Recipe;
import chanwoo.recipe.project.repository.RecipeRepository;
import chanwoo.recipe.project.services.RecipeService;
import org.h2.index.Index;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@ExtendWith(MockitoExtension.class)
class IndexControllerTest {

    IndexController indexController;

    @Mock
    RecipeService recipeService;

    @BeforeEach
    void setUp() {
        indexController = new IndexController(recipeService);
    }

    @Test
    void getIndexPage() throws Exception {
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        Set<Recipe> recipes = new HashSet<>();
        recipes.add(recipe);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();

        when(recipeService.getRecipes()).thenReturn(recipes);

        assertEquals(1, recipeService.getRecipes().size());

        mockMvc.perform(get("/"))
                .andExpect(view().name("index"))
                .andExpect(status().isOk());
    }
}