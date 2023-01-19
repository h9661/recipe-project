package chanwoo.recipe.project.controllers;

import chanwoo.recipe.project.domain.Ingredient;
import chanwoo.recipe.project.repository.IngredientRepository;
import chanwoo.recipe.project.services.IngredientService;
import chanwoo.recipe.project.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class IngredientController {
    private final RecipeService recipeService;
    private final IngredientService ingredientRepository;

    public IngredientController(RecipeService recipeService, IngredientService ingredientRepository) {
        this.recipeService = recipeService;
        this.ingredientRepository = ingredientRepository;
    }

    @GetMapping
    @RequestMapping("/recipe/{id}/ingredients")
    public String listIngredients(@PathVariable String id, Model model){
        model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(id)));

        return "recipe/ingredient/list";
    }

    @GetMapping
    @RequestMapping("/recipe/{recipeId}/ingredients/{ingredientId}/show")
    public String showIngredient(@PathVariable String ingredientId, Model model){
        model.addAttribute("ingredient", ingredientRepository.findById(Long.valueOf(ingredientId)));

        return "recipe/ingredient/show";
    }
}