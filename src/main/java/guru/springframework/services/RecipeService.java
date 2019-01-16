package guru.springframework.services;

import guru.springframework.domain.Recipe;
import guru.springframework.domain.UnitOfMeasure;
import guru.springframework.repositories.RecipeRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RecipeService  {

  private final RecipeRepository recipeRepository;
  private final UnitOfMeasureRepository unitOfMeasureRepository;

  public RecipeService(RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
    this.recipeRepository = recipeRepository;
    this.unitOfMeasureRepository = unitOfMeasureRepository;
  }

  public List<Recipe> getRecipes(){
    return iterableToCollection(recipeRepository.findAll());
  }

  public Recipe save(Recipe recipe){
    return recipeRepository.save(recipe);
  }

  public Optional<UnitOfMeasure> findByDescription(String description){
    return unitOfMeasureRepository.findByDescription(description);
  }

  private static <T> List<T> iterableToCollection(Iterable<T> iterable) {
    List<T> collection = new ArrayList<>();
    iterable.forEach(collection::add);
    return collection;
  }

}
