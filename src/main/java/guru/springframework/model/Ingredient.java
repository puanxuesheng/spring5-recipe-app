package guru.springframework.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Ingredient {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String description;
    private BigDecimal amount;

//    @OneToOne(cascade = CascadeType.ALL)
    @OneToOne(fetch = FetchType.EAGER)
    private UnitOfMeasure uom;

    @ManyToOne
    private Recipe recipe;

    //getters and setters

    public UnitOfMeasure getUom() {
        return uom;
    }

    public void setUom(UnitOfMeasure uom) {
        this.uom = uom;
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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}
