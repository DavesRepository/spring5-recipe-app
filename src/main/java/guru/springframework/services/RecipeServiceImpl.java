package guru.springframework.services;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {

  private final RecipeRepository recipeRepository;


  public RecipeServiceImpl(RecipeRepository recipeRepository) {
    this.recipeRepository = recipeRepository;
  }

  @Override
  public List<Recipe> getRecipes(){
    return iterableToCollection(recipeRepository.findAll());
  }

  private static <T> List<T> iterableToCollection(Iterable<T> iterable) {
    List<T> collection = new ArrayList<>();
    iterable.forEach(collection::add);
    return collection;
  }
}
