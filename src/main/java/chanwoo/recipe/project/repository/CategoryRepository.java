package chanwoo.recipe.project.repository;

import chanwoo.recipe.project.domain.Category;
import org.springframework.data.repository.CrudRepository;


public interface CategoryRepository extends CrudRepository<Category, Long> {
}
