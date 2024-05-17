package pl.pjatk.MovieService.movie.model;

import pl.pjatk.MovieService.movie.enums.Category;

public class Movie {
    final private int id;
    final private String name;

    final private Category category;

    public Movie(int id, String name, Category category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
