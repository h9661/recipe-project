package chanwoo.recipe.project.repository;

import chanwoo.recipe.project.domain.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface CategoryRepository extends CrudRepository<Category, Long> {

    Optional<Category> findByDescription(String descripsion);
}
