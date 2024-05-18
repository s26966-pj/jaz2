package pl.pjatk.MovieService.movieService.storage;

import org.springframework.stereotype.Component;
import pl.pjatk.MovieService.movie.enums.Category;
import pl.pjatk.MovieService.movie.model.Movie;

import java.util.ArrayList;
import java.util.List;

@Component
public class MovieStorage {
    private List<Movie> movieList;

    public MovieStorage() {

    }

    public void addMovie(Movie movie) {
        movieList.add(movie);
    }

    public void deleteMovie(Movie movie) {
        movieList.remove(movie);
    }
    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }

}
