package chanwoo.recipe.project.repository;

import chanwoo.recipe.project.domain.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, Long> {

}
