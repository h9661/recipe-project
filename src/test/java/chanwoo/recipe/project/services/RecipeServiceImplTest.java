package chanwoo.recipe.project.services;

import chanwoo.recipe.project.domain.Recipe;
import chanwoo.recipe.project.repository.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RecipeServiceImplTest {

    @Mock
    RecipeRepository recipeRepository;

    RecipeServiceImpl recipeService;

    Recipe recipe = new Recipe();

    @BeforeEach
    void setUp() {
        recipeService = new RecipeServiceImpl(recipeRepository);
        recipe.setId(1L);

        recipeService.save(recipe);
    }

    @Test
    void getRecipes() {
        Set<Recipe> recipes = new HashSet<>();
        recipes.add(recipe);

        when(recipeService.getRecipes()).thenReturn(recipes);

        assertEquals(recipeService.getRecipes().size(), 1);
        verify(recipeRepository, times(1)).findAll();
        verify(recipeRepository, never()).findById(anyLong());
    }

    @Test
    void findById() {
        Optional<Recipe> recipeOptional = Optional.of(recipe);
        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

        Recipe retRecipe = recipeService.findById(1L);

        assertEquals(1L, retRecipe.getId());
        verify(recipeRepository, times(1)).findById(anyLong());
        verify(recipeRepository, never()).findAll();
    }
}