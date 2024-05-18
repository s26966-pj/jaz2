package pl.pjatk.MovieService.movieService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pjatk.MovieService.movie.model.Movie;

import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    Optional<Movie> findById(Integer id);
    void deleteMovieById(Integer id);

}
