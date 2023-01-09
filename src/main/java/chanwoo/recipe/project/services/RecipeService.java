package chanwoo.recipe.project.services;

import chanwoo.recipe.project.domain.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();
}
