package pl.pjatk.MovieService.movieService.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.MovieService.movieService.service.MovieService;
import pl.pjatk.MovieService.movie.model.Movie;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getMovies() {
        return ResponseEntity.ok(movieService.getMovieList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable int id) {
        return ResponseEntity.ok(movieService.findMovieById(id));
    }

    @PostMapping
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        movieService.addMovie(movie);
        return ResponseEntity.ok(movie);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(@RequestBody Movie movie, @PathVariable int id) {
        movieService.updateMovie(id, movie);
        return ResponseEntity.ok(movie);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable int id) {
        movieService.deleteMovie(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/return/{id}")
    public ResponseEntity<Movie> setAvailable(@PathVariable int id) {
        movieService.setAsAvailable(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/rent/{id}")
    public ResponseEntity<Movie> setUnavailable(@PathVariable int id) {
        movieService.setAsUnavailable(id);
        return ResponseEntity.noContent().build();
    }
}
