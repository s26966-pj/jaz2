package pl.pjatk.MovieService.movie.model;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import pl.pjatk.MovieService.movie.enums.Category;

@Entity
public class Movie {
    @Schema(description = "ID of the movie")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Schema(description = "Name of the movie")
    private String name;
    @Schema(description = "Category of the movie")
    @Enumerated(EnumType.STRING)
    private Category category;
    @Schema(description = "Availability of the movie")
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
