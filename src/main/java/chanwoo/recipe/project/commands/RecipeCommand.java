package chanwoo.recipe.project.commands;

import chanwoo.recipe.project.domain.Category;
import chanwoo.recipe.project.domain.Difficulty;
import chanwoo.recipe.project.domain.Ingredient;
import chanwoo.recipe.project.domain.Notes;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class RecipeCommand {
    private Long id;
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
    private String directions;
    private Set<Ingredient> ingredients = new HashSet<>();
    private Difficulty difficulty;
    private Notes notes;
    private Set<Category> categories = new HashSet<>();
}
