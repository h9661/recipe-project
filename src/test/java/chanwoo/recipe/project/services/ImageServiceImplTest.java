package chanwoo.recipe.project.services;

import chanwoo.recipe.project.commands.IngredientCommand;
import chanwoo.recipe.project.commands.RecipeCommand;
import chanwoo.recipe.project.domain.Ingredient;
import chanwoo.recipe.project.domain.Recipe;
import chanwoo.recipe.project.repository.RecipeRepository;
import chanwoo.recipe.project.services.IngredientService;
import chanwoo.recipe.project.services.RecipeService;
import chanwoo.recipe.project.services.UnitOfMeasureService;
import net.bytebuddy.asm.Advice;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ImageServiceImplTest {
    @Mock
    RecipeRepository recipeRepository;

    ImageService imageService;

    @BeforeEach
    void setUp() {
        imageService = new ImageServiceImpl(recipeRepository);
    }

    @Test
    void saveImageFile() {
        MultipartFile multipartFile = new MockMultipartFile("imagefile", "test.txt", "text/plain",
                "chanwoo".getBytes());

        Recipe recipe = new Recipe();
        recipe.setId(1L);

        when(recipeRepository.findById(anyLong())).thenReturn(Optional.of(recipe));

        imageService.saveImageFile(1L, multipartFile);

        ArgumentCaptor<Recipe> argumentCaptor = ArgumentCaptor.forClass(Recipe.class);

        verify(recipeRepository, times(1)).save(argumentCaptor.capture());


        try {
            assertEquals(multipartFile.getBytes().length, argumentCaptor.getValue().getImage().length);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}