package pl.pjatk.RentalService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import java.net.ConnectException;

@RestControllerAdvice
public class RentalAdvice {
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

    @ExceptionHandler
    public ResponseEntity<String> handleInternalServerError(HttpServerErrorException.InternalServerError exception) {
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("Bad Gateway");
    }

    @ExceptionHandler
    public ResponseEntity<String> handleConnectException(ConnectException exception) {
        return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT).body("Gateway Timeout");
    }

}