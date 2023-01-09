package chanwoo.recipe.project.repository;

import chanwoo.recipe.project.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
