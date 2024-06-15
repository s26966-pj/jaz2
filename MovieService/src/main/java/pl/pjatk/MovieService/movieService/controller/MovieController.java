package pl.pjatk.MovieService.movieService.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
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

    @ApiResponses({
            @ApiResponse(responseCode = "200",description = "Movies returned successfully"),
            @ApiResponse(responseCode = "404",description = "Movie not found", content = @Content()),
            @ApiResponse(responseCode = "500",description = "Internal server error", content = @Content()),
    })
    @Operation(summary = "Returns all movies")
    @GetMapping
    public ResponseEntity<List<Movie>> getMovies() {
        return ResponseEntity.ok(movieService.getMovieList());
    }

    @Operation(summary = "Returns specific movie")
    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable int id) {
        return ResponseEntity.ok(movieService.findMovieById(id));
    }

    @Operation(summary = "Adds new movie")
    @PostMapping
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        movieService.addMovie(movie);
        return ResponseEntity.ok(movie);
    }

    @Operation(summary = "Updates movie")
    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(@RequestBody Movie movie, @PathVariable int id) {
        movieService.updateMovie(id, movie);
        return ResponseEntity.ok(movie);
    }

    @Operation(summary = "Deletes movie")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable int id) {
        movieService.deleteMovie(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Sets movie as available")
    @PatchMapping("/return/{id}")
    public ResponseEntity<Movie> setAvailable(@PathVariable int id) {
        movieService.setAsAvailable(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Sets movie as unavailable")
    @PatchMapping("/rent/{id}")
    public ResponseEntity<Movie> setUnavailable(@PathVariable int id) {
        movieService.setAsUnavailable(id);
        return ResponseEntity.noContent().build();
    }
}
