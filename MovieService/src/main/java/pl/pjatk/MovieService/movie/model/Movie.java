package pl.pjatk.MovieService.movie.model;

import jakarta.persistence.*;
import pl.pjatk.MovieService.movie.enums.Category;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Category category;

    public Movie(Integer id, String name, Category category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    public Movie() {

    }

    public Category getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }
}
