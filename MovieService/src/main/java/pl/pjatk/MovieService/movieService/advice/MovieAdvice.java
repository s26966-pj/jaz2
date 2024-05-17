package pl.pjatk.MovieService.movieService.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pl.pjatk.MovieService.exceptions.BadRequestException;
import pl.pjatk.MovieService.exceptions.MovieNotFoundException;

@RestControllerAdvice
public class MovieAdvice {

    @ExceptionHandler(MovieNotFoundException.class)
    public ResponseEntity<String> handleMovieNotFoundException(MovieNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Exception occurred. Exception message: " + ex.getLocalizedMessage());
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<String> handleBadRequestException(BadRequestException ex) {
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Exception occurred. Exception message: " + ex.getLocalizedMessage());
    }
}
