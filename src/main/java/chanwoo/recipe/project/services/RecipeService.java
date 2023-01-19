package chanwoo.recipe.project.services;

import chanwoo.recipe.project.commands.RecipeCommand;
import chanwoo.recipe.project.domain.Recipe;

import java.util.Optional;
import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();

    Recipe save(Recipe recipe);

    Recipe findById(Long Id);

    RecipeCommand findCommandById(Long Id);

    void deleteById(Long Id);

    RecipeCommand saveRecipeCommand(RecipeCommand recipeCommand);
}
