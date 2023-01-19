package chanwoo.recipe.project.services;

import chanwoo.recipe.project.domain.Ingredient;

public interface IngredientService {
    Ingredient findById(Long id);
}
