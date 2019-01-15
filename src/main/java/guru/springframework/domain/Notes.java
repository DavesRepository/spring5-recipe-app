package guru.springframework.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

@Entity
public class Notes {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long io;

  @OneToOne
  private Recipe recipe;

  //because a string is huge, and by default hibernate only stores 255 chars.
  //so we need to specify this as a @Log so it will be stored in a clob (Characterr Large Object)

  @Lob
  private String recipeNotes;

  public Long getIo() {
    return io;
  }

  public void setIo(Long io) {
    this.io = io;
  }

  public Recipe getRecipe() {
    return recipe;
  }

  public void setRecipe(Recipe recipe) {
    this.recipe = recipe;
  }

  public String getRecipeNotes() {
    return recipeNotes;
  }

  public void setRecipeNotes(String recipeNotes) {
    this.recipeNotes = recipeNotes;
  }
}
