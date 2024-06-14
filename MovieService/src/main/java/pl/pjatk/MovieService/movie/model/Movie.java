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

    @Column(name="is_available")
    private Boolean isAvailable;

    public Movie(Integer id, String name, Category category, Boolean isAvailable) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.isAvailable = isAvailable;
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

    public Boolean getIsAvailable() {
        return isAvailable;
    }

    public void updateAvailability(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}
