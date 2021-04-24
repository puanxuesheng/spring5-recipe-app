package guru.springframework.model;

import javax.persistence.*;
import java.util.Set;


@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
    private String direction;
    //todo add...
    //private Difficulty difficulty;


    /**
     * The mappedBy is defined the foreign key that is
     * written in the other table (Ingredient). The foreign key that
     * we are mapping to in this case is recipe.
     * */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Set<Ingredient> ingredients;

    //large object storage.
    @Lob
    private Byte[] image;

    /**
     * we are defining casading operation here
     * Useful when we want to set Recipe as the owner
     * for the data storage. So wehen we delete a recipe
     * The deletion gets cascaded down to notes and it
     * will be deleted.
     * Since we did not mentioned Cascade in the note POJO
     * Deleting a note will not delete a recipe.
    * */
    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;

    /**
     * The EnumType defaults to Ordinal. This will save the
     * number value for enum. If you want to save the actual
     * string value of the enum u must use STRING
     * */
    @Enumerated(value=EnumType.STRING)
    private Difficulty difficulty;

    @ManyToMany
    @JoinTable(name="recipe_catergoy"
            ,joinColumns = @JoinColumn(name="recipe_id")
            ,inverseJoinColumns = @JoinColumn(name="category_id"))
    private Set<Category> categories;

    //getters and setters

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(Integer prepTime) {
        this.prepTime = prepTime;
    }

    public Integer getCookTime() {
        return cookTime;
    }

    public void setCookTime(Integer cookTime) {
        this.cookTime = cookTime;
    }

    public Integer getServings() {
        return servings;
    }

    public void setServings(Integer servings) {
        this.servings = servings;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Byte[] getImage() {
        return image;
    }

    public void setImage(Byte[] image) {
        this.image = image;
    }

    public Notes getNotes() {
        return notes;
    }

    public void setNotes(Notes notes) {
        this.notes = notes;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}
