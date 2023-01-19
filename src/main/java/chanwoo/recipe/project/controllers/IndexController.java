package chanwoo.recipe.project.controllers;

import chanwoo.recipe.project.domain.Category;
import chanwoo.recipe.project.domain.UnitOfMeasure;
import chanwoo.recipe.project.repository.CategoryRepository;
import chanwoo.recipe.project.repository.RecipeRepository;
import chanwoo.recipe.project.repository.UnitOfMeasureRepository;
import chanwoo.recipe.project.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Slf4j
@Controller
public class IndexController {

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping
    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model) {
        log.debug("Getting Index page");

        model.addAttribute("recipes", recipeService.getRecipes());

        return "index";
    }
}