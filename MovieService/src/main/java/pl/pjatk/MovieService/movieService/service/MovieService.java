package pl.pjatk.MovieService.movieService.service;

import org.springframework.stereotype.Service;
import pl.pjatk.MovieService.exceptions.BadRequestException;
import pl.pjatk.MovieService.exceptions.MovieNotFoundException;
import pl.pjatk.MovieService.movieService.repository.MovieRepository;
import pl.pjatk.MovieService.movieService.storage.MovieStorage;
import pl.pjatk.MovieService.movie.model.Movie;

import java.util.List;

@Service
public class MovieService {
    private final MovieStorage movieStorage;
    private final MovieRepository movieRepository;
    public MovieService(MovieStorage movieStorage, MovieRepository movieRepository) {
        this.movieStorage = movieStorage;
        this.movieRepository = movieRepository;
    }

    public List<Movie> getMovieList() {
        return movieStorage.getMovieList();
    }

    public void addMovie(Movie movie) {
        movieStorage.addMovie(movie);
    }

    public Movie findMovieById(int id) {
        return movieRepository.findById(id)
                .orElseThrow(MovieNotFoundException::new);
    }
    public void updateMovie(int id, Movie newMovie) {
        Movie movie = movieStorage.getMovieList().stream().filter(m -> m.getId() == id).findFirst()
                .orElseThrow(BadRequestException::new);
        int index = movieStorage.getMovieList().indexOf(movie);
        movieStorage.getMovieList().set(index,newMovie);
    }

    public void deleteMovie(int id) {
        movieRepository.deleteById(id);
    }
}
