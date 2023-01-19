package chanwoo.recipe.project.services;

import chanwoo.recipe.project.commands.RecipeCommand;
import chanwoo.recipe.project.converters.RecipeCommandToRecipe;
import chanwoo.recipe.project.converters.RecipeToRecipeCommand;
import chanwoo.recipe.project.domain.Recipe;
import chanwoo.recipe.project.repository.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final RecipeCommandToRecipe recipeCommandToRecipe;
    private final RecipeToRecipeCommand recipeToRecipeCommand;

    public RecipeServiceImpl(RecipeRepository recipeRepository,
                             RecipeCommandToRecipe recipeCommandToRecipe,
                             RecipeToRecipeCommand recipeToRecipeCommand) {
        this.recipeRepository = recipeRepository;
        this.recipeCommandToRecipe = recipeCommandToRecipe;
        this.recipeToRecipeCommand = recipeToRecipeCommand;
    }

    @Override
    public Recipe save(Recipe recipe){
        return recipeRepository.save(recipe);
    }

    @Override
    public Set<Recipe> getRecipes() {
        log.debug("Im in the service");

        Set<Recipe> recipeSet = new HashSet<>();

        recipeRepository.findAll().forEach(recipe -> recipeSet.add(recipe));

        return recipeSet;
    }

    @Override
    public Recipe findById(Long iD){
        Optional<Recipe> recipeOptional = recipeRepository.findById(iD);

        if(!recipeOptional.isPresent()){
            throw new RuntimeException("Recipe Not Found!");
        }

        return recipeOptional.get();
    }

    @Override
    @Transactional
    public RecipeCommand findCommandById(Long Id) {
        return recipeToRecipeCommand.convert(findById(Id));
    }

    @Override
    public void deleteById(Long Id) {
        recipeRepository.deleteById(Id);
    }

    @Override
    @Transactional
    public RecipeCommand saveRecipeCommand(RecipeCommand recipeCommand) {
        Recipe recipe = recipeCommandToRecipe.convert(recipeCommand);

        return recipeToRecipeCommand.convert(recipeRepository.save(recipe));
    }
}
