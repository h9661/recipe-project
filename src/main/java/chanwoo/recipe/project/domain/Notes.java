package chanwoo.recipe.project.domain;

import javax.persistence.*;

@Entity
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "notes")
    private Recipe recipe;

    @Lob
    private String recipeNotes;
}
