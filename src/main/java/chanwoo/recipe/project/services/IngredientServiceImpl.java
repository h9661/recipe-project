package chanwoo.recipe.project.services;

import chanwoo.recipe.project.domain.Ingredient;
import chanwoo.recipe.project.repository.IngredientRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IngredientServiceImpl implements IngredientService {
    private final IngredientRepository ingredientRepository;

    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public Ingredient findById(Long id) {
        Optional<Ingredient> ingredientOptional = ingredientRepository.findById(id);

        if(ingredientOptional.isPresent())
            return ingredientOptional.get();
        else
            return null;
    }
}
