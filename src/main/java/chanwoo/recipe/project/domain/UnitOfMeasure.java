package chanwoo.recipe.project.domain;

import javax.persistence.*;

@Entity
public class UnitOfMeasure {
    private String description;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "unitOfMeasure")
    private Ingredient ingredient;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
