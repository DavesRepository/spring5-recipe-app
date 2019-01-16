package guru.springframework.bootstrap;

import guru.springframework.domain.Difficulty;
import guru.springframework.domain.Ingredient;
import guru.springframework.domain.Notes;
import guru.springframework.domain.Recipe;
import guru.springframework.domain.UnitOfMeasure;
import guru.springframework.repositories.RecipeRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Optional;

@Component
public class RecipeBootstrap implements CommandLineRunner {

  private final RecipeRepository recipeRepository;
  private final UnitOfMeasureRepository unitOfMeasureRepository;

  public RecipeBootstrap(RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
    this.recipeRepository = recipeRepository;
    this.unitOfMeasureRepository = unitOfMeasureRepository;
  }

  @Override
  public void run(String... args) {
    final ArrayList<Recipe> recipes = new ArrayList<>();
    recipes.add(createSpiceyGrilledChcikenTacosRecipe());
    recipes.add(createGuacamoleRecipe());
    recipeRepository.saveAll(recipes);
  }

  private Recipe createSpiceyGrilledChcikenTacosRecipe(){
    final Recipe recipe = new Recipe();
    recipe.setDescription("Spicy Grilled Chicken Tacos Recipe");
    recipe.setUrl("https://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/");
    recipe.setCookTime(15);
    recipe.setPrepTime(20);
    recipe.setServings(4);
    recipe.setDifficulty(Difficulty.MODERATE);
    recipe.setSource("Sally Vargas; A freelance writer and the author of three cookbooks ");
    recipe.setNotes(createNotes(
        recipe,
        "<p><b>11 Prepare a gas or charcoal grill for medium-high, direct heat</b></p>" +
            "" +
        "<p><b>2 Make the marinade and coat the chicken:</b> In a large bowl, stir together the chili powder, oregano, cumin," +
        "  sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to" +
        "  the bowl and toss to coat all over.</p>" +
        "<p>Set aside to marinate while the grill heats and you prepare the rest of the toppings.</p>" +
        "" +
        "<p><b>3 Grill the chicken:</b> Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the" +
        "  thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes.</p>" +
        "" +
        "<p><b>4 Warm the tortillas:</b> Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon" +
        "  as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the" +
        "  other side.</p>" +
        "" +
        "<p>Wrap warmed tortillas in a tea towel to keep them warm until serving.</p>" +
        "" +
        "<p><b>5 Assemble the tacos:</b> Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top" +
        "  with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve" +
        "  with lime wedges.</p>"));

    //ingredients
    recipe.getIngredients().add(createIngredient(recipe, "2", findUOM("Tablespoon"), "ancho chili powder"));
    recipe.getIngredients().add(createIngredient(recipe, "1", findUOM("Teaspoon"), "dried oregano"));
    recipe.getIngredients().add(createIngredient(recipe, "1", findUOM("Teaspoon"), "dried cumin"));
    recipe.getIngredients().add(createIngredient(recipe, "1", findUOM("Teaspoon"), "sugar"));
    recipe.getIngredients().add(createIngredient(recipe, "0.5", findUOM("Teaspoon"), "salt"));
    recipe.getIngredients().add(createIngredient(recipe, "1", findUOM("Clove"), "garlic, finely chopped"));
    recipe.getIngredients().add(createIngredient(recipe, "1", findUOM("Tablespoon"), "finely grated orange zest"));
    recipe.getIngredients().add(createIngredient(recipe, "3", findUOM("Tablespoon"), "fresh-squeezed orange juice"));
    recipe.getIngredients().add(createIngredient(recipe, "5", "skinless, boneless chicken thighs (1 1/4 pounds)"));

    //to serve
    recipe.getIngredients().add(createIngredient(recipe, "5", "small corn tortillas"));
    recipe.getIngredients().add(createIngredient(recipe, "3", "3 cups packed baby arugula (3 ounces)"));
    recipe.getIngredients().add(createIngredient(recipe, "2", "2 medium ripe avocados, sliced"));
    recipe.getIngredients().add(createIngredient(recipe, "4", "4 radishes, thinly sliced"));
    recipe.getIngredients().add(createIngredient(recipe, "0.5", findUOM("Pint"), "cherry tomatoes, halved"));
    recipe.getIngredients().add(createIngredient(recipe, "0.25", "red onion, thinly sliced"));
    recipe.getIngredients().add(createIngredient(recipe, "1", "Roughly chopped cilantro"));
    recipe.getIngredients().add(createIngredient(recipe, "0.5", findUOM("Cup"), "sour cream thinned with 1/4 cup milk"));
    recipe.getIngredients().add(createIngredient(recipe, "1", "lime, cut into wedges"));

    return recipe;
  }

  private Recipe createGuacamoleRecipe() {
    final Recipe recipe = new Recipe();
    recipe.setDescription("How to Make Perfect Guacamole Recipe");
    recipe.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole/");
    recipe.setCookTime(0);
    recipe.setPrepTime(10);
    recipe.setServings(2);
    recipe.setDifficulty(Difficulty.EASY);
    recipe.setSource("Elise Bauer;  The founder of Simply Recipes");
    recipe.setNotes(createNotes(
        recipe,
        "<p><b>1 Cut avocado, remove flesh:</b> Cut the avocados in half. Remove seed. " +
        "Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. " +
        "Place in a bowl. </p>" +
        "<p><b>2 Mash with a fork:</b> Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.) </p>" +
        "<p><b>3 Add salt, lime juice, and the rest:</b> Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will " +
        "provide some balance to the richness of the avocado and will help delay the avocados from turning brown.</p> " +
        "<p>Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. " +
        "So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness. </p>" +
        "<p>Remember that much of this is done to taste because of the variability in the fresh ingredients. " +
        "Start with this recipe and adjust to your taste. </p>" +
        "<p><b>4 Cover with plastic and chill to store:</b> Place plastic wrap on the surface of the guacamole cover it and to " +
        "prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) " +
        "Refrigerate until ready to serve. </p>"));

    recipe.getIngredients().add(createIngredient(recipe, "2", "ripe advocados"));
    recipe.getIngredients().add(createIngredient(recipe, "0.5", findUOM("Teaspoon"), "ripe advocados"));
    recipe.getIngredients().add(createIngredient(recipe, "1", findUOM("Tablespoon"), "fresh lime juice or lemon juice"));
    recipe.getIngredients().add(createIngredient(recipe, "3", findUOM("Tablespoon"), "minced red onion or thinly sliced green onion"));
    recipe.getIngredients().add(createIngredient(recipe, "2", "serrano chiles, stems and seeds removed, minced"));
    recipe.getIngredients().add(createIngredient(recipe, "2", "tablespoons cilantro (leaves and tender stems), finely chopped"));
    recipe.getIngredients().add(createIngredient(recipe, "1", findUOM("Dash"), "freshly grated black pepper"));
    recipe.getIngredients().add(createIngredient(recipe, "0.5", "ripe tomato, seeds and pulp removed, chopped"));

   return recipe;
  }

  private UnitOfMeasure findUOM(String description) {
    final Optional<UnitOfMeasure> optionalTeaspoon = unitOfMeasureRepository.findByDescription(description);
    if (optionalTeaspoon.isPresent()){
      return optionalTeaspoon.get();
    } else{
      throw new IllegalArgumentException("could not find Unit of measeure!!");
    }
  }

  private Notes createNotes(Recipe recipe, String recipeNotes) {
    final Notes notes = new Notes();
    notes.setRecipe(recipe);
    notes.setRecipeNotes(recipeNotes);
    return notes;
  }

  private Ingredient createIngredient(Recipe recipe, String amount, UnitOfMeasure unitOfMeasure, String description) {
    final Ingredient ingredient = new Ingredient();
    ingredient.setRecipe(recipe);
    ingredient.setAmount(new BigDecimal(amount));
    ingredient.setDescription(description);
    ingredient.setUom(unitOfMeasure);
    return ingredient;
  }
  private Ingredient createIngredient(Recipe recipe, String amount, String description) {
    return createIngredient(recipe, amount, null, description);
  }
}
