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
        return movieRepository.findAll();
    }

    public void addMovie(Movie movie) {
        movieRepository.save(movie);
    }

    public Movie findMovieById(int id) {
        return movieRepository.findById(id)
                .orElseThrow(MovieNotFoundException::new);
    }

    public void updateMovie(int id, Movie movie) {
        if (movieRepository.findById(id).isPresent()){
            movieRepository.save(movie);
        }
    }

    public void deleteMovie(int id) {
        movieRepository.deleteById(id);
    }

    public void setAsAvailable(int id) {
        Movie m = movieRepository.findById(id).orElseThrow(MovieNotFoundException::new);
        m.updateAvailability(true);
        movieRepository.save(m);
    }

    public void setAsUnavailable(int id) {
        Movie m = movieRepository.findById(id).orElseThrow(MovieNotFoundException::new);
        m.updateAvailability(false);
        movieRepository.save(m);
    }
}
