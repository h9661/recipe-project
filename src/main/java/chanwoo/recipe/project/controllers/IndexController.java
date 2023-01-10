package chanwoo.recipe.project.controllers;

import chanwoo.recipe.project.domain.Category;
import chanwoo.recipe.project.domain.UnitOfMeasure;
import chanwoo.recipe.project.repository.CategoryRepository;
import chanwoo.recipe.project.repository.RecipeRepository;
import chanwoo.recipe.project.repository.UnitOfMeasureRepository;
import chanwoo.recipe.project.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"index.html", "/", "", "index"})
    public String getIndexPage(Model model){
        model.addAttribute("recipes", recipeService.getRecipes());

        return "index";
    }
}